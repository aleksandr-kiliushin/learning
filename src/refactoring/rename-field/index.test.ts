import { getOrganization1, getOrganization2, OrganizationData } from "./index"

describe("Organization", () => {
  test("Organization #1 reads and modifies correctly.", () => {
    expect(getOrganization1().rawData).toEqual<OrganizationData>({
      countryCode: "GB",
      title: "Acme Gooseberries",
    })
    getOrganization1().countryCode = "US"
    getOrganization1().title = "Amazon"
    expect(getOrganization1().rawData).toEqual<OrganizationData>({
      countryCode: "US",
      title: "Amazon",
    })
  })

  test("Organization #2 reads and modifies correctly.", () => {
    expect(getOrganization2().rawData).toEqual<OrganizationData>({
      countryCode: "BR",
      title: "Some company name",
    })
    getOrganization2().countryCode = "GR"
    getOrganization2().name = "Apollon"
    expect(getOrganization2().rawData).toEqual<OrganizationData>({
      countryCode: "GR",
      title: "Apollon",
    })
  })
})
