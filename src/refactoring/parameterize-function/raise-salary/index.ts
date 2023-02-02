export type Person = {
  salary: number
}

const raisePersonSalary = ({
  aPerson,
  raisingFactor,
}: {
  aPerson: Person
  raisingFactor: number
}): void => {
  aPerson.salary = aPerson.salary * (1 + raisingFactor)
}

export default raisePersonSalary
