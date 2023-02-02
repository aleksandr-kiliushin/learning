import setOffAlarms from "./set-off-alarms"

const findMiscreant = ({ people }: { people: string[] }) => {
  if (people.includes("Don")) return "Don"
  if (people.includes("John")) return "John"
  return ""
}

const main = ({ people }: { people: string[] }) => {
  const foundMiscreantName = findMiscreant({ people })
  if (foundMiscreantName !== "") {
    setOffAlarms()
  }
}

export default main
