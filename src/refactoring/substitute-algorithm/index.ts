const findPerson = ({ people }: { people: string[] }) => {
  const candidates = ["Don", "John", "Kent"]
  const thePerson = people.find((aPerson) => candidates.includes(aPerson))
  if (thePerson !== undefined) return thePerson
  return ""
}

export default findPerson
