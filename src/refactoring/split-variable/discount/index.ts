const calculateDiscount = ({ inputValue, quantity }: { inputValue: number; quantity: number }) => {
  let result = inputValue
  if (inputValue > 50) result = result - 2
  if (quantity > 100) result = result - 1
  return result
}

const aDiscount = calculateDiscount({ inputValue: 123, quantity: 456 })

export const getDiscount = () => {
  return aDiscount
}
