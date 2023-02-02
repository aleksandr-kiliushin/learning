type IDepartment = {
  code: string
  manager: Person
}

class Department {
  private _data: IDepartment
  constructor(data: { code: IDepartment["code"]; managerId: IPerson["id"] }) {
    this._data = {
      code: data.code,
      manager: new Person({ id: data.managerId, department: null }),
    }
  }
  get manager() {
    return this._data.manager
  }
}

export type IPerson = {
  id: number
  department: Department | null
}

class Person {
  private _data: IPerson
  constructor(data: IPerson) {
    this._data = data
  }
  get id() {
    return this._data.id
  }
  get manager() {
    return this._data.department?.manager
  }
}

const aPerson = new Person({
  department: new Department({ code: "ABC-1", managerId: 666 }),
  id: 1234,
})

export const getPerson = (): Person => {
  return aPerson
}
