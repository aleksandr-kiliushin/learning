import { getDiscount } from "./index"

describe("Calculate discount", () => {
  test("It calculates correctly.", () => {
    expect(getDiscount()).toEqual(120)
  })
})
