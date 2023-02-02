import R from "ramda"

export type ICourse = {
  isAdvanced: boolean
  name: string
}

export type IPerson = {
  name: string
  courses: ICourse[]
}

class Course {
  private _data: ICourse
  constructor(data: ICourse) {
    this._data = data
  }
  get rawData() {
    return R.clone(this._data)
  }
  get isAdvanced() {
    return this._data.isAdvanced
  }
  get name() {
    return this._data.name
  }
  set isAdvanced(newValue) {
    this._data.isAdvanced = newValue
  }
  set name(newValue) {
    this._data.name = newValue
  }
}

class Person {
  private _data: IPerson
  constructor(data: IPerson) {
    this._data = data
  }
  get rawData() {
    return R.clone(this._data)
  }
  get courses() {
    return R.clone(this._data.courses)
  }
  get name() {
    return this._data.name
  }
  set courses(newCourses) {
    this._data.courses = R.clone(newCourses)
  }
  addCourse(aCourse: ICourse) {
    this._data.courses.push(aCourse)
  }
  removeCourse({ aCourseName }: { aCourseName: ICourse["name"] }) {
    this._data.courses = this._data.courses.filter((course) => course.name !== aCourseName)
  }
}

const aCourse = new Course({ isAdvanced: false, name: "React" })

export const getCourse = (): Course => {
  return aCourse
}

const aPerson = new Person({ courses: [], name: "Joe" })

export const getPerson = (): Person => {
  return aPerson
}
