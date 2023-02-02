import { getPeopleStatistics } from "./index"

describe("People statistics", () => {
  test("Calculated correctly.", () => {
    expect(getPeopleStatistics()).toEqual("Youngest Age: 19, total salary: 17960.")
  })
})
