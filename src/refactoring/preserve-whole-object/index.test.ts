import { checkIfTemperatureIsInRange } from "./index"

describe("checkIfTemperatureIsInRange", () => {
  test("Works correctly.", () => {
    expect(checkIfTemperatureIsInRange({ daysTempRange: { high: 29, low: 26 } })).toEqual(true)
  })
  test("Works correctly.", () => {
    expect(checkIfTemperatureIsInRange({ daysTempRange: { high: 31, low: 26 } })).toEqual(false)
  })
  test("Works correctly.", () => {
    expect(checkIfTemperatureIsInRange({ daysTempRange: { high: 29, low: 22 } })).toEqual(false)
  })
  test("Works correctly.", () => {
    expect(checkIfTemperatureIsInRange({ daysTempRange: { high: 28, low: 28 } })).toEqual(true)
  })
})
