type CustomerContractData = {
  discountRate: number
  startDate: Date
}

class CustomerContract {
  private _data: CustomerContractData
  constructor(data: CustomerContractData) {
    this._data = data
  }
  get discountRate() {
    return this._data.discountRate
  }
  set discountRate(newValue) {
    this._data.discountRate = newValue
  }
}

type CustomerData = {
  contract: CustomerContract
  name: string
}

class Customer {
  private _data: CustomerData
  constructor(data: {
    discountRate: CustomerContractData["discountRate"]
    name: CustomerData["name"]
  }) {
    this._data = {
      contract: new CustomerContract({ discountRate: data.discountRate, startDate: new Date() }),
      name: data.name,
    }
  }
  get contract() {
    return this._data.contract
  }
  becomePreffered() {
    this._data.contract.discountRate += 0.03
  }
}

const aCustomer = new Customer({ discountRate: 0.14, name: "John" })

export const getCustomer = (): Customer => {
  return aCustomer
}
