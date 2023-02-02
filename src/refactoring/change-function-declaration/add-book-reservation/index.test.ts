import Book from "./index"

describe("Book `addReservation` metod works correctly ().", () => {
  test("Books are reserved correctly..", () => {
    const book1 = new Book()
    book1.addReservation({ customerName: "Peter", hasPriority: true })
    expect(book1.reservations).toEqual([
      {
        customerName: "Peter",
        hasPriority: true,
      },
    ])
    book1.addReservation({ customerName: "John", hasPriority: false })
    expect(book1.reservations).toEqual([
      { customerName: "Peter", hasPriority: true },
      { customerName: "John", hasPriority: false },
    ])
    book1.addReservation({ customerName: "Petty", hasPriority: true })
    expect(book1.reservations).toEqual([
      { customerName: "Peter", hasPriority: true },
      { customerName: "John", hasPriority: false },
      { customerName: "Petty", hasPriority: true },
    ])

    const book2 = new Book()
    book2.addReservation({ customerName: "Mary", hasPriority: true })
    expect(book2.reservations).toEqual([
      {
        customerName: "Mary",
        hasPriority: true,
      },
    ])

    expect(book1.reservations).toEqual([
      { customerName: "Peter", hasPriority: true },
      { customerName: "John", hasPriority: false },
      { customerName: "Petty", hasPriority: true },
    ])
  })
})
