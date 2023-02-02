type IItem = {
  price: number
}

interface IOrder {
  quantity: number
  item: IItem
}

class Order {
  private _data: IOrder
  constructor(data: IOrder) {
    this._data = data
  }
  get basePrice() {
    return this._data.item.price * this._data.quantity
  }
  get discountFactor() {
    if (this.basePrice > 1000) return 0.95
    return 0.98
  }
  get price() {
    return this.basePrice * this.discountFactor
  }
}

const order1 = new Order({ item: { price: 73 }, quantity: 7 })
const order2 = new Order({ item: { price: 142423 }, quantity: 32 })

export const getOrder1 = (): Order => {
  return order1
}
export const getOrder2 = (): Order => {
  return order2
}
