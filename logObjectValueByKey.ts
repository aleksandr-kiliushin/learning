const logObjectValueByKey = <T, K extends keyof T>(object: T, key: K) => {
  console.log(object[key])
}

const car1 = {
  model: "Ford",
  year: 1960,
}

logObjectValueByKey(car1, "model")
