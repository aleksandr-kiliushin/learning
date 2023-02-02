import { Scorer, ScorerData } from "./index"

describe("Insurance scoring", () => {
  test.each<{ result: number; scoringParams: ScorerData }>([
    {
      scoringParams: { isSmoker: false, scoringGuide: "easy" },
      result: -5,
    },
    {
      scoringParams: { isSmoker: true, scoringGuide: "easy" },
      result: -10,
    },
    {
      scoringParams: { isSmoker: false, scoringGuide: "medium" },
      result: 0,
    },
    {
      scoringParams: { isSmoker: true, scoringGuide: "hard" },
      result: -5,
    },
  ])("TODO: Add description.", ({ result, scoringParams }) => {
    expect(new Scorer(scoringParams).execute()).toEqual(result)
  })
})
