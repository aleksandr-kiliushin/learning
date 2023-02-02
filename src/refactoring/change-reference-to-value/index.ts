export type TelephoneNumberData = {
  areaCode: string
  officeNumber: string
}

class TelephoneNumber {
  private _data: TelephoneNumberData
  constructor(data: TelephoneNumberData) {
    this._data = data
  }
  get rawData() {
    return this._data
  }
  get areaCode() {
    return this._data.areaCode
  }
  get officeNumber() {
    return this._data.officeNumber
  }
}

type PersonData = {
  telephoneNumber: TelephoneNumber
}

class Person {
  private _data: PersonData
  constructor(data: TelephoneNumberData) {
    this._data = {
      telephoneNumber: new TelephoneNumber(data),
    }
  }
  get telephoneNumberRawData() {
    return this._data.telephoneNumber.rawData
  }
  get officeNumberAreaCode() {
    return this._data.telephoneNumber.areaCode
  }
  set officeNumberAreaCode(newValue) {
    this._data.telephoneNumber = new TelephoneNumber({
      areaCode: newValue,
      officeNumber: this._data.telephoneNumber.officeNumber,
    })
  }
  get officeNumber() {
    return this._data.telephoneNumber.officeNumber
  }
  set officeNumber(newValue) {
    this._data.telephoneNumber = new TelephoneNumber({
      areaCode: this._data.telephoneNumber.areaCode,
      officeNumber: newValue,
    })
  }
}

const aPerson = new Person({ areaCode: "+7 (495)", officeNumber: "123-45-67" })

export const getPerson = (): Person => {
  return aPerson
}
