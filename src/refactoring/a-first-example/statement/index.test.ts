import invoices from "../data/invoices.json"
import plays from "../data/plays.json"

import { statement, htmlStatement } from "./index"

describe("Statement function.", () => {
  test("Renders plain text correctly.", () => {
    expect(statement(invoices, plays)).toEqual(`Statement for BigCo
  Hamlet: $650.00 (55 seats)
  As You Like It: $580.00 (35 seats)
  Othello: $500.00 (40 seats)
Amount owed is $1,730.00.
You earned 47 credits.
`)
  })

  test("Renders HTML correctly.", () => {
    expect(htmlStatement(invoices, plays)).toEqual(`<h1>Statement for BigCo</h1>
<table>
  <tr>
    <th>play</th>
    <th>seats</th>
    <th>cost</th>
  </tr>
  <tr>
    <td>Hamlet</td>
    <td>$650.00</td>
    <td>55</td>
  </tr>
  <tr>
    <td>As You Like It</td>
    <td>$580.00</td>
    <td>35</td>
  </tr>
  <tr>
    <td>Othello</td>
    <td>$500.00</td>
    <td>40</td>
  </tr>
</table>
<p>Amount owed is <em>$1,730.00</em>.</p>
<p>You earned <em>47</em> credits.</p>
`)
  })
})
