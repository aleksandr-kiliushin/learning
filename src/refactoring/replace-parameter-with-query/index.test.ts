import { getOrder } from "./index"

describe("Order price", () => {
  test("A discounted price is calculated correctly.", () => {
    expect(getOrder().finalPrice).toEqual(3325)
    expect(getOrder().discountedPrice(3500)).toEqual(3325)
  })
})
