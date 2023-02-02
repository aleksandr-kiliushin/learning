import { getAccount1, getAccount2 } from "./index"

describe("Account interest rate", () => {
  test("Account interest rate is read correctly.", () => {
    expect(getAccount1().interestRate).toEqual(0.12)
    expect(getAccount2().interestRate).toEqual(0.18)
  })
})
