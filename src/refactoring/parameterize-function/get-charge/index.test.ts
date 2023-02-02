import calculateBaseCharge from "./index"

describe("calculateBaseCharge", () => {
  test("A base charge is calculated correctly.", () => {
    expect(calculateBaseCharge({ usage: 50 })).toEqual("$1.5")
    expect(calculateBaseCharge({ usage: 80 })).toEqual("$2.4")
    expect(calculateBaseCharge({ usage: 100 })).toEqual("$3")
    expect(calculateBaseCharge({ usage: 150 })).toEqual("$5.5")
    expect(calculateBaseCharge({ usage: 200 })).toEqual("$8")
    expect(calculateBaseCharge({ usage: 300 })).toEqual("$15")
  })
})
