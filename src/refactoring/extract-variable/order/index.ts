export type IOrder = {
  itemPrice: number
  quantity: number
}

class Order {
  private data: IOrder
  constructor(anOrder: IOrder) {
    this.data = anOrder
  }
  get itemPrice() {
    return this.data.itemPrice
  }
  get quantity() {
    return this.data.quantity
  }
  get basePrice() {
    return this.itemPrice * this.quantity
  }
  get quantityDiscount() {
    return Math.max(0, this.quantity - 500) * this.itemPrice * 0.05
  }
  get shippingPrice() {
    return Math.min(this.basePrice * 0.1, 100)
  }
  get price() {
    return this.basePrice - this.quantityDiscount + this.shippingPrice
  }
}

export default Order
