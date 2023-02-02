export type BillingPlan = {
  price: number
  type: string
}

export const registry = {
  billingPlans: {
    basic: { price: 1000, type: "basic" },
  },
}

export type Customer = {
  billingPlan: BillingPlan
  isUnknown: boolean
  name: string
  paymentHistory: {
    weeksDelinquentInLastYear: number
  }
}

const createUnknownCustomer = (): Customer => {
  return {
    billingPlan: registry.billingPlans.basic,
    isUnknown: true,
    name: "occupant",
    paymentHistory: {
      weeksDelinquentInLastYear: 0,
    },
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
    return this._data.customer === "Unknown" ? createUnknownCustomer() : this._data.customer
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
