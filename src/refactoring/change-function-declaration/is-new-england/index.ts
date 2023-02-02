export type Customer = {
  address: {
    state: string
  }
}

const isNewEngland = (state: Customer["address"]["state"]) => {
  return ["MA", "CT", "ME", "VT", "NH", "RI"].includes(state)
}

export default isNewEngland
