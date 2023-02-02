export type Order = {
  itemPrice: number
  quantity: number
}

const calculatePrice = ({ anOrder }: { anOrder: Order }): number => {
  const { itemPrice, quantity } = anOrder
  const basePrice = quantity * itemPrice
  const quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05
  const shippingPrice = Math.min(basePrice * 0.1, 100)
  return basePrice - quantityDiscount + shippingPrice
}

export default calculatePrice
