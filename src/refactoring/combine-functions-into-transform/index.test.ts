import enrichUserData, { EnrichedUser, User } from "./index"

describe("User info is stringified correctly", () => {
  test.each<{ aUser: User; anEnrichedUser: EnrichedUser }>([
    {
      aUser: { brothers: [123, 445, 5], name: "Carl", sisters: [] },
      anEnrichedUser: {
        brothers: [123, 445, 5],
        name: "Carl",
        sisters: [],
        hasSiblings: true,
        siblingsCount: 3,
      },
    },
    {
      aUser: { brothers: [], name: "Carl", sisters: [] },
      anEnrichedUser: {
        brothers: [],
        name: "Carl",
        sisters: [],
        hasSiblings: false,
        siblingsCount: 0,
      },
    },
  ])("$name user.", ({ aUser, anEnrichedUser }) => {
    expect(enrichUserData({ aUser })).toEqual(anEnrichedUser)
  })
})
