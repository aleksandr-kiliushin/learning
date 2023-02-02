import { promisify, TFunctionToBePromisified } from "./index"

describe("promisify", () => {
  describe("'add' function case", () => {
    const add: TFunctionToBePromisified<{ a: number; b: number }, number> = ({ a, b }, onDone) => {
      setTimeout(() => {
        const result = a + b
        onDone(result)
      }, 0)
    }

    test("add works correctly", () => {
      add({ a: 1, b: 2 }, (result) => {
        expect(result).toEqual(3)
      })
    })

    test("addPromisified works correctly", async () => {
      const addPromisified = promisify(add)
      const result = await addPromisified({ a: 1, b: 2 })
      expect(result).toEqual(3)
    })
  })

  describe("'findMinValue' function case", () => {
    const findMinValue: TFunctionToBePromisified<{ values: number[] }, number> = ({ values }, onDone) => {
      setTimeout(() => {
        const result = values.reduce((accumulator, currentValue) => {
          if (currentValue < accumulator) return currentValue
          return accumulator
        })
        onDone(result)
      }, 0)
    }

    test("findMinValue works correctly", () => {
      findMinValue({ values: [4, 5, 2, 8] }, (result) => {
        expect(result).toEqual(2)
      })
    })

    test("findMinValuePromisified works correctly", async () => {
      const findMinValuePromisified = promisify(findMinValue)
      const result = await findMinValuePromisified({ values: [4, 5, 2, 8] })
      expect(result).toEqual(2)
    })
  })
})
