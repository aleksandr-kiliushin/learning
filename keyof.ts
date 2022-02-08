/* The `keyof` keyword returns a union of the property names of a type. */

/* Example 1 */
type User = {
  age: number
  name: string
}

type UserKey = keyof User // "age" | "name"
type UserValue = User[keyof User] // number | string

/* Example 2 */
const user1 = {
  age: 25,
  name: "John",
}

type UserValue1 = typeof user1[keyof typeof user1] // number | string

/* Example 3 */
const user2 = {
  age: 25,
  name: "John",
} as const

type UserValue2 = typeof user2[keyof typeof user2] // 25 | "John"

/* Example 4 */
/**
 * The `keyof` keyword can be used to constrain generic type parameters
 * so that they can only be typed to match the properties of another type.
 */
type LogObjectValueByKey = <T, K extends keyof T>(object: T, key: K) => T[K]

const getObjectValueByKey: LogObjectValueByKey = (object, key) => {
  return object[key]
}

const car1 = {
  model: "Ford",
  year: 1960,
}

// The second argument should be either "model" or "year".
getObjectValueByKey(car1, "model")
