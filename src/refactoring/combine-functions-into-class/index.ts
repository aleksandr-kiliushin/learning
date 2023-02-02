export type IUser = {
  brothers: number[]
  name: string
  sisters: number[]
}

class User {
  private _brothers: IUser["brothers"]
  private _name: IUser["name"]
  private _sisters: IUser["sisters"]
  constructor(aUser: IUser) {
    this._brothers = aUser.brothers
    this._name = aUser.name
    this._sisters = aUser.sisters
  }
  get hasSiblings() {
    return this._brothers.length + this._sisters.length > 0
  }
  get siblingsCount() {
    return this._brothers.length + this._sisters.length
  }
}

const stringifyUserInfo = ({ aUser }: { aUser: IUser }) => {
  const user = new User(aUser)
  return `User ${aUser.name} has ${user.hasSiblings ? user.siblingsCount : "no"} siblings.`
}

export default stringifyUserInfo
