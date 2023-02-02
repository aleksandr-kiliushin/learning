export default function createStatementData(invoice: any, plays: any) {
  const statementData: any = {}
  statementData.customer = invoice.customer
  statementData.performances = invoice.performances.map(enrichPerformance)
  statementData.totalAmount = totalAmount(statementData)
  statementData.totalVolumeCredits = totalVolumeCredits(statementData)
  return statementData

  function enrichPerformance(aPerformance: any): any {
    const calculator = createPerformaceCalculator(aPerformance, playFor(aPerformance))
    const result = Object.assign({}, aPerformance)
    result.play = calculator.play
    result.amount = calculator.amount
    result.volumeCredits = calculator.volumeCredits
    return result
  }

  function playFor(aPerformance: any): any {
    return plays[aPerformance.playID]
  }

  function totalAmount(data: any): any {
    return data.performances.reduce((total: any, p: any) => total + p.amount, 0)
  }

  function totalVolumeCredits(data: any): any {
    return data.performances.reduce((total: any, p: any) => total + p.volumeCredits, 0)
  }
}

class PerformanceCalculator {
  public performance: any
  public play: any
  public get: any
  constructor(aPerformance: any, aPlay: any) {
    this.performance = aPerformance
    this.play = aPlay
  }

  get amount(): number {
    throw new Error(
      "This method is supposed to be overriden in children class not supposed to be called."
    )
  }

  get volumeCredits() {
    return Math.max(this.performance.audience - 30, 0)
  }
}

function createPerformaceCalculator(aPerformance: any, aPlay: any): any {
  switch (aPlay.type) {
    case "comedy":
      return new ComedyCalculator(aPerformance, aPlay)
    case "tragedy":
      return new TragedyCalculator(aPerformance, aPlay)
  }
}

class ComedyCalculator extends PerformanceCalculator {
  get amount(): number {
    let result = 30000
    if (this.performance.audience > 20) {
      result += 10000 + 500 * (this.performance.audience - 20)
    }
    result += 300 * this.performance.audience
    return result
  }

  get volumeCredits(): number {
    return super.volumeCredits + Math.floor(this.performance.audience / 5)
  }
}

class TragedyCalculator extends PerformanceCalculator {
  get amount() {
    let result = 40000
    if (this.performance.audience > 30) {
      result += 1000 * (this.performance.audience - 30)
    }
    return result
  }
}
