import calculateCharge from "./index"

describe("calculateCharge", () => {
  test("Charge calculates correctly.", () => {
    expect(calculateCharge({ monthNumber: 3, quantity: 123 })).toEqual<number>(247.25)
    expect(calculateCharge({ monthNumber: 7, quantity: 5 })).toEqual<number>(20)
  })
})
