import { getOrder1, getOrder2 } from "./index"

describe("Order and customer.", () => {
  test("Each order with the same customer has the same customer field instance.", () => {
    expect(getOrder1().customer.id).toEqual(20)
    expect(getOrder2().customer.id).toEqual(20)
    expect(getOrder1().customer).toBe(getOrder2().customer)
  })
})
