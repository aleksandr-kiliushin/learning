export type Product = {
  basePrice: number
  discountThreshold: number
  discountRate: number
}

export type ShippingMethod = {
  discountThreshold: number
  discountedFee: number
  feePerCase: number
}

export type Order = {
  product: Product
  quantity: number
  shippingMethod: ShippingMethod
}

const calculatePricingData = ({ product, quantity }: { product: Product; quantity: number }) => {
  const basePrice = product.basePrice * quantity
  const discount =
    Math.max(quantity - product.discountThreshold, 0) * product.basePrice * product.discountRate
  return { basePrice, discount }
}

const applyShipping = ({
  basePrice,
  discount,
  quantity,
  shippingMethod,
}: {
  basePrice: number
  discount: number
  quantity: number
  shippingMethod: ShippingMethod
}) => {
  const shippingPerCase =
    basePrice > shippingMethod.discountThreshold
      ? shippingMethod.discountedFee
      : shippingMethod.feePerCase
  const shippingCost = quantity * shippingPerCase
  const price = basePrice - discount + shippingCost
  return price
}

const getOrderPrice = ({ product, quantity, shippingMethod }: Order) => {
  const { basePrice, discount } = calculatePricingData({ product, quantity })
  const price = applyShipping({ basePrice, discount, quantity, shippingMethod })
  return price
}

export default getOrderPrice
