import main from "./index"
import setOffAlarms from "./set-off-alarms"

jest.mock("./set-off-alarms")

describe("alertForMiscreant", () => {
  test("A miscreant `Don` is found and alarm is called.", () => {
    main({ people: ["Don", "Lis", "Kevin"] })
    expect(setOffAlarms).toHaveBeenCalled()
  })

  test("A miscreant `John` is found and alarm is called.", () => {
    main({ people: ["John", "Lis", "Kevin"] })
    expect(setOffAlarms).toHaveBeenCalled()
  })

  test("A miscreant is not found and alarm is not called.", () => {
    main({ people: ["Jane", "Lis", "Kevin"] })
    expect(setOffAlarms).not.toHaveBeenCalled()
  })
})
