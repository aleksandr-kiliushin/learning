export type User = {
  brothers: number[]
  name: string
  sisters: number[]
}

export interface EnrichedUser extends User {
  hasSiblings: boolean
  siblingsCount: number
}

const getHasUserSiblings = ({ aUser }: { aUser: User }) => {
  return aUser.brothers.length + aUser.sisters.length > 0
}

const countUserSiblings = ({ aUser }: { aUser: User }) => {
  return aUser.brothers.length + aUser.sisters.length
}

const enrichUserData = ({ aUser }: { aUser: User }): EnrichedUser => {
  return {
    ...aUser,
    hasSiblings: getHasUserSiblings({ aUser }),
    siblingsCount: countUserSiblings({ aUser }),
  }
}

export default enrichUserData
