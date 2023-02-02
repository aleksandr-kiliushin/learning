import { getAccount1, getAccount2 } from "./index"

describe("trackSummary", () => {
  test("Calculates correctly.", () => {
    expect(getAccount1().bankCharge).toEqual<number>(127.5)
    expect(getAccount2().bankCharge).toEqual<number>(325.5)
  })
})
