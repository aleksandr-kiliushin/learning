// string type is in Promise generic here.
const promiseReturningString = (): Promise<string> => {
  // And the argument to resolve callback is also of type string.
  return new Promise((resolve: (outputValue: string) => void, reject: (error: Error) => void) => {
    // And we pass an argument of type string to the resolve callback.
    resolve("Resolved!")
    reject(new Error("Oops!"))
  })
}

promiseReturningString()
  // The resolved value is of type string.
  .then((resolvedValue) => {
    console.log(resolvedValue)
  })
  .catch(({ message, name }) => {
    console.log(name)
    console.log(message)
  })
