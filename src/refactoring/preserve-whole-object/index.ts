type TemperatureRange = {
  high: number
  low: number
}

type Room = {
  daysTempRange: TemperatureRange
}

type HeatingPlanData = {
  temperatureRange: TemperatureRange
}

class HeatingPlan {
  private _data: HeatingPlanData
  constructor(data: HeatingPlanData) {
    this._data = data
  }
  isWithinRange(aNumberRange: { high: number; low: number }) {
    return (
      aNumberRange.low >= this._data.temperatureRange.low &&
      aNumberRange.high <= this._data.temperatureRange.high
    )
  }
}

const aHeatingPlan = new HeatingPlan({
  temperatureRange: { high: 30, low: 25 },
})

export const checkIfTemperatureIsInRange = (aRoom: Room) => {
  return aHeatingPlan.isWithinRange(aRoom.daysTempRange)
}
