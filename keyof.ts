/* The `keyof` keyword returns a union of the property names of a type. */

/** Example 1 */
type User = { age: number; name: string }

type UserKey = keyof User

const aKeyOfUser: UserKey = "age"
const anotherKeyOfUser: UserKey = "name"

/** Example 2 */
/**
 * The `keyof` keyword can be used to constrain generic type parameters
 * so that they can only be typed to match the properties of another type.
 */
type LogObjectValueByKey = <T, K extends keyof T>(object: T, key: K) => void

const logObjectValueByKey: LogObjectValueByKey = (object, key): void => {
  console.log(object[key])
}

const car1 = { model: "Ford", year: 1960 }

// The second argument should be either "model" or "year".
logObjectValueByKey(car1, "model")
