import R from "ramda"

type Adjustment = {
  amount: number
}

export type ProductionPlanData = {
  adjustments: Adjustment[]
  production: number
}

class ProductionPlan {
  private _data: ProductionPlanData
  constructor(data: ProductionPlanData) {
    this._data = data
  }
  get production() {
    return this._data.adjustments.reduce((accumulator, anAdjustment) => {
      return accumulator + anAdjustment.amount
    }, 0)
  }
  get adjustments() {
    return R.clone(this._data.adjustments)
  }
  applyAdjustment({ anAdjustment }: { anAdjustment: Adjustment }) {
    this._data.adjustments.push(anAdjustment)
  }
}

const aProductionPlan = new ProductionPlan({
  adjustments: [{ amount: 12 }, { amount: 23 }, { amount: 34 }, { amount: 45 }],
  production: 114,
})

export const getProductionPlan = (): ProductionPlan => {
  return aProductionPlan
}
