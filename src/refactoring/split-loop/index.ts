type Person = {
  age: number
  salary: number
}

const calculatePeopleStatistics = ({ people }: { people: Person[] }): string => {
  let youngest = people[0] ? people[0].age : Infinity
  for (const p of people) {
    if (p.age < youngest) youngest = p.age
  }

  let totalSalary = 0
  for (const p of people) {
    totalSalary += p.salary
  }

  return `Youngest Age: ${youngest}, total salary: ${totalSalary}.`
}

const peopleStatistics = calculatePeopleStatistics({
  people: [
    { age: 19, salary: 3200 },
    { age: 43, salary: 3560 },
    { age: 32, salary: 4000 },
    { age: 28, salary: 3000 },
    { age: 49, salary: 4200 },
  ],
})

export const getPeopleStatistics = (): string => {
  return peopleStatistics
}
