import getOrderPrice, { Order } from "./index"

describe("getOrderPrice", () => {
  test.each<{ order: Order; orderPrice: number }>([
    {
      order: {
        product: { basePrice: 6000, discountRate: 0.13, discountThreshold: 0.8 },
        quantity: 312,
        shippingMethod: { discountThreshold: 0.7, discountedFee: 0.5, feePerCase: 0.6 },
      },
      orderPrice: 1629420,
    },
    {
      order: {
        product: { basePrice: 45, discountRate: 0.26, discountThreshold: 0.8 },
        quantity: 312,
        shippingMethod: { discountThreshold: 0.1, discountedFee: 0.5, feePerCase: 0.6 },
      },
      orderPrice: 10554.96,
    },
  ])("TODO: Add description.", ({ order, orderPrice }) => {
    expect(getOrderPrice(order)).toEqual(orderPrice)
  })
})
