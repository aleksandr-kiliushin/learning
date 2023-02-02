const formatAsUsd = ({ amount }: { amount: number }) => {
  return "$" + amount
}

const calculateBaseCharge = ({ usage }: { usage: number }) => {
  if (usage < 0) return formatAsUsd({ amount: 0 })

  const amount =
    withinBand({ aValue: usage, bottom: 0, top: 100 }) * 0.03 +
    withinBand({ aValue: usage, bottom: 100, top: 200 }) * 0.05 +
    withinBand({ aValue: usage, bottom: 200, top: Infinity }) * 0.07

  return formatAsUsd({ amount })
}

const withinBand = ({
  aValue,
  bottom,
  top,
}: {
  aValue: number
  bottom: number
  top: number
}): number => {
  if (aValue > bottom) {
    return Math.min(aValue, top) - bottom
  }
  return 0
}

export default calculateBaseCharge
