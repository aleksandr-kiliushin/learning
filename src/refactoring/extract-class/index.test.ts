import { getPerson, IPerson } from "./index"

describe("A Person and their telephone number.", () => {
  test("A person's telephone number is read and set correctly.", () => {
    expect(getPerson().name).toEqual<IPerson["name"]>("John")
    expect(getPerson().telephoneNumber.areaCode).toEqual<IPerson["telephoneNumber"]["areaCode"]>(
      "+7 (495)"
    )
    expect(getPerson().telephoneNumber.officeNumber).toEqual<
      IPerson["telephoneNumber"]["officeNumber"]
    >("111-44-22")
    expect(getPerson().telephoneNumber.toString()).toEqual<string>("+7 (495) 111-44-22")

    getPerson().name = "Alan"
    expect(getPerson().name).toEqual<IPerson["name"]>("Alan")

    getPerson().telephoneNumber.areaCode = "+7 (812)"
    expect(getPerson().telephoneNumber.areaCode).toEqual<IPerson["telephoneNumber"]["areaCode"]>(
      "+7 (812)"
    )

    getPerson().telephoneNumber.officeNumber = "999-66-33"
    expect(getPerson().telephoneNumber.officeNumber).toEqual<
      IPerson["telephoneNumber"]["officeNumber"]
    >("999-66-33")

    expect(getPerson().telephoneNumber.toString()).toEqual<string>("+7 (812) 999-66-33")
  })
})
