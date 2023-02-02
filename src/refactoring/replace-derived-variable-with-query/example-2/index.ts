import R from "ramda"

type Adjustment = {
  amount: number
}

export type ProductionPlanData = {
  adjustments: Adjustment[]
  initialProduction: number
  productionAccumulator: number
}

export type ProductionPlanPayload = {
  production: number
}

class ProductionPlan {
  private _data: ProductionPlanData
  constructor(data: ProductionPlanPayload) {
    this._data = {
      adjustments: [],
      initialProduction: data.production,
      productionAccumulator: 0,
    }
  }

  get adjustments() {
    return R.clone(this._data.adjustments)
  }

  get production() {
    return this._data.initialProduction + this.calculatedProductionAccumulator
  }

  applyAdjustment({ anAdjustment }: { anAdjustment: Adjustment }) {
    this._data.adjustments.push(anAdjustment)
  }

  get calculatedProductionAccumulator() {
    return this._data.adjustments.reduce((accumulator, anAdjustment) => {
      return accumulator + anAdjustment.amount
    }, 0)
  }
}

const aProductionPlan = new ProductionPlan({
  production: 72,
})

export const getProductionPlan = (): ProductionPlan => {
  return aProductionPlan
}
