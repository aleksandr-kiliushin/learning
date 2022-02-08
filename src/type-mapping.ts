import camelCase from "lodash/camelCase"

/**
 * Mapped types are created by applying a transofrmation to the properties of an existing type.
 * The best way to understand how mapped types work is to create one that processes a type
 * but does'nt make any changes, as shown below.
 */
type User = {
  age: number
  name: string
}

/**
 * There here are the name selector before the colon and the type selector after the colon.
 *
 * The property name selector defines a type parameter, named `P` in this example,
 * and uses the `in` keyword to enumerate the types in a literal value union.
 * The type union can be expressed directly, such as `"age" | "name"`, or obtained using `keyof`.
 *
 * The TypeScript compiler creates a new property in the mapped type for each of the types in the union.
 * The type of each property is determined by the type selector, which can be obtained from the source type
 */
type MappedUser = {
  [P in keyof User]: User[P]
}

/* The result is equivalent to this type. I. e. the same as the original `User` type. */
type MappedUser2 = {
  age: number
  name: string
}

const user: MappedUser = {
  age: 25,
  name: "John",
}

/* Example 1 */
type Car = {
  model: string
  year: number
}

type CarWithAllowedStringValues = {
  [P in keyof Car]: Car[P] | string // Creates a type union between `string` and the property's original type.
}

const car1: CarWithAllowedStringValues = {
  model: "Ford",
  year: "1960", // `number` | `string` are allowed.
}

/* Example 2 */
type Cat = {
  isWild: boolean
  name: string
}
type CatWithModifiedKeys = {
  [P in keyof Cat as `${P}Property`]: Cat[P]
}

const cat1: Cat = {
  isWild: false,
  name: "Charly",
}
const cat2: CatWithModifiedKeys = {
  isWildProperty: false,
  nameProperty: "Bus",
}

/* Example 3. Pick. */
type Book = {
  author: string
  isEBook: boolean
  title: string
}

type SelectProperties<T, K extends keyof T> = {
  [P in K]: T[P]
}

type BookWithoutTitleProperty = SelectProperties<Book, "author" | "isEBook">

const bookWithoutTitleProperty: BookWithoutTitleProperty = {
  author: "Bob Martin",
  isEBook: true,
}

export default {}
