export type ScorerData = {
  isSmoker: boolean
  scoringGuide: "easy" | "medium" | "hard"
}

export class Scorer {
  private _data: ScorerData
  constructor(data: ScorerData) {
    this._data = data
  }
  execute() {
    let result = 0
    let healthLevel = 0
    if (this._data.isSmoker) {
      healthLevel += 10
    }
    if (this._data.scoringGuide === "easy") {
      result -= 5
    }
    result -= Math.max(healthLevel - 5, 0)
    return result
  }
}
