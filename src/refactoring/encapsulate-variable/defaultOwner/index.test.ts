import { getDefaultOwner, setDefaultOwner } from "./index"

describe("defaultOwner is returned and modified properly.", () => {
  test("Gets and mutates a default owner correctly.", () => {
    const defaultOwner = getDefaultOwner()
    expect(defaultOwner.name).toEqual("Martin")
    expect(defaultOwner.surname).toEqual("Fowler")
    expect(() => {
      defaultOwner.surname = "Beck"
    }).toThrowError("Can't set read-only `name` value.")
    expect(defaultOwner.surname).toEqual("Fowler")
  })
})
