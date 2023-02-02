import { getActionToPerform } from "./index"

describe("Thermostat", () => {
  test("An action for termostat to perform is calculated correctly.", () => {
    expect(getActionToPerform({ selectedTemperature: 20 })).toEqual("set-to-heat")
    expect(getActionToPerform({ selectedTemperature: 40 })).toEqual("set-to-cool")
    expect(getActionToPerform({ selectedTemperature: 26 })).toEqual("set-off")
  })
})
