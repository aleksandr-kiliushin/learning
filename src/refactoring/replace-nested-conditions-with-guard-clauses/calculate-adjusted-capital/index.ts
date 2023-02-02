const calculateAdjustedCapital = ({
  adjustmentFactor,
  capital,
  duration,
  income,
  interestRate,
}: {
  adjustmentFactor: number
  capital: number
  duration: number
  income: number
  interestRate: number
}) => {
  if (capital <= 0) return 0
  if (interestRate <= 0) return 0
  if (duration <= 0) return 0

  return (income / duration) * adjustmentFactor
}

export default calculateAdjustedCapital
