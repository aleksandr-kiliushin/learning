# TECHNICAL INTERVIEW

## ARCHITECTURE

<details>
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

We can't make everything immutable, because it requires a lot of storage and processor speed.

🤔 One of the compromises is to **segregate** the app into **mutable and immutable** parts.  
🧼 The immutable components **perform their tasks** in a purely functional way.  
🤝 Immutable components **communicate** with mutable ones.

![Mutating state and transactional memory](./images/mutating-state-and-transactional-memory.png)

So what?

- 👍 it's wise to push as **much** processing as possible **into** the **immutable** components;
- 👋 we should drive as **much** code as possible **from mutable** components;

#### EVENT SOURCING

> Event storing is a pattern for **storing data as events in an append-only** log.

- events are the **source of truth**;
- ES allows to **store the context** of the event: its timestamp, reason, etc.;
- to **source (derive) the state from the events**, we replay all the events in order of occurence;
- ES enables **audit**, **time travel** and **reshape**.
- state deriving can be **optimized by computing and saving the state**, e. g. every midnight; so, during the day, we calculate based on this saved state and the transactions executed from midnight.

</details>

<details open>
<summary>Object-oriented programming</summary>

TODO: ADD DEFINITION.

#### ENCAPSULATION

OO languages provide easy and effective encapsulation of data and function. As a result, a line can be drawn around a cohesive set of data and functions. Outline of that line, the data is hidden and only some of the functions are known.

Clients of the code don't have direct access to either the data or the internal implementation. They call methods that return the data in a reasonable format.

- Incapsulation is available in non-OO languages (like C), but OO languages (like C++) are a lot more frendly for it.
- Some OO languages provide useful keywords like `public`, `private` and `protected`, encouragin encapsulation.
- Some OO languages like Java and C# abolished the header / implementation split altogether, thereby weaking encapsulation. In these languages it's impossible to separate the declaration and definition of a class.

For these reasons, it's difficult to accept that OO depends on strong encapsulation. Indeed, many OO languages have little or no enforced encapsulation.

#### INHERITANCE

Technically, inheritance is a redeclaration of a group of variables and functions within an enclosing scope.

In the context of inheritance, OO languages haven't given us anything completely new. Long before OO languages were invented, we had tricks to implement inheritance. OOP introduced a more convenient way to implement inheritance, and multiple inheritance in particular.

#### POLYMORPHISM

- is the ability of any data to be processed in more than one form;
- _poly_ means _many_, _morphism_ means _types_;
- allows to represent a function in many types and many forms;
- lets the system choose which function to call based on type and parameter signatures.

Here, OOP still invents nothing completely new, but provides a way to implement polymorphism much safer, convenient and even trivial.

The `+` operator in JS is polymorphic, as it can either sum or concatenate, depending on the data type of its operands.

OO imposes discipline on indirect transfer of control.

</details>
