import getPaymentAmount, { Result } from "./index"

describe("getPaymentAmount", () => {
  test("Payment amount is calculated correctly.", () => {
    expect(getPaymentAmount({ isRetired: true, isSeparated: false, salary: 3200 })).toEqual<Result>(
      { amount: 0, reasonCode: "RET" }
    )

    expect(getPaymentAmount({ isRetired: false, isSeparated: true, salary: 3500 })).toEqual<Result>(
      { amount: 0, reasonCode: "SEP" }
    )

    expect(
      getPaymentAmount({ isRetired: false, isSeparated: false, salary: 4500 })
    ).toEqual<Result>({ amount: 9000, reasonCode: "SUC" })
  })
})
