const getDisabilityAmount = ({
  isPartTime,
  monthsDisabled,
  seniority,
}: {
  seniority: number
  monthsDisabled: number
  isPartTime: boolean
}): number => {
  const isNotEligableForDisability = seniority < 2 || monthsDisabled > 12 || isPartTime

  if (isNotEligableForDisability) return 0
  return seniority * monthsDisabled
}

export default getDisabilityAmount
