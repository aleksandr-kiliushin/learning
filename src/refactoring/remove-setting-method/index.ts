type PersonData = {
  id: number | undefined
  name?: string | undefined
}

export class Person {
  private _data: PersonData
  constructor(data: PersonData) {
    this._data = data
  }
  get name() {
    return this._data.name
  }
  set name(arg) {
    this._data.name = arg
  }
  get id() {
    return this._data.id
  }
}
