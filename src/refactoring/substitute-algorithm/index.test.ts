import findPerson from "./index"

describe("findPerson", () => {
  test("A person is found correctly.", () => {
    expect(findPerson({ people: ["Bella", "Tim", "Don"] })).toEqual("Don")
    expect(findPerson({ people: ["Jimmy", "Tim", "Alex"] })).toEqual("")
    expect(findPerson({ people: ["Bella", "Kent", "Elizabeth"] })).toEqual("Kent")
  })
})
