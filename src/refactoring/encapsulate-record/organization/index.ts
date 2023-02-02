import R from "ramda"

type IOrganization = {
  countryId: string
  name: string
}

class Organization {
  private _countryId: IOrganization["countryId"]
  private _name: IOrganization["name"]
  constructor(anOrganization: IOrganization) {
    const { countryId, name } = R.clone(anOrganization)

    this._countryId = countryId
    this._name = name
  }
  get countryId() {
    return this._countryId
  }
  set countryId(newCountryId: IOrganization["countryId"]) {
    this._countryId = newCountryId
  }
  get name() {
    return this._name
  }
  set name(newName: IOrganization["name"]) {
    this._name = newName
  }
}

const organization = new Organization({ countryId: "GB", name: "Acme Gooseberries" })

const getOrganization = (): Organization => {
  return organization
}

export default getOrganization
