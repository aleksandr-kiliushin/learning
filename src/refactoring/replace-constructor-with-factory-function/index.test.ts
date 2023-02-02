import { getEngineer, getManager, getSalesman } from "./index"

describe("Employee.", () => {
  test("Employees are created and red correctly.", () => {
    expect(getEngineer().name).toEqual("John")
    expect(getEngineer().typeCode).toEqual("Engineer")

    expect(getManager().name).toEqual("Kate")
    expect(getManager().typeCode).toEqual("Manager")

    expect(getSalesman().name).toEqual("Mike")
    expect(getSalesman().typeCode).toEqual("Salesman")
  })
})
