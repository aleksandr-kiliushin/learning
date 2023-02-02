import calculateAdjustedCapital from "./index"

describe("calculateAdjustedCapital", () => {
  test("Adjusted capital is calculated correctly.", () => {
    expect(
      calculateAdjustedCapital({
        adjustmentFactor: 100,
        capital: 0,
        duration: 100,
        income: 100,
        interestRate: 100,
      })
    ).toEqual<number>(0)

    expect(
      calculateAdjustedCapital({
        adjustmentFactor: 100,
        capital: 100,
        duration: 100,
        income: 100,
        interestRate: 0,
      })
    ).toEqual<number>(0)

    expect(
      calculateAdjustedCapital({
        adjustmentFactor: 100,
        capital: 100,
        duration: 0,
        income: 100,
        interestRate: 100,
      })
    ).toEqual<number>(0)

    expect(
      calculateAdjustedCapital({
        adjustmentFactor: 30,
        capital: 100,
        duration: 20,
        income: 100,
        interestRate: 100,
      })
    ).toEqual<number>(150)
  })
})
