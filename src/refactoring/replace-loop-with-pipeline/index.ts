const officesData = `office, country, telephone
Chicago, USA, +1 312 373 1000
Beijing, China, +86 4008 900 505
Bangalore, India, +91 80 4064 9570
Porto Alegre, Brazil, +55 51 3079 3550
Chennai, India, +91 44 660 44766`

export type OfficeAcquiredData = {
  city: string
  phoneNumber: string
}

const acquireData = ({ officesData }: { officesData: string }): OfficeAcquiredData[] => {
  const lines = officesData.split("\n")
  return lines
    .slice(1)
    .filter((line) => line.trim() !== "")
    .map((line) => line.split(", "))
    .filter(([_, country]) => country === "India")
    .map(([city, _, phoneNumber]) => ({ city, phoneNumber }))
}

const indiaOfficesData = acquireData({ officesData })

export const getOIndiaOfficesData = (): OfficeAcquiredData[] => {
  return indiaOfficesData
}
