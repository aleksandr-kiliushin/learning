import trackSummary, { Result } from "./index"

describe("trackSummary", () => {
  test("Calculates correctly.", () => {
    expect(trackSummary({ points: [] })).toEqual<Result>({
      distance: 1000,
      pace: 1000,
      time: 60000000,
    })
  })
})
