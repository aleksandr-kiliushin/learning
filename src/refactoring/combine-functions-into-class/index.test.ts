import stringifyUserInfo, { IUser } from "./index"

describe("User info is stringified correctly", () => {
  test.each<{ aUser: IUser; stringifiedUser: string }>([
    {
      aUser: { brothers: [123, 445, 5], name: "Carl", sisters: [] },
      stringifiedUser: "User Carl has 3 siblings.",
    },
    {
      aUser: { brothers: [], name: "John", sisters: [] },
      stringifiedUser: "User John has no siblings.",
    },
  ])("$name user.", ({ aUser, stringifiedUser }) => {
    expect(stringifyUserInfo({ aUser })).toEqual(stringifiedUser)
  })
})
