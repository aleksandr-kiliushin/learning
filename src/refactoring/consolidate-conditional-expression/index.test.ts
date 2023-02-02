import getDisabilityAmount from "./index"

describe("getDisabilityAmount", () => {
  test("Disability amount is calculated correctly.", () => {
    expect(getDisabilityAmount({ isPartTime: false, monthsDisabled: 7, seniority: 1 })).toEqual(0)
    expect(getDisabilityAmount({ isPartTime: false, monthsDisabled: 13, seniority: 7 })).toEqual(0)
    expect(getDisabilityAmount({ isPartTime: true, monthsDisabled: 10, seniority: 7 })).toEqual(0)
    expect(getDisabilityAmount({ isPartTime: false, monthsDisabled: 10, seniority: 7 })).toEqual(70)
  })
})
