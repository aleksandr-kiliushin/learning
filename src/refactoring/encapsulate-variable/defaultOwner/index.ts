type IOwner = { name: string; surname: string }

let defaultOwner: IOwner = { name: "Martin", surname: "Fowler" }

class Owner {
  private _name: string
  private _surname: string
  constructor({ name, surname }: IOwner) {
    this._name = name
    this._surname = surname
  }
  get name(): IOwner["name"] {
    return this._name
  }
  get surname(): IOwner["surname"] {
    return this._surname
  }
  set name(newValue) {
    throw new Error("Can't set read-only `name` value.")
  }
  set surname(newValue) {
    throw new Error("Can't set read-only `name` value.")
  }
}

export const getDefaultOwner = () => {
  return new Owner(defaultOwner)
}

export const setDefaultOwner = (newOwner: IOwner): void => {
  defaultOwner = newOwner
}
