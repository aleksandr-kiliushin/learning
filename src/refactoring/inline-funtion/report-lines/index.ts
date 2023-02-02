export type Customer = {
  name: string
  location: string
}

export type Line = [keyof Customer, string]

const reportLines = (aCustomer: Customer) => {
  const lines: Line[] = []
  lines.push(["location", aCustomer.location])
  lines.push(["name", aCustomer.name])
  return lines
}

export default reportLines
