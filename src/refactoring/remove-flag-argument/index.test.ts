import {
  calculateDeliveryDateForDeliveryInRush,
  calculateDeliveryDateForRegularDelivery,
} from "./index"

describe("calculateDeliveryDate", () => {
  test("A delivery date is calculated correctly for deliviries not in rush.", () => {
    expect(
      calculateDeliveryDateForRegularDelivery({
        anOrder: { currentDayOfMonth: 1, deliveryState: "CT" },
      })
    ).toEqual(5)
    expect(
      calculateDeliveryDateForRegularDelivery({
        anOrder: { currentDayOfMonth: 2, deliveryState: "MA" },
      })
    ).toEqual(6)
    expect(
      calculateDeliveryDateForRegularDelivery({
        anOrder: { currentDayOfMonth: 3, deliveryState: "ME" },
      })
    ).toEqual(8)
    expect(
      calculateDeliveryDateForRegularDelivery({
        anOrder: { currentDayOfMonth: 4, deliveryState: "NH" },
      })
    ).toEqual(9)
    expect(
      calculateDeliveryDateForRegularDelivery({
        anOrder: { currentDayOfMonth: 5, deliveryState: "NY" },
      })
    ).toEqual(9)
  })

  test("A delivery date is calculated correctly for deliviries in rush.", () => {
    expect(
      calculateDeliveryDateForDeliveryInRush({
        anOrder: { currentDayOfMonth: 6, deliveryState: "CT" },
      })
    ).toEqual(8)
    expect(
      calculateDeliveryDateForDeliveryInRush({
        anOrder: { currentDayOfMonth: 7, deliveryState: "MA" },
      })
    ).toEqual(9)
    expect(
      calculateDeliveryDateForDeliveryInRush({
        anOrder: { currentDayOfMonth: 8, deliveryState: "ME" },
      })
    ).toEqual(12)
    expect(
      calculateDeliveryDateForDeliveryInRush({
        anOrder: { currentDayOfMonth: 9, deliveryState: "NH" },
      })
    ).toEqual(12)
    expect(
      calculateDeliveryDateForDeliveryInRush({
        anOrder: { currentDayOfMonth: 10, deliveryState: "NY" },
      })
    ).toEqual(13)
  })
})
