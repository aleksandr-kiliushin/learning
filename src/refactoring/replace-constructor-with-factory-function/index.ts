type EmployeeData = {
  name: string
  typeCode: "E" | "M" | "S"
}

class Employee {
  private _data: EmployeeData
  constructor(data: EmployeeData) {
    this._data = data
  }
  get name() {
    return this._data.name
  }
  get typeCode() {
    return Employee.legalTypeCodes[this._data.typeCode]
  }
  static get legalTypeCodes() {
    return { E: "Engineer", M: "Manager", S: "Salesman" }
  }
}

const createEngineer = ({ name }: { name: EmployeeData["name"] }) => {
  return new Employee({ name, typeCode: "E" })
}
const createManager = ({ name }: { name: EmployeeData["name"] }) => {
  return new Employee({ name, typeCode: "M" })
}
const createSalesman = ({ name }: { name: EmployeeData["name"] }) => {
  return new Employee({ name, typeCode: "S" })
}

const anEngineer = createEngineer({ name: "John" })
export const getEngineer = (): Employee => {
  return anEngineer
}

const aManager = createManager({ name: "Kate" })
export const getManager = (): Employee => {
  return aManager
}

const aSalesman = createSalesman({ name: "Mike" })
export const getSalesman = (): Employee => {
  return aSalesman
}
