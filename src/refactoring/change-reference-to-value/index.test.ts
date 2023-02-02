import { getPerson, TelephoneNumberData } from "./index"

describe("A person telephone number", () => {
  test("Telephone number is immutable", () => {
    const aPersonTelephoneNumberBeforeChange = getPerson().telephoneNumberRawData
    expect(aPersonTelephoneNumberBeforeChange).toEqual<TelephoneNumberData>({
      areaCode: "+7 (495)",
      officeNumber: "123-45-67",
    })

    getPerson().officeNumberAreaCode = "+7 (812)"

    const aPersonTelephoneNumberAfterChange = getPerson().telephoneNumberRawData

    expect(aPersonTelephoneNumberAfterChange).toEqual<TelephoneNumberData>({
      areaCode: "+7 (812)",
      officeNumber: "123-45-67",
    })

    expect(aPersonTelephoneNumberBeforeChange).not.toEqual(aPersonTelephoneNumberAfterChange)
    expect(aPersonTelephoneNumberBeforeChange).not.toBe(aPersonTelephoneNumberAfterChange)
  })
})
