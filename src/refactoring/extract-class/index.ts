type ITelephoneNumber = {
  areaCode: string
  officeNumber: string
}

class TelephoneNumber {
  private _data: ITelephoneNumber
  constructor(data: ITelephoneNumber) {
    this._data = data
  }
  get areaCode() {
    return this._data.areaCode
  }
  set areaCode(newValue) {
    this._data.areaCode = newValue
  }
  get officeNumber() {
    return this._data.officeNumber
  }
  set officeNumber(newValue) {
    this._data.officeNumber = newValue
  }
  toString() {
    return this._data.areaCode + " " + this._data.officeNumber
  }
}

export type IPerson = {
  name: string
  telephoneNumber: TelephoneNumber
}

class Person {
  private _data: IPerson
  constructor(data: {
    name: IPerson["name"]
    telephoneNumberAreaCode: ITelephoneNumber["areaCode"]
    telephoneNumberOfficeNumber: ITelephoneNumber["officeNumber"]
  }) {
    this._data = {
      name: data.name,
      telephoneNumber: new TelephoneNumber({
        areaCode: data.telephoneNumberAreaCode,
        officeNumber: data.telephoneNumberOfficeNumber,
      }),
    }
  }
  get name() {
    return this._data.name
  }
  set name(newValue) {
    this._data.name = newValue
  }
  get telephoneNumber() {
    return this._data.telephoneNumber
  }
}

const aPerson = new Person({
  name: "John",
  telephoneNumberAreaCode: "+7 (495)",
  telephoneNumberOfficeNumber: "111-44-22",
})

export const getPerson = (): Person => {
  return aPerson
}
