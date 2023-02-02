import findReadingOutsideRange, { NumberRange, OperatingPlan, Station } from "./index"

describe("findReadingOutsideRange works correctly", () => {
  test.each<{
    operatingPlan: OperatingPlan
    station: Station
    tempsOutsideRange: Station["readings"]
  }>([
    {
      operatingPlan: {
        temperatureCeiling: 57,
        temperatureFloor: 49,
      },
      station: {
        name: "ZB1",
        readings: [
          { temp: 47, time: "2016-11-10 09:10" },
          { temp: 53, time: "2016-11-10 09:20" },
          { temp: 58, time: "2016-11-10 09:30" },
          { temp: 53, time: "2016-11-10 09:40" },
          { temp: 51, time: "2016-11-10 09:50" },
        ],
      },
      tempsOutsideRange: [
        { temp: 47, time: "2016-11-10 09:10" },
        { temp: 58, time: "2016-11-10 09:30" },
      ],
    },
  ])("Finds outside templs correctly.", ({ operatingPlan, station, tempsOutsideRange }) => {
    const range = new NumberRange(operatingPlan.temperatureFloor, operatingPlan.temperatureCeiling)
    expect(findReadingOutsideRange(station, range)).toEqual(tempsOutsideRange)
  })
})
