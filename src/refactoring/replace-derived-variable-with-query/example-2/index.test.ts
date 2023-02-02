import { getProductionPlan, ProductionPlanData } from "./index"

describe("Prodcution plan", () => {
  test("Production plan is works correctly.", () => {
    expect(getProductionPlan().production).toEqual<number>(72)
    expect(getProductionPlan().adjustments).toEqual<ProductionPlanData["adjustments"]>([])

    getProductionPlan().applyAdjustment({ anAdjustment: { amount: 56 } })
    expect(getProductionPlan().production).toEqual<number>(72 + 56)
    expect(getProductionPlan().adjustments).toEqual<ProductionPlanData["adjustments"]>([
      { amount: 56 },
    ])
  })
})
