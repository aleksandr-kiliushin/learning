import { getDistanceTravelled } from "./index"

describe("Calculate distance travelled", () => {
  test("It calculates correctly.", () => {
    expect(getDistanceTravelled()).toBeCloseTo(4211.826)
  })
})
