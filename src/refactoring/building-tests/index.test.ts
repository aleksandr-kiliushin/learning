import { Province, getSampleProvinceData, ProvincePayload } from "./index"

describe("Province", () => {
  let asia: Province

  beforeEach(() => {
    asia = new Province(getSampleProvinceData())
  })

  test("calculates shortfall correctly", () => {
    expect(asia.shortfall).toEqual(5)
  })

  test("calculates profit correctly", () => {
    expect(asia.profit).toEqual(230)
  })

  test("change production", () => {
    asia.producers[0].production = 20
    expect(asia.shortfall).toEqual(-6)
    expect(asia.profit).toEqual(292)
  })

  test("zero demand", () => {
    asia.demand = 0
    expect(asia.shortfall).toEqual(-25)
    expect(asia.profit).toEqual(0)
  })

  test("negative demand", () => {
    asia.demand = -1
    expect(asia.shortfall).toEqual(-26)
    expect(asia.profit).toEqual(-10)
  })
})

describe("A province with no producers", () => {
  let aProvinceWithNoProducers: Province

  beforeEach(() => {
    const data: ProvincePayload = {
      demand: 30,
      name: "No producers",
      price: 20,
      producers: [],
    }
    aProvinceWithNoProducers = new Province(data)
  })

  test("calculates shortfall correclty", () => {
    expect(aProvinceWithNoProducers.shortfall).toEqual(30)
  })

  test("calculates profit correctly", () => {
    expect(aProvinceWithNoProducers.profit).toEqual(0)
  })
})
