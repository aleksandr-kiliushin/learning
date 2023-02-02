const pricingPlan = retrievePricingPlan()
const baseCharge = pricingPlan.base
const chargePerUnit = pricingPlan.unit
const order = retreiveOrder()
const units = order.units
let charge = baseCharge + units * chargePerUnit
let discountableUnits = Math.max(units - pricingPlan.discountThreshold, 0)
let discount = discountableUnits * pricingPlan.discountFactor
if (order.isRepeat) discount += 20
charge = charge - discount
chargeOrder(charge)

function retrievePricingPlan(): any {}
function retreiveOrder(): any {}
function chargeOrder(charge: any): any {}

export {}
