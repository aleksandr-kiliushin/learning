import printOwing from "./index"
import invoice from "./index.json"

describe("Extract function printOwing", () => {
  test("Logs into console correctly.", () => {
    const spiedConsoleLog = jest.spyOn(console, "log")

    printOwing(invoice)

    const today = new Date()
    const dueDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30)

    expect(spiedConsoleLog).toHaveBeenCalledTimes(6)
    expect(spiedConsoleLog).toHaveBeenCalledWith("***********************")
    expect(spiedConsoleLog).toHaveBeenCalledWith("**** Customer owes ****")
    expect(spiedConsoleLog).toHaveBeenCalledWith("***********************")
    expect(spiedConsoleLog).toHaveBeenCalledWith("Name: John Doe.")
    expect(spiedConsoleLog).toHaveBeenCalledWith("Amount: 600.")
    expect(spiedConsoleLog).toHaveBeenCalledWith(`Due: ${dueDate.toLocaleDateString()}.`)
  })
})
