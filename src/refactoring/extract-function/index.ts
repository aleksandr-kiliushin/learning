type Invoice = {
  customer: string
  orders: { amount: number }[]
  dueDate: Date | null
}

const printBanner = () => {
  console.log("***********************")
  console.log("**** Customer owes ****")
  console.log("***********************")
}

const calculateOutstanding = ({ invoice }: { invoice: Invoice }) => {
  let result = 0
  for (const order of invoice.orders) {
    result += order.amount
  }
  return result
}

const printDetails = ({ invoice, outstanding }: { invoice: Invoice; outstanding: number }) => {
  console.log(`Name: ${invoice.customer}.`)
  console.log(`Amount: ${outstanding}.`)
  if (invoice.dueDate === null) return
  console.log(`Due: ${invoice.dueDate.toLocaleDateString()}.`)
}

const calculateDueDate = (): Date => {
  const today = new Date()
  return new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30)
}

const printOwing = (invoice: Invoice): void => {
  printBanner()
  const outstanding = calculateOutstanding({ invoice })
  invoice.dueDate = calculateDueDate()
  printDetails({ invoice, outstanding })
}

export default printOwing
