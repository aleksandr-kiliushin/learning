const isArrayOfNumbers = (value: unknown): value is number[] => {
  if (!Array.isArray(value)) return false
  return value.every((element) => typeof element === "number")
}

const valueOfUnknownType: unknown = [1, 2, 3]

if (isArrayOfNumbers(valueOfUnknownType)) {
  valueOfUnknownType.forEach((number) => {
    console.log(number.toFixed(2))
  })
}

export {}
