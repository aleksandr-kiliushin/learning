import { getPerson, IPerson } from "./index"

describe("A person and their department manager.", () => {
  test("A person department manager is read correctly.", () => {
    expect(getPerson().manager?.id).toEqual<IPerson["id"]>(666)
  })
})
