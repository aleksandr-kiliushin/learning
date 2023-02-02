import { getShipment } from "./index"

describe("Shipment and its tracking information.", () => {
  test("Shipment tracking information is read and updated correctly.", () => {
    expect(getShipment().trackingInformation).toEqual("Amazon: 12345")

    getShipment().shippingCompany = "Alibaba"
    expect(getShipment().shippingCompany).toEqual("Alibaba")
    getShipment().trackingNumber = 77777
    expect(getShipment().trackingNumber).toEqual(77777)
    expect(getShipment().trackingInformation).toEqual("Alibaba: 77777")

    getShipment().shippingCompany = "CDEK"
    getShipment().trackingNumber = 98765
    expect(getShipment().trackingInformation).toEqual("CDEK: 98765")
  })
})
