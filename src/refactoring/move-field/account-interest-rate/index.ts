type AccountTypeData = {
  name: "default" | "premium"
}

class AccountType {
  private _data: AccountTypeData
  constructor(data: AccountTypeData) {
    this._data = data
  }
  get interestRate() {
    if (this._data.name === "default") return 0.12
    if (this._data.name === "premium") return 0.18
    return 0
  }
}

type AccountData = {
  number: number
  type: AccountType
}

class Account {
  private _data: AccountData
  constructor(data: AccountData) {
    this._data = data
  }
  get interestRate() {
    return this._data.type.interestRate
  }
}

const account1 = new Account({
  number: 123,
  type: new AccountType({ name: "default" }),
})

const account2 = new Account({
  number: 192,
  type: new AccountType({ name: "premium" }),
})

export const getAccount1 = (): Account => {
  return account1
}

export const getAccount2 = (): Account => {
  return account2
}
