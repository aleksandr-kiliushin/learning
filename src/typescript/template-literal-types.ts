type TWorld = "world"
type TGreeting = `Hello, ${TWorld}.` // "Hello, world."

type TDomainNameWithoutCom<T> = T extends `${infer R}.com` ? R : never
type TGoogle = TDomainNameWithoutCom<"google.com"> // "google"
