// This refactoring was not finished intentionally.
// It is worth to look at an intermediate state,
// when the old `name` and the new `title` fields co-exist.
// To finish the refactoring you should replace all the
// old `name` field usages one by one, which is safe and
// will not break the code. And then delete the old `name`
// field in the type, class constructor and class accessors.

import R from "ramda"

export type OrganizationData = {
  countryCode: string
  title: string
}

type OrganizationPayload = {
  countryCode: string
} & ({ name: string } | { title: string })

class Organization {
  private _data: OrganizationData
  constructor(data: OrganizationPayload) {
    this._data = {
      countryCode: data.countryCode,
      title: "title" in data ? data.title : data.name,
    }
  }
  get rawData() {
    return R.clone(this._data)
  }

  get name() {
    return this._data.title
  }
  set name(newValue) {
    this._data.title = newValue
  }

  get title() {
    return this._data.title
  }
  set title(newValue) {
    this._data.title = newValue
  }

  get countryCode() {
    return this._data.countryCode
  }
  set countryCode(newValue) {
    this._data.countryCode = newValue
  }
}

const organization1 = new Organization({ countryCode: "GB", title: "Acme Gooseberries" })
const organization2 = new Organization({ countryCode: "BR", name: "Some company name" })

export const getOrganization1 = () => {
  return organization1
}
export const getOrganization2 = () => {
  return organization2
}
