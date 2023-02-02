import { statement, htmlStatement } from "./statement"

import invoices from "./data/invoices.json"
import plays from "./data/plays.json"

console.log(statement(invoices, plays))
console.log(htmlStatement(invoices, plays))
