import {
  BillingPlan,
  Customer,
  getSiteCustomerBillingPlan,
  getSiteCustomerName,
  getSiteCustomerWeeksDelinquent,
  registry,
  setSiteCustomerBillingPlan,
  Site,
} from "./index"

const aSiteWithNonNullCustomer = new Site({
  customer: {
    billingPlan: { price: 3000, type: "Econom" },
    isUnknown: false,
    name: "Jane",
    paymentHistory: { weeksDelinquentInLastYear: 3 },
  },
})

const aSiteWithNullCustomer = new Site({ customer: "Unknown" })

describe("Site and its customer.", () => {
  test("getSiteCustomerBillingPlan", () => {
    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNonNullCustomer })).toEqual<BillingPlan>({
      price: 3000,
      type: "Econom",
    })

    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNullCustomer })).toEqual<BillingPlan>(
      registry.billingPlans.basic
    )
  })

  test("getSiteCustomerName", () => {
    expect(getSiteCustomerName({ aSite: aSiteWithNonNullCustomer })).toEqual<Customer["name"]>(
      "Jane"
    )

    expect(getSiteCustomerName({ aSite: aSiteWithNullCustomer })).toEqual<Customer["name"]>(
      "occupant"
    )
  })

  test("getSiteCustomerWeeksDelinquent", () => {
    expect(getSiteCustomerWeeksDelinquent({ aSite: aSiteWithNonNullCustomer })).toEqual<
      Customer["paymentHistory"]["weeksDelinquentInLastYear"]
    >(3)

    expect(getSiteCustomerWeeksDelinquent({ aSite: aSiteWithNullCustomer })).toEqual<
      Customer["paymentHistory"]["weeksDelinquentInLastYear"]
    >(0)
  })

  test("setSiteCustomerBillingPlan", () => {
    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNonNullCustomer })).toEqual<BillingPlan>({
      price: 3000,
      type: "Econom",
    })
    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNullCustomer })).toEqual<BillingPlan>(
      registry.billingPlans.basic
    )

    setSiteCustomerBillingPlan({
      aSite: aSiteWithNonNullCustomer,
      newBillingPlan: { price: 4000, type: "premium" },
    })
    setSiteCustomerBillingPlan({
      aSite: aSiteWithNullCustomer,
      newBillingPlan: { price: 4000, type: "premium" },
    })

    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNonNullCustomer })).toEqual<BillingPlan>({
      price: 4000,
      type: "premium",
    })
    expect(getSiteCustomerBillingPlan({ aSite: aSiteWithNullCustomer })).toEqual<BillingPlan>(
      registry.billingPlans.basic
    )
  })
})
