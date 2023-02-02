import calculatePrice, { Order } from "./index"

describe("calculatePrice works correctly.", () => {
  test.each<{
    order: Order
    calculatedPrice: number
  }>([
    {
      order: { itemPrice: 15, quantity: 10 },
      calculatedPrice: 165,
    },
    {
      order: { itemPrice: 1234.42, quantity: 482194981 },
      calculatedPrice: 565469602984.219,
    },
    {
      order: { itemPrice: 0, quantity: 3724 },
      calculatedPrice: 0,
    },
    {
      order: { itemPrice: 1234215.3, quantity: 0 },
      calculatedPrice: 0,
    },
  ])("For a driver with $inputNumber late deliveries.", ({ calculatedPrice, order }) => {
    expect(calculatePrice({ anOrder: order })).toEqual(calculatedPrice)
  })
})
