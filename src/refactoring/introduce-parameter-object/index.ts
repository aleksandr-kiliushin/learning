export type Station = {
  name: string
  readings: { temp: number; time: string }[]
}

export type OperatingPlan = {
  temperatureFloor: number
  temperatureCeiling: number
}

export class NumberRange {
  private _data: { min: number; max: number }
  constructor(min: number, max: number) {
    this._data = { min, max }
  }
  get min() {
    return this._data.min
  }
  get max() {
    return this._data.max
  }
  includes(aNumber: number) {
    return this.min < aNumber && aNumber < this.max
  }
}

const findReadingOutsideRange = (station: Station, range: NumberRange) => {
  return station.readings.filter(({ temp }) => !range.includes(temp))
}

export default findReadingOutsideRange
