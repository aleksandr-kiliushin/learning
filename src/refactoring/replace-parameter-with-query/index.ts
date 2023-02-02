type OrderData = {
  itemPrice: number
  quantity: number
}

class Order {
  private _data: OrderData
  constructor(data: OrderData) {
    this._data = data
  }
  get discountLevel(): 1 | 2 {
    return this._data.quantity > 100 ? 2 : 1
  }
  get finalPrice() {
    const basePrice = this._data.quantity * this._data.itemPrice
    return this.discountedPrice(basePrice)
  }
  discountedPrice(basePrice: number) {
    if (this.discountLevel === 1) return basePrice * 0.95
    if (this.discountLevel === 2) return basePrice * 0.9
    return undefined
  }
}

const anOrder = new Order({ itemPrice: 100, quantity: 35 })

export const getOrder = (): Order => {
  return anOrder
}
