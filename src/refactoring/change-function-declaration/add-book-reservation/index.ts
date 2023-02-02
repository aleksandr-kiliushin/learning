class Book {
  private _reservations: { customerName: string; hasPriority: boolean }[]

  constructor() {
    this._reservations = []
  }

  addReservation({ customerName, hasPriority }: { customerName: string; hasPriority: boolean }) {
    this._reservations.push({ customerName, hasPriority })
  }

  get reservations() {
    return this._reservations
  }
}

const book1 = new Book()
book1.addReservation({ customerName: "Peter", hasPriority: true })
book1.addReservation({ customerName: "John", hasPriority: false })
book1.addReservation({ customerName: "Petty", hasPriority: false })

const book2 = new Book()
book2.addReservation({ customerName: "Anna", hasPriority: false })
book2.addReservation({ customerName: "Julia", hasPriority: true })
book2.addReservation({ customerName: "Rebecca", hasPriority: true })
book2.addReservation({ customerName: "Peter", hasPriority: false })
book2.addReservation({ customerName: "Leo", hasPriority: false })

const book3 = new Book()
book3.addReservation({ customerName: "Judi", hasPriority: false })
book3.addReservation({ customerName: "Claudia", hasPriority: false })
book3.addReservation({ customerName: "Suzan", hasPriority: true })

export default Book
