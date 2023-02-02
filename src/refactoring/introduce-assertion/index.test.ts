import { getCustomer } from "./index"

describe("A customer and their discount.", () => {
  test("A discount is applied correctly to a customer", () => {
    expect(getCustomer().applyDiscount({ itemPrice: 100 })).toEqual<number>(90)

    expect(() => {
      expect(getCustomer().applyDiscount({ itemPrice: -100 }))
    }).toThrowError()

    expect(() => {
      getCustomer().discountRate = -0.2
    }).toThrowError()

    expect(() => {
      getCustomer().discountRate = -12
    }).toThrowError()

    expect(() => {
      getCustomer().discountRate = -1.01
    }).toThrowError()

    expect(getCustomer().applyDiscount({ itemPrice: 100 })).toEqual<number>(90)
  })
})
