type ResultType<T extends boolean> = T extends true ? string : number
const name: ResultType<true> = "Jozeph"
const age: ResultType<false> = 25

/* Calculation type based on another type. */
type DateOrNumberOrString<T> = T extends Date ? Date
  : T extends number ? Date | number
  : T extends string ? Date | number | string
  : never
const compareDates = <T extends Date | number | string | boolean>(
  firstDate: T, secondDate: DateOrNumberOrString<T>
) => {
  return firstDate.toString() === secondDate.toString()
}
// The second argument type is checked based on the first argument type.
compareDates(new Date(), new Date())
compareDates(123, 123)
compareDates("January", 123)
// compareDates(true, 123) // Argument of type 'number' is not assignable to parameter of type 'never'.

export {}
