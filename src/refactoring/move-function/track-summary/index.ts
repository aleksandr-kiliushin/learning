export type Result = {
  distance: number
  pace: number
  time: number
}

const trackSummary = ({ points }: { points: unknown[] }): Result => {
  return {
    time: calculateTotalTime(),
    distance: calculateTotalDistance({ points }),
    pace: calculateTotalTime() / 60 / calculateTotalDistance({ points }),
  }
}

const calculateTotalDistance = ({ points }: { points: unknown[] }): number => {
  return 1000
}

const calculateTotalTime = (): number => {
  return 60000000
}

export default trackSummary
