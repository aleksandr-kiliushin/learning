type Photo = {
  date: Date
  location: string
  title: string
}

type Person = {
  name: string
  photo: Photo
}

const composePersonHtml = ({ aPerson }: { aPerson: Person }) => {
  const result = []
  result.push(`<p>${aPerson.name}</p>`)
  result.push(emitPhotoData({ aPhoto: aPerson.photo }))
  return result.join("\n")
}

const composePhotoHtml = ({ aPhoto }: { aPhoto: Photo }) => {
  return ["<div>", emitPhotoData({ aPhoto }), "</div>"].join("\n")
}

const emitPhotoData = ({ aPhoto }: { aPhoto: Photo }) => {
  const result = []
  result.push(`<p>title: ${aPhoto.title}</p>`)
  result.push(`<p>location: ${aPhoto.location}</p>`)
  result.push(`<p>date: ${aPhoto.date.toDateString()}</p>`)
  return result.join("\n")
}

const aPhoto = { date: new Date(10000000), location: "Miami", title: "Miami beach" }

const aPersonHtml = composePersonHtml({
  aPerson: { name: "John", photo: aPhoto },
})

const aPhotoHtml = composePhotoHtml({ aPhoto })

export const getPersonHtml = () => {
  return aPersonHtml
}

export const getPhotoHtml = () => {
  return aPhotoHtml
}
