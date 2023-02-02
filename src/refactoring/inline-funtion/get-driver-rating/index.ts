type Driver = {
  numberOfLateDeliveries: number
}

const getDriverRating = (aDriver: Driver) => {
  if (aDriver.numberOfLateDeliveries > 5) return 2
  return 1
}

export default getDriverRating
