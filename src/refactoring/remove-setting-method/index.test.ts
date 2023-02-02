import { Person } from "./index"

describe("Person", () => {
  test("Name is set correctly, ID can't be set.", () => {
    const aPerson = new Person({ id: 123 })
    expect(aPerson.id).toEqual(123)
    expect(aPerson.name).toEqual(undefined)

    expect(() => {
      // @ts-ignore: A TS error is made intentionally.
      aPerson.id = 500
    }).toThrowError()
    aPerson.name = "John"
    expect(aPerson.id).toEqual(123)
    expect(aPerson.name).toEqual("John")
  })
})
