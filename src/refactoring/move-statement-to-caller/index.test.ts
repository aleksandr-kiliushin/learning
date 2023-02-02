import { getPersonHtml, getOldPhotosHtml } from "./index"

describe("Person and old photos HTML.", () => {
  test("Person HTML is created correctly.", () => {
    expect(getPersonHtml()).toEqual(`<p>John</p>
<p>title: Trip</p>
<p>date: Thu May 21 1970</p>
<p>location: New York (composePersonHtml)</p>
`)
  })

  test("Old photos HTML is created correctly.", () => {
    expect(getOldPhotosHtml()).toEqual(`<div>
<p>title: Trip</p>
<p>date: Thu May 21 1970</p>
<p>location: New York (composeOldPhotosHtml)</p>
</div>
<div>
<p>title: Trip</p>
<p>date: Thu May 21 1970</p>
<p>location: New York (composeOldPhotosHtml)</p>
</div>
<div>
<p>title: Trip</p>
<p>date: Thu May 21 1970</p>
<p>location: New York (composeOldPhotosHtml)</p>
</div>
`)
  })
})
