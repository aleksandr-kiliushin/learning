export type BillingPlan = {
  price: number
  type: string
}

export const registry = {
  billingPlans: {
    basic: { price: 1000, type: "basic" },
  },
}

type CustomerData = {
  billingPlan: BillingPlan
  name: string
  paymentHistory: {
    weeksDelinquentInLastYear: number
  }
}

class NullPaymentHistory {
  get weeksDelinquentInLastYear() {
    return 0
  }
}

export class Customer {
  private _data: CustomerData
  constructor(data: CustomerData) {
    this._data = data
  }
  get billingPlan() {
    return this._data.billingPlan
  }
  set billingPlan(newPlan: BillingPlan) {
    this._data.billingPlan = newPlan
  }
  get isUnknown() {
    return false
  }
  get name() {
    return this._data.name
  }
  get paymentHistory() {
    return this._data.paymentHistory
  }
}

class UnknownCustomer {
  get isUnknown() {
    return true
  }
  get name(): Customer["name"] {
    return "occupant"
  }
  get billingPlan(): Customer["billingPlan"] {
    return registry.billingPlans.basic
  }
  set billingPlan(newValue) {}
  get paymentHistory(): Customer["paymentHistory"] {
    return new NullPaymentHistory()
  }
}

type SiteData = {
  customer: Customer | "Unknown"
}

export class Site {
  private _data: SiteData
  constructor(data: SiteData) {
    this._data = data
  }
  get customer() {
    return this._data.customer === "Unknown" ? new UnknownCustomer() : this._data.customer
  }
}

export const getSiteCustomerName = ({ aSite }: { aSite: Site }) => {
  return aSite.customer.name
}

export const getSiteCustomerBillingPlan = ({ aSite }: { aSite: Site }) => {
  return aSite.customer.billingPlan
}

export const setSiteCustomerBillingPlan = ({
  aSite,
  newBillingPlan,
}: {
  aSite: Site
  newBillingPlan: BillingPlan
}) => {
  aSite.customer.billingPlan = newBillingPlan
}

export const getSiteCustomerWeeksDelinquent = ({ aSite }: { aSite: Site }) => {
  return aSite.customer.paymentHistory.weeksDelinquentInLastYear
}
