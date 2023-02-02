import { getRating, HistoryItem, Voyage } from "./index"

describe("Voyage rating.", () => {
  test.each<{
    history: HistoryItem[]
    result: "A" | "B"
    voyage: Voyage
  }>([
    {
      history: [
        { zone: "east-indies", profit: 5 },
        { zone: "west-indies", profit: 15 },
        { zone: "china", profit: -2 },
        { zone: "west-africa", profit: 7 },
      ],
      result: "B",
      voyage: { zone: "west-indies", length: 10 },
    },
    {
      history: [
        { zone: "east-indies", profit: 1 },
        { zone: "china", profit: 15 },
        { zone: "east-indies", profit: 40 },
        { zone: "east-indies", profit: 17 },
      ],
      result: "A",
      voyage: { zone: "china", length: 13 },
    },
    {
      history: [
        { zone: "west-indies", profit: -7 },
        { zone: "west-africa", profit: -15 },
        { zone: "west-africa", profit: 1 },
        { zone: "china", profit: 4 },
      ],
      result: "B",
      voyage: { zone: "east-indies", length: 1 },
    },
  ])("Rating is calculated correctly.", ({ history, result, voyage }) => {
    expect(getRating({ history, voyage })).toEqual(result)
  })
})
