type ProducerData = {
  cost: number
  name: string
  production: number
  province: Province
}

class Producer {
  private _data: ProducerData
  constructor(data: ProducerData) {
    this._data = {
      cost: data.cost,
      name: data.name,
      production: data.production,
      province: data.province,
    }
  }
  get name() {
    return this._data.name
  }
  get cost() {
    return this._data.cost
  }
  set cost(aNewCost) {
    this._data.cost = aNewCost
  }
  get production() {
    return this._data.production
  }
  set production(aNewAmount) {
    const amount = aNewAmount
    const newProduction = Number.isNaN(amount) ? 0 : amount
    this._data.province.totalProduction += newProduction - this._data.production
    this._data.production = newProduction
  }
}

export type ProvinceData = {
  demand: number
  name: string
  price: number
  producers: Producer[]
  totalProduction: number
}

export type ProvincePayload = {
  demand: ProvinceData["demand"]
  name: ProvinceData["name"]
  price: ProvinceData["price"]
  producers: {
    cost: ProducerData["cost"]
    name: ProducerData["name"]
    production: ProducerData["production"]
  }[]
}

export class Province {
  private _data: ProvinceData
  constructor(data: ProvincePayload) {
    this._data = {
      demand: data.demand,
      name: data.name,
      price: data.price,
      producers: [],
      totalProduction: 0,
    }
    data.producers.forEach((d) => this.addProducer(new Producer({ ...d, province: this })))
  }
  addProducer(aProducer: Producer) {
    this._data.producers.push(aProducer)
    this._data.totalProduction += aProducer.production
  }
  get name() {
    return this._data.name
  }
  get producers() {
    return this._data.producers.slice()
  }
  get totalProduction() {
    return this._data.totalProduction
  }
  set totalProduction(aNewTotalProduction) {
    this._data.totalProduction = aNewTotalProduction
  }
  get demand() {
    return this._data.demand
  }
  set demand(aNewDemand) {
    this._data.demand = aNewDemand
  }
  get price() {
    return this._data.price
  }
  set price(aNewPrice) {
    this._data.price = aNewPrice
  }
  get shortfall() {
    return this._data.demand - this.totalProduction
  }
  get profit() {
    return this.demandValue - this.demandCost
  }
  get demandCost() {
    let remainingDemand = this.demand
    let result = 0
    this.producers
      .sort((a, b) => a.cost - b.cost)
      .forEach((p) => {
        const contribution = Math.min(remainingDemand, p.production)
        remainingDemand -= contribution
        result += contribution * p.cost
      })
    return result
  }
  get demandValue() {
    return this.satisfiedDemand * this.price
  }
  get satisfiedDemand() {
    return Math.min(this._data.demand, this.totalProduction)
  }
}

export const getSampleProvinceData = (): ProvincePayload => {
  return {
    demand: 30,
    name: "Asia",
    price: 20,
    producers: [
      { cost: 10, name: "Byzantium", production: 9 },
      { cost: 12, name: "Attalia", production: 10 },
      { cost: 10, name: "Sinope", production: 6 },
    ],
  }
}
