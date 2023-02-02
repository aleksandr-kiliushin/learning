export type Result = {
  amount: number
  reasonCode: "SEP" | "RET" | "SUC"
}

const getPaymentAmount = (employee: {
  isSeparated: boolean
  isRetired: boolean
  salary: number
}): Result => {
  if (employee.isRetired) return { amount: 0, reasonCode: "RET" }
  if (employee.isSeparated) return { amount: 0, reasonCode: "SEP" }

  return { amount: employee.salary * 2, reasonCode: "SUC" }
}

export default getPaymentAmount
