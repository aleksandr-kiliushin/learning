import { getProductionPlan, ProductionPlanData } from "./index"

describe("Prodcution plan", () => {
  test("Production plan is works correctly.", () => {
    expect(getProductionPlan().production).toEqual<ProductionPlanData["production"]>(114)
    expect(getProductionPlan().adjustments).toEqual<ProductionPlanData["adjustments"]>([
      { amount: 12 },
      { amount: 23 },
      { amount: 34 },
      { amount: 45 },
    ])

    getProductionPlan().applyAdjustment({ anAdjustment: { amount: 56 } })
    expect(getProductionPlan().production).toEqual<ProductionPlanData["production"]>(170)
    expect(getProductionPlan().adjustments).toEqual<ProductionPlanData["adjustments"]>([
      { amount: 12 },
      { amount: 23 },
      { amount: 34 },
      { amount: 45 },
      { amount: 56 },
    ])
  })
})
