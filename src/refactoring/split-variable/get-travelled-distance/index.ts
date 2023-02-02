type Scenario = {
  delay: number
  mass: number
  primaryForce: number
  secondaryForce: number
}

const calculateDistanceTravelled = ({ scenario, time }: { scenario: Scenario; time: number }) => {
  let result
  const primaryAcceleration = scenario.primaryForce / scenario.mass
  let primaryTime = Math.min(time, scenario.delay)
  result = 0.5 * primaryAcceleration * primaryTime * primaryTime
  let secondaryTime = time - scenario.delay
  if (secondaryTime > 0) {
    let primaryVelocity = primaryAcceleration * scenario.delay
    const secondaryAcceleration = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass
    result +=
      primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime
  }
  return result
}

const aDistanceTravelled = calculateDistanceTravelled({
  scenario: { delay: 12, mass: 23, primaryForce: 34, secondaryForce: 45 },
  time: 56,
})

export const getDistanceTravelled = () => {
  return aDistanceTravelled
}
