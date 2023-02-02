import { add, promisify } from "./index"

describe("'add' works correctly", () => {
  test("default, with callback", () => {
    add({ a: 1, b: 2 }, (result) => {
      expect(result).toEqual(3)
    })
  })

  test("promisified", async () => {
    const addPromisified = promisify(add)
    const result = await addPromisified({ a: 1, b: 2 })
    expect(result).toEqual(3)
  })
})
