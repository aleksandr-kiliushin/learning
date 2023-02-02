import R from "ramda"

type IPriority = "low" | "normal" | "high" | "rush"

export class Priority {
  private _value: IPriority
  constructor(value: IPriority) {
    this._value = value
  }
  toString() {
    return this._value
  }
  static legalValues: IPriority[] = ["low", "normal", "high", "rush"]
  get _index() {
    return Priority.legalValues.findIndex((aLegalValue) => aLegalValue === this._value)
  }
  equals(anotherPriority: Priority) {
    return this._index === anotherPriority._index
  }
  higherThan(anotherPriority: Priority) {
    return this._index > anotherPriority._index
  }
  lowerThan(anotherPriority: Priority) {
    return this._index < anotherPriority._index
  }
}

type IOrder = {
  id: number
  priority: Priority
}

class Order {
  private _data: IOrder
  constructor(data: IOrder) {
    this._data = data
  }
  get rawData() {
    return R.clone(this._data)
  }
  get priority(): Priority {
    return this._data.priority
  }
  set priority(newPriority) {
    this._data.priority = newPriority
  }
}

const orders = [
  new Order({ id: 1, priority: new Priority("normal") }),
  new Order({ id: 2, priority: new Priority("high") }),
  new Order({ id: 3, priority: new Priority("low") }),
  new Order({ id: 4, priority: new Priority("rush") }),
  new Order({ id: 5, priority: new Priority("high") }),
  new Order({ id: 6, priority: new Priority("normal") }),
]

export const getOrders = (): Order[] => {
  return orders
}
