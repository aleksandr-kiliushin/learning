import { getPlumages, getSpeeds } from "./index"

describe("Birds", () => {
  test("Birds data is queried correctly.", () => {
    expect(getPlumages()).toEqual(
      new Map([
        ["Kitty", "average"],
        ["Lucy", "tired"],
        ["Messi", "beautiful"],
        ["Peppi", "scorched"],
        ["Puppy", "average"],
      ])
    )

    expect(getSpeeds()).toEqual(
      new Map([
        ["Kitty", 35],
        ["Lucy", 32],
        ["Messi", 18],
        ["Peppi", 0],
        ["Puppy", 36],
      ])
    )
  })
})
