type TFlat<T> = T extends (infer R)[] ? R : T
type TFlatten2DArray = TFlat<number[][]> // number[]
type TFlatten1DArray = TFlat<number[]> // number[]
type TFlattenNumber = TFlat<number> // number

type TValueOfObjectFields<T> = T extends { [key: string]: infer U } ? U : never
type TValueOfObjectFieldsWithNumbers = TValueOfObjectFields<{ age: number }> // number
type TValueOfObjectFieldsWithNumbersAndStrings = TValueOfObjectFields<{ age: number; name: string }> // number | string

type TReturnType<T> = T extends (...args: any[]) => infer R ? R : never
const getSum = (a: number, b: number) => a + b
type TGetPiReturnValue = TReturnType<typeof getSum> // number
