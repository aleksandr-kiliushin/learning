type Customer = {
  baseRate: number
}
type Provider = {
  connectionCharge: number
}

const calculateCharge = ({
  customer,
  provider,
  usage,
}: {
  customer: Customer
  provider: Provider
  usage: number
}) => {
  const baseCharge = customer.baseRate * usage
  return baseCharge + provider.connectionCharge
}

const aCharge = calculateCharge({
  customer: { baseRate: 12 },
  usage: 13,
  provider: { connectionCharge: 14 },
})

export const getCharge = (): number => {
  return aCharge
}
