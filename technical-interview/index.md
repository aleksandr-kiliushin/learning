# TECHNICAL INTERVIEW

## ARCHITECTURE

<details open>
<summary>Structured programming</summary>

- also known as «modular»;
- three basic patterns: **sequence**, **selection** (conditions) and **repetition** (loops);
  ![Structured programming patterns](./images/structured-programming-patterns.png)
- facilitates **readable** code and **reusable** components;
- encourages **hierarchy** of modules;
- uses **constuctions** like `if`, `while`;
- unconditional transfer of control (`goto`) is **prohibited**;
- improves code **quality**;
- **decomposes** large-scale problem statements into functions;
- enables **testing**;
- eliminates «spaghetti» code;
- all others paradighms are subtypes of SP;
- all **modern languages** use SP.

</details>

<details>
<summary>Functional programming</summary>

- 🧼 pure functions;
- 🐢 immutability;
- 🐚 disciplined state;
- 𝑓 first-class functions and higher-order functions;
- 👥 referential transparency (we can replace a function call with its invocation result and the final result will be the same);
- 💾 expensive;

### PURE FUNCTIONS

A pure function is an architectural **complexity dead end** because for the external system its complexity is reduced to only the its arguments and the return value (its API).

In contrast:

- in OOP, object methods mutate the state of the object;
- in PP, code mutates global state;

In practice, some functions designed to be pure, may end up to interact with broader context (e. g. «effects» in React).

### FIRST CLASS FUNCTIONS

In FP, **functions** are treated **as data**: we assign functions to variables, pass as arguments to other functions. It gives flexibility.

### HIGHER ORDER FUNCTION

HOF is a function that **operates upon a function** – accepts a function as an argument or returns a function.

### IMMUTABILITY

Avoid side effects. **Don't modify** the arguments and data **outside** the function. Instead, the **return** value should reflect the work done.

#### SEGREGATION OF MUTABILITY

It's not really to make everything immutable, because it requires a lot of storage and processor speed.

🤔 One of the compromises is to **segregate** the app into **mutable and immutable** parts.  
🧼 The immutable components **perform their tasks** in a purely functional way.  
🤝 Immutable components **communicate** with mutable ones.

![Mutating state and transactional memory](./images/mutating-state-and-transactional-memory.png)

So what?

- 👍 it's wise to push as **much** processing as possible **into** the **immutable** components;
- 👋 we should drive as **much** code as possible **from mutable** components;

#### EVENT SOURCING

📱 The faster modern processors, the less actual memory issues, the more immutability we can allow.

An example:

- 🏦 we have a banking **app** that maintains the account **balances** of its customers;
- 😩 it **mutates balances** when deposit and withdrawal transactions are executed;
- 🤔 imagine that **instead** of storing the account balances, we **store** only the **transactions**;
- ∑ whenewer anyone wants to know their account balance, we simply **add up all the transactions** for that account, from the beginning of time;
- 🤩 this scheme requires **no mutable** variables;
- 😔 but this approach is absurd because the number of transactions grow without bound, so to make this scheme work forever we need **infinite storage and** infinite processing **power**;
- 🤔 but perhaps we don't have to make the scheme work forever, perhaps we have enough storage and processing power to make the scheme work for the reasonable lifetime;
- 👆 this is the idea behind event sourcing;
- ∑ **event sourcing is a strategy wherein we store the transactions, but not the state**; when the state required, we simply **apply all the transactions from the beginning of time**;
- 💡 we can **optimize** the process by **computing and saving the state every midnight**; so, during the day, we will make calculations based on this saved state and transactions executed from midnight.

</details>
