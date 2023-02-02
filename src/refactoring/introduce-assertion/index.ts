type Assert = (assumption: boolean) => asserts assumption is true

const assert: Assert = (assumption) => {
  if (assumption !== true) {
    throw new Error("Assertion failure.")
  }
}

type CustomerData = {
  discountRate: number
}

class Customer {
  private _data: CustomerData
  constructor(data: CustomerData) {
    this._data = data
  }
  applyDiscount({ itemPrice }: { itemPrice: number }) {
    assert(itemPrice >= 0)
    return this._data.discountRate ? itemPrice * (1 - this._data.discountRate) : itemPrice
  }
  get discountRate() {
    return this._data.discountRate
  }
  set discountRate(newValue) {
    assert(typeof newValue === "number")
    assert(newValue >= 0)
    assert(newValue <= 1)

    this._data.discountRate = newValue
  }
}

const aCustomer = new Customer({ discountRate: 0.1 })

export const getCustomer = (): Customer => {
  return aCustomer
}
