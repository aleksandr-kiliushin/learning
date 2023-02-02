import { getPerson, IDepartment, IPerson } from "./index"

describe("A person and their department manager.", () => {
  test("A person department manager is read correctly.", () => {
    expect(getPerson().department?.manager.id).toEqual<IPerson["id"]>(666)
    expect(getPerson().department?.code).toEqual<IDepartment["code"]>("ABC-1")
  })
})
