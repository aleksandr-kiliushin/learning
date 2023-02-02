import raisePersonSalary, { Person } from "./index"

describe("raisePersonSalary", () => {
  test("A person salary is raised correctly.", () => {
    const aPerson: Person = { salary: 1000 }
    raisePersonSalary({ aPerson, raisingFactor: 0.05 })
    expect(aPerson.salary).toEqual(1050)
    raisePersonSalary({ aPerson, raisingFactor: 0.1 })
    expect(aPerson.salary).toEqual(1155)
  })
})
