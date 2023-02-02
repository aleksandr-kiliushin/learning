import { getCharge } from "./index"

describe("Charge.", () => {
  test("Charge is calculated correctly.", () => {
    expect(getCharge()).toEqual(170)
  })
})
