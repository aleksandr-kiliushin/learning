type ResultType<T extends boolean> = T extends true ? string : number

const name: ResultType<true> = "Jozeph"
const age: ResultType<false> = 25

export {}
