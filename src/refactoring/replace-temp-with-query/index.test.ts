import { getOrder1, getOrder2 } from "./index"

describe("getOrderPrice", () => {
  test("Order price is calculated correctly.", () => {
    expect(getOrder1().price).toEqual(500.78)
    expect(getOrder2().price).toEqual(4329659.2)
  })
})
