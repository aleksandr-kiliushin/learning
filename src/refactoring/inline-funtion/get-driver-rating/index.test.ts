import getDriverRating from "./index"

describe("getDriverRating works correctly.", () => {
  test.each([
    { numberOfLateDeliveries: 2, driverRating: 1 },
    { numberOfLateDeliveries: 4, driverRating: 1 },
    { numberOfLateDeliveries: 5, driverRating: 1 },
    { numberOfLateDeliveries: 6, driverRating: 2 },
    { numberOfLateDeliveries: 12341, driverRating: 2 },
    { numberOfLateDeliveries: -132, driverRating: 1 },
    { numberOfLateDeliveries: NaN, driverRating: 1 },
  ])(
    "For a driver with $inputNumber late deliveries.",
    ({ numberOfLateDeliveries, driverRating }) => {
      const driver = { numberOfLateDeliveries }
      expect(getDriverRating(driver)).toEqual(driverRating)
    }
  )
  test("For a driver with 0 late deliveries.", () => {})
})
