import R from "ramda"

type Customer = {
  id: number
  name: string
  usages: Record<number, Record<number, number>>
}

type ICustomers = Record<Customer["id"], Customer>

const rawCustomers: ICustomers = {
  1920: {
    id: 1920,
    name: "martin",
    usages: {
      2016: { 1: 50, 2: 55 },
      2015: { 1: 70, 2: 63 },
    },
  },
  1234: {
    id: 1234,
    name: "Frederick",
    usages: {
      2000: { 1: 123, 2: 876 },
      1999: { 1: 13, 2: 86, 3: 143 },
    },
  },
}

class Customers {
  private _data: ICustomers
  constructor(data: ICustomers) {
    this._data = data
  }
  get rawData() {
    return R.clone(this._data)
  }
  getUsage({
    customerId,
    month,
    year,
  }: {
    customerId: Customer["id"]
    month: number
    year: number
  }) {
    return this._data[customerId].usages[year][month]
  }
  setUsage({
    amount,
    customerId,
    month,
    year,
  }: {
    amount: number
    customerId: Customer["id"]
    month: number
    year: number
  }) {
    this._data[customerId].usages[year][month] = amount
  }
}

let customers = new Customers(rawCustomers)

const getCustomers = (): Customers => {
  return customers
}

const compareUsage = ({
  customerId,
  laterYear,
  month,
}: {
  customerId: Customer["id"]
  laterYear: number
  month: number
}): { change: number; laterAmount: number } => {
  const later = getCustomers().getUsage({ customerId, month, year: laterYear })
  const earlier = getCustomers().getUsage({ customerId, month, year: laterYear - 1 })
  return { laterAmount: later, change: later - earlier }
}

export { compareUsage, getCustomers }
