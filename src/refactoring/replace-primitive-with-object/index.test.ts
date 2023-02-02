import { getOrders, Priority } from "./index"

describe("Orders priority.", () => {
  test("Orders work correctly", () => {
    expect(
      getOrders()
        .map((order) => order.rawData)
        .map((order) => ({ id: order.id, priority: order.priority.toString() }))
    ).toEqual([
      { id: 1, priority: "normal" },
      { id: 2, priority: "high" },
      { id: 3, priority: "low" },
      { id: 4, priority: "rush" },
      { id: 5, priority: "high" },
      { id: 6, priority: "normal" },
    ])

    expect(
      getOrders()
        .filter((order) => order.priority.higherThan(new Priority("normal")))
        .map((order) => order.rawData)
        .map((order) => ({ id: order.id, priority: order.priority.toString() }))
    ).toEqual([
      { id: 2, priority: "high" },
      { id: 4, priority: "rush" },
      { id: 5, priority: "high" },
    ])
  })
})
