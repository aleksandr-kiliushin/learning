type AccountData = {
  daysOverdrawn: number
  overdraftCharge: number
  type: AccountType
}

class Account {
  private _data: AccountData
  constructor(data: AccountData) {
    this._data = data
  }
  get bankCharge() {
    let result = 4.5
    if (this._data.daysOverdrawn > 0) {
      result += this._data.overdraftCharge
    }
    return result
  }
  get overdraftCharge() {
    return this._data.type.overdraftCharge({ daysOverdrawn: this._data.daysOverdrawn })
  }
}

type AccountTypeData = {
  isPremium: boolean
}

class AccountType {
  private _data: AccountTypeData
  constructor(data: AccountTypeData) {
    this._data = data
  }
  overdraftCharge({ daysOverdrawn }: { daysOverdrawn: AccountData["daysOverdrawn"] }) {
    if (this._data.isPremium) {
      const baseCharge = 10
      if (daysOverdrawn <= 7) return baseCharge
      return baseCharge + (daysOverdrawn - 7) * 0.85
    }
    return daysOverdrawn * 1.75
  }
}

const account1 = new Account({
  daysOverdrawn: 12,
  overdraftCharge: 123,
  type: new AccountType({ isPremium: true }),
})

const account2 = new Account({
  daysOverdrawn: 3,
  overdraftCharge: 321,
  type: new AccountType({ isPremium: false }),
})

export const getAccount1 = (): Account => {
  return account1
}

export const getAccount2 = (): Account => {
  return account2
}
