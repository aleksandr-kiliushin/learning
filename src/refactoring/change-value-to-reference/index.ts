type CustomersRepository = Map<Customer["id"], Customer>
const customersRepository: CustomersRepository = new Map()
const findCustomer = ({
  customerId,
  customersRepository,
}: {
  customerId: Customer["id"]
  customersRepository: CustomersRepository
}): Customer | undefined => {
  return customersRepository.get(customerId)
}
const registerCustomer = ({
  customerId,
  customersRepository,
}: {
  customerId: Customer["id"]
  customersRepository: CustomersRepository
}): Customer => {
  const existingCustomer = findCustomer({ customerId, customersRepository })
  if (existingCustomer === undefined) {
    const newCustomer = new Customer({ id: customerId })
    customersRepository.set(customerId, newCustomer)
    return newCustomer
  }
  return existingCustomer
}

type CustomerData = {
  id: number
}

class Customer {
  private _data: CustomerData
  constructor(data: CustomerData) {
    this._data = data
  }
  get id() {
    return this._data.id
  }
}

type OrderData = {
  amount: number
  customer: Customer
  date: string
}

type OrderPayload = {
  amount: number
  customerId: Customer["id"]
  customersRepository: CustomersRepository
  date: string
}

class Order {
  private _data: OrderData
  constructor(payload: OrderPayload) {
    this._data = {
      amount: payload.amount,
      customer: registerCustomer({
        customerId: payload.customerId,
        customersRepository: payload.customersRepository,
      }),
      date: payload.date,
    }
  }
  get customer() {
    return this._data.customer
  }
}

const order1 = new Order({ amount: 100, customerId: 20, customersRepository, date: "2022-06-01" })
const order2 = new Order({ amount: 200, customerId: 20, customersRepository, date: "2022-06-23" })

export const getOrder1 = (): Order => {
  return order1
}

export const getOrder2 = (): Order => {
  return order2
}
