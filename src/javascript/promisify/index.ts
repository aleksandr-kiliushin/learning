export type TFunctionToBePromisified<TLogicArgument extends Record<string, unknown>, TResult extends unknown> = (
  logicArgument: TLogicArgument,
  onDone: (result: TResult) => void
) => void

export function promisify<TLogicArgument extends Record<string, unknown>, TResult extends unknown>(
  functionToBePromisified: TFunctionToBePromisified<TLogicArgument, TResult>
): (logicArgument: TLogicArgument) => Promise<TResult> {
  return (logicArgument) => {
    return new Promise((resolve) => {
      functionToBePromisified(logicArgument, resolve)
    })
  }
}
