type Order = {
  currentDayOfMonth: number
  deliveryState: "CT" | "MA" | "ME" | "NH" | "NY"
}

export const calculateDeliveryDateForRegularDelivery = ({ anOrder }: { anOrder: Order }) => {
  let deliveryTime
  if (["MA", "CT", "NY"].includes(anOrder.deliveryState)) deliveryTime = 2
  else if (["ME", "NH"].includes(anOrder.deliveryState)) deliveryTime = 3
  else deliveryTime = 4
  return anOrder.currentDayOfMonth + 2 + deliveryTime
}

export const calculateDeliveryDateForDeliveryInRush = ({ anOrder }: { anOrder: Order }) => {
  let deliveryTime
  if (["MA", "CT"].includes(anOrder.deliveryState)) deliveryTime = 1
  else if (["NY", "NH"].includes(anOrder.deliveryState)) deliveryTime = 2
  else deliveryTime = 3
  return anOrder.currentDayOfMonth + 1 + deliveryTime
}
