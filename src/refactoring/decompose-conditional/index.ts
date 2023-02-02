const calculateCharge = ({ monthNumber, quantity }: { monthNumber: number; quantity: number }) => {
  const isSummer = () => {
    return monthNumber >= 6 && monthNumber <= 8
  }
  const calculateSummerCharge = () => {
    const summerRate = 4
    return quantity * summerRate
  }
  const calculateRegularCharge = () => {
    const regularRate = 2
    const regularServiceCharge = 1.25
    return quantity * regularRate + regularServiceCharge
  }

  return isSummer() ? calculateSummerCharge() : calculateRegularCharge()
}

export default calculateCharge
