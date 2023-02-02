type Zone = "china" | "east-indies" | "west-africa" | "west-indies"

export type Voyage = {
  length: number
  zone: Zone
}

export type HistoryItem = {
  profit: number
  zone: Zone
}

type RatingData = {
  history: HistoryItem[]
  voyage: Voyage
}

class Rating {
  protected _data: RatingData
  constructor(data: RatingData) {
    this._data = data
  }

  get value() {
    if (this.voyageProfitFactor * 3 > this.voyageRisk + this.captainHistoryRisk * 2) return "A"

    return "B"
  }

  get voyageRisk() {
    let result = 1
    if (this._data.voyage.length > 4) result += 2
    if (this._data.voyage.length > 8) result += this._data.voyage.length - 8
    if (["china", "east-indies"].includes(this._data.voyage.zone)) result += 4
    return Math.max(result, 0)
  }

  get captainHistoryRisk() {
    let result = 1
    if (this._data.history.length < 5) result += 4
    result += this._data.history.filter((aHistoryItem) => aHistoryItem.profit < 0).length
    return Math.max(result, 0)
  }

  get hasChina() {
    return this._data.history.some((aHistoryItem) => aHistoryItem.zone === "china")
  }

  get voyageProfitFactor() {
    let result = 2
    if (this._data.voyage.zone === "china") result += 1
    if (this._data.voyage.zone === "east-indies") result += 1
    result += this.voyageAndHistoryLengthFactor
    return result
  }

  get voyageAndHistoryLengthFactor() {
    let result = 0
    result += this.historyLengthFactor
    if (this._data.voyage.length > 14) result -= 1
    return result
  }

  get historyLengthFactor() {
    return this._data.history.length > 8 ? 1 : 0
  }
}

class ExperiencedChinaRating extends Rating {
  get captainHistoryRisk() {
    const result = super.captainHistoryRisk - 2
    return Math.max(result, 0)
  }

  get voyageProfitFactor() {
    let result = 2
    if (this._data.voyage.zone === "china") result += 1
    if (this._data.voyage.zone === "east-indies") result += 1
    result += this.voyageAndHistoryLengthFactor
    return result
  }

  get voyageAndHistoryLengthFactor() {
    let result = 0
    result += 3
    result += this.historyLengthFactor
    if (this._data.voyage.length > 12) result += 1
    if (this._data.voyage.length > 18) result -= 1
    return result
  }

  get historyLengthFactor() {
    return this._data.history.length > 10 ? 1 : 0
  }
}

export const getRating = (payload: RatingData) => {
  if (
    payload.voyage.zone === "china" &&
    payload.history.some((aHistoryItem) => aHistoryItem.zone === "china")
  ) {
    return new ExperiencedChinaRating(payload).value
  }

  return new Rating(payload).value
}
