type IShipment = {
  shippingCompany: string
  trackingNumber: number
}

class Shipment {
  private _data: IShipment
  constructor(data: IShipment) {
    this._data = data
  }
  get shippingCompany() {
    return this._data.shippingCompany
  }
  set shippingCompany(newValue) {
    this._data.shippingCompany = newValue
  }
  get trackingNumber() {
    return this._data.trackingNumber
  }
  set trackingNumber(newValue) {
    this._data.trackingNumber = newValue
  }
  get trackingInformation() {
    return this._data.shippingCompany + ": " + this._data.trackingNumber
  }
}

const aShipment = new Shipment({ shippingCompany: "Amazon", trackingNumber: 12345 })

export const getShipment = (): Shipment => {
  return aShipment
}
