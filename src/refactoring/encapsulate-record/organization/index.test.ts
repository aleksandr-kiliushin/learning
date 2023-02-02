import getOrganization from "./index"

describe("Organization", () => {
  test("Organization countryId is queried and set properly.", () => {
    expect(getOrganization().countryId).toEqual("GB")
    getOrganization().countryId = "US"
    expect(getOrganization().countryId).toEqual("US")
  })

  test("Organization countryId is queried and set properly.", () => {
    expect(getOrganization().name).toEqual("Acme Gooseberries")
    getOrganization().name = "He&Co"
    expect(getOrganization().name).toEqual("He&Co")
  })
})
