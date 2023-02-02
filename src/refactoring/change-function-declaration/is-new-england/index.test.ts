import isNewEngland, { Customer } from "./index"

describe("isNewEngland works correctly.", () => {
  test.each<{
    result: boolean
    state: Customer["address"]["state"]
  }>([
    {
      result: true,
      state: "MA",
    },
    {
      result: true,
      state: "VT",
    },
    {
      result: false,
      state: "NY",
    },
  ])("For a driver with $inputNumber late deliveries.", ({ result, state }) => {
    expect(isNewEngland(state)).toEqual(result)
  })
})
