import R from "ramda"

import { getCourse, getPerson, ICourse, IPerson } from "./index"

describe("Person and Course.", () => {
  test("A course is created and modified properly.", () => {
    expect(getCourse().rawData).toEqual<ICourse>({ isAdvanced: false, name: "React" })
    expect(getCourse().isAdvanced).toEqual<ICourse["isAdvanced"]>(false)
    expect(getCourse().name).toEqual<ICourse["name"]>("React")

    expect(() => {
      // @ts-ignore (an intentional error).
      getCourse().rawData = { isAdvanced: true, name: "Angular" }
    }).toThrowError()

    getCourse().isAdvanced = true
    getCourse().name = "Angular"

    expect(getCourse().rawData).toEqual<ICourse>({ isAdvanced: true, name: "Angular" })
  })

  test("A person is created and modified properly.", () => {
    expect(getPerson().name).toEqual<IPerson["name"]>("Joe")
    expect(getPerson().courses).toEqual<IPerson["courses"]>([])
    expect(getPerson().rawData).toEqual<IPerson>({ courses: [], name: "Joe" })

    // Does not have an effect because we mutate a copy.
    getPerson().rawData.courses = [{ isAdvanced: true, name: "JavaScript" }]
    expect(getPerson().courses).toEqual<IPerson["courses"]>([])

    // Does not have an effect because we mutate a copy.
    getPerson().courses.push({ isAdvanced: true, name: "JavaScript" })
    expect(getPerson().courses).toEqual<IPerson["courses"]>([])

    getPerson().addCourse({ isAdvanced: true, name: "Angular" })
    expect(getPerson().courses).toEqual<IPerson["courses"]>([{ isAdvanced: true, name: "Angular" }])
    getPerson().addCourse({ isAdvanced: false, name: "React" })
    expect(getPerson().courses).toEqual<IPerson["courses"]>([
      { isAdvanced: true, name: "Angular" },
      { isAdvanced: false, name: "React" },
    ])

    getPerson().removeCourse({ aCourseName: "React" })
    expect(getPerson().courses).toEqual<IPerson["courses"]>([{ isAdvanced: true, name: "Angular" }])

    const someCourses: IPerson["courses"] = [
      { isAdvanced: false, name: "VueJS" },
      { isAdvanced: true, name: "NodeJS" },
    ]
    getPerson().courses = someCourses
    expect(getPerson().courses).toEqual<IPerson["courses"]>([
      { isAdvanced: false, name: "VueJS" },
      { isAdvanced: true, name: "NodeJS" },
    ])
    someCourses[0] = { isAdvanced: true, name: "ExpressJS" }
    expect(getPerson().courses).toEqual<IPerson["courses"]>([
      { isAdvanced: false, name: "VueJS" },
      { isAdvanced: true, name: "NodeJS" },
    ])
  })
})
