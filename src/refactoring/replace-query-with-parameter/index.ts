type HeatingPlanData = {
  max: number
  min: number
}

const global_thermostatObject = {
  currentTemperature: 31,
  selectedTemperature: 26,
}

class HeatingPlan {
  private _data: HeatingPlanData
  constructor(data: HeatingPlanData) {
    this._data = data
  }
  get targetTemperature() {
    if (global_thermostatObject.selectedTemperature > this._data.max) return this._data.max
    else if (global_thermostatObject.selectedTemperature < this._data.min) return this._data.min
    else return global_thermostatObject.selectedTemperature
  }
}

const aHeatingPlan = new HeatingPlan({ max: 30, min: 25 })

export const getActionToPerform = ({
  selectedTemperature,
}: {
  selectedTemperature: number
}): "set-to-heat" | "set-to-cool" | "set-off" => {
  if (aHeatingPlan.targetTemperature > selectedTemperature) {
    return "set-to-heat"
  }
  if (aHeatingPlan.targetTemperature < selectedTemperature) {
    return "set-to-cool"
  }
  return "set-off"
}
