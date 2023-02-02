type BirdData = {
  isNailed: boolean
  name: string
  numberOfCoconuts: number
  type: "EuropeanSwallow" | "AfricanSwallow" | "NorwegianBlueParrot"
  voltage: number
}

type Plumage = "average" | "beautiful" | "scorched" | "tired" | "unknown"

class Bird {
  protected _data: BirdData
  constructor(data: BirdData) {
    this._data = data
  }
  get name() {
    return this._data.name
  }
  get airSpeedVelocity() {
    switch (this._data.type) {
      case "EuropeanSwallow":
        return 35
      case "AfricanSwallow":
        return 40 - 2 * this._data.numberOfCoconuts
      case "NorwegianBlueParrot":
        return this._data.isNailed ? 0 : 10 + this._data.voltage / 10
      default:
        return null
    }
  }
  get plumage(): Plumage {
    switch (this._data.type) {
      case "EuropeanSwallow":
      case "AfricanSwallow":
      case "NorwegianBlueParrot":
        throw "should not happen"
      default:
        return "unknown"
    }
  }
}

class AfricanSwallow extends Bird {
  get plumage(): Plumage {
    return this._data.numberOfCoconuts > 2 ? "tired" : "average"
  }
}

class EuropeanSwallow extends Bird {
  get plumage(): Plumage {
    return "average"
  }
}

class NorwegianBlueParrot extends Bird {
  get plumage(): Plumage {
    return this._data.voltage > 100 ? "scorched" : "beautiful"
  }
}

const createBird = (
  birdData: BirdData
): Bird | AfricanSwallow | EuropeanSwallow | NorwegianBlueParrot => {
  if (birdData.type === "AfricanSwallow") return new AfricanSwallow(birdData)
  if (birdData.type === "EuropeanSwallow") return new EuropeanSwallow(birdData)
  if (birdData.type === "NorwegianBlueParrot") return new NorwegianBlueParrot(birdData)

  return new Bird(birdData)
}

const speeds = ({ birdsData }: { birdsData: BirdData[] }) => {
  return new Map(
    birdsData
      .map((aBirdData) => createBird(aBirdData))
      .map((aBird) => [aBird.name, aBird.airSpeedVelocity])
  )
}

const plumages = ({ birdsData }: { birdsData: BirdData[] }) => {
  return new Map(
    birdsData.map((aBirdData) => createBird(aBirdData)).map((aBird) => [aBird.name, aBird.plumage])
  )
}

const birdsData: BirdData[] = [
  { isNailed: true, numberOfCoconuts: 4, name: "Kitty", type: "EuropeanSwallow", voltage: 80 },
  { isNailed: false, numberOfCoconuts: 4, name: "Lucy", type: "AfricanSwallow", voltage: 100 },
  { isNailed: false, numberOfCoconuts: 2, name: "Messi", type: "NorwegianBlueParrot", voltage: 80 },
  { isNailed: true, numberOfCoconuts: 2, name: "Peppi", type: "NorwegianBlueParrot", voltage: 120 },
  { isNailed: false, numberOfCoconuts: 2, name: "Puppy", type: "AfricanSwallow", voltage: 100 },
]

const _plumages = plumages({ birdsData })
const _speeds = speeds({ birdsData })

export const getPlumages = () => {
  return _plumages
}

export const getSpeeds = () => {
  return _speeds
}
