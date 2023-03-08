type ResultType<T extends boolean> = T extends true ? string : number
const name: ResultType<true> = "Jozeph"
const age: ResultType<false> = 25

/* Example of function argument type calculation based on the passed generic argument. */
type Abc = { a: number; b: string; c: boolean }
type Ab = { a: number; b: string }
type A = { a: number }
type AbcAbATuple<T> = T extends Abc
  ? [number, string, boolean]
  : T extends Ab
  ? [number, string]
  : T extends A
  ? [number]
  : never
const AbArray: AbcAbATuple<{ a: number }> = [1]
function getConcatenatedElements<T>(elements: AbcAbATuple<T>) {
  return "|" + elements.join("|") + "|"
}
const concatenatedElementsA = getConcatenatedElements<{ a: number }>([1])
const concatenatedElementsAb = getConcatenatedElements<{ a: number; b: string }>([1, "hehe"])
const concatenatedElementsAbc = getConcatenatedElements<{ a: number; b: string; c: boolean }>([1, "hehe", true])

/* Calculation type based on another type. */
type DateOrNumberOrString<T> = T extends Date
  ? Date
  : T extends number
  ? Date | number
  : T extends string
  ? Date | number | string
  : never
const compareDates = <T extends Date | number | string | boolean>(
  firstDate: T,
  secondDate: DateOrNumberOrString<T>
) => {
  return firstDate.toString() === secondDate.toString()
}
// The second argument type is checked based on the first argument type.
compareDates(new Date(), new Date())
compareDates(123, 123)
compareDates("January", 123)
// compareDates(true, 123) // Argument of type 'number' is not assignable to parameter of type 'never'.

// Infer type from inside of an object property.
type InferFromPropertyType<T> = T extends { id: infer U } ? U : never
const getIdPropertyValue = <T extends { id: any }>(input: T): T extends { id: infer U } ? U : never => {
  return input.id
}
const aVariableOfTypeNumber = getIdPropertyValue({ id: 123123 })

type TypeName<T> = T extends string
  ? "string"
  : T extends number
  ? "number"
  : T extends boolean
  ? "boolean"
  : T extends undefined
  ? "undefined"
  : T extends Function
  ? "function"
  : "object"
const myTypeName: TypeName<() => {}> = "function"

export {}
