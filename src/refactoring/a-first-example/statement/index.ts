import createStatementData from "./createStatementData"

export function statement(invoice: any, plays: any): any {
  return renderPlainText(createStatementData(invoice, plays))
}

function renderPlainText(data: any) {
  let result = `Statement for ${data.customer}\n`
  for (const perf of data.performances) {
    result += `  ${perf.play.name}: ${formatAsUsd(perf.amount)} (${perf.audience} seats)\n`
  }
  result += `Amount owed is ${formatAsUsd(data.totalAmount)}.\n`
  result += `You earned ${data.totalVolumeCredits} credits.\n`
  return result
}

export function htmlStatement(invoice: any, plays: any): any {
  return renderHtml(createStatementData(invoice, plays))
}

function renderHtml(data: any) {
  let result = `<h1>Statement for ${data.customer}</h1>\n`
  result += "<table>\n"
  result += "  <tr>\n"
  result += "    <th>play</th>\n"
  result += "    <th>seats</th>\n"
  result += "    <th>cost</th>\n"
  result += "  </tr>\n"
  for (const perf of data.performances) {
    result += "  <tr>\n"
    result += `    <td>${perf.play.name}</td>\n`
    result += `    <td>${formatAsUsd(perf.amount)}</td>\n`
    result += `    <td>${perf.audience}</td>\n`
    result += "  </tr>\n"
  }
  result += "</table>\n"
  result += `<p>Amount owed is <em>${formatAsUsd(data.totalAmount)}</em>.</p>\n`
  result += `<p>You earned <em>${data.totalVolumeCredits}</em> credits.</p>\n`
  return result
}

function formatAsUsd(aNumber: number): string {
  return new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2,
  }).format(aNumber / 100)
}
