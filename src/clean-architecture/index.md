# SUMMARY: CLEAN ARCHITECTURE BY ROBERT C. MARTIN

## GLOSSARY

- **SRP** – single responsibility principle;
- **OCP** – open / closed principle;
- **LSP** – Liskov substitution principle;
- **ISP** – interface segregation principle;
- **DIP** – dependency inversion principle;
- **REP** – reuse / release equivalence principle;
- **CCP** – common closure principle;
- **CRP** – common reuse principle;
- **ADP** – acyclic dependencies principle;
- **SDP** – stable dependencies principle;
- **SAP** – stable abstractions principle;

## FOREWORD

> **Architecture** represents the **significant design decisions that shape a system**, where significant is measured by cost of change.

System's development changes should be:

- ~~💸 costly~~;
- ~~🤯 hard to make~~;
- ~~🏭 managed projects of their own~~;
- 🥱 easy to implement;
- 🧘 folded into the daily workflow.

There are a lot of paths to build the architecture:

- 🗿 Architecture can be too strong and stable, born from **authority and rigidity**.  
  If change is expensive, change is eliminated, which causes subdued or headed off into a bureacratic ditch.  
  Totalitarism in architecture becomes a dystrophia for developers and a constant source of frustration for all.
- 🤡 Architecture can have a strong smell of **speculative generality**.  
  Your project becomes filled with hard-coded guesswork, countless parameters, tombs of dead code, and more complexity than your maintanance budget can allow.
- 😊 Architecture can be **maintanable and flourishing**.
  - SW softness is preserved as a first-class property of the system;
  - new things are discovered and created;
  - questions are asked;
  - experiments are ran.

A good architecture is ~~a destination or a frozen artifact~~ an ongoing process like a jorney or enquiry.

## PREFACE

SW systems are created for different domains and using various technologies. But they share similar rules of architecture: rules are about ordering and assembling the building blocks of programs.

## PART I. INTRODUCTION

Getting SW working is easy. Kids, students and juniors create programs. The code they produce may not be pretty, but it works because getting something to work – once – is easy.

Gettings SW right is hard. It requires knowledge, skills that most programmers do not take time to develop. It requires high level of and discipline and didication that most programmers never dreamed they'd need. It takes a passion for the craft and the desire to be a professional.

When your SW is done right:

- ~~you need hords of programmers to keep it working~~;
- ~~you need massive requirements documents and huge issue tracking systems~~;
- ~~you need 24/7 programming~~;
- ~~bad code and rotten design~~;
- ~~exhausted patience of the managers~~;
- ~~trivial changes require two-week digging and involve high risks~~;
- the system structure is intuitive;
- you need only a fraction of human resources to create and maintain;
- changes are simple and rapid;
- defects are few and far between;
- effort is minimized;
- functionality and flexibility are maximized;
- customers are happy, managers trust you.

### CHAPTER 1. WHAT IS DESIGN AND ARCHITECTURE

Design and architecture are the same. The word «architecture» is often used to describe high-level concepts that are divorced from low-level details. The word «design», conversely, more often implies structures and decisions at a low level.  
But this separation is nonsensical when you look what a real architect does.  
Low-level details and high-level decision are all part of the same whole. There is no clear dividing line between them. There is simply a continuum of decisions from the highest to the lowest levels.

#### THE GOAL

> The **goal** of SW architecure is to **minimize the human resources required** to build and maintain the required system.

The **measure of design quality** is the measure of the **effort required** to meet the customer's needs.  
The effort is low, and stays low throughout the lifetime of the system? The design is good.  
The effort grows with each release? The design is bad.

#### CASE STUDY

You can measure how some interesting measures change during the system lifetime.

- engineering staff amount;
- time per codeline;
- codeline cost;
- company's monthly development payroll;
- other productivity indices.

#### THE SIGNATURE OF A MESS

When a system is messy, the developers' job becomes «moving the mess from one place to the next, and the next», so that they can add one more inadequately little feature. The company's earnings fall down, developers frustrate, managers are in rage.

#### WHAT WENT WRONG

The morals of the «Tortoise and the Hare» story:

- slow and steady wins the race;
- the race is not to the swift, nor the battle to the strong;
- the more haste, the less speed.

Most developers work hard, but a part of their brain sleeps – the part that knows that clean, well-designed code matters.

Another mistake: «We can clean it up later, we just have to get to market first!» – the Hare's mistake.  
Why later? Do you think you will not have to get new features done? Or maybe the «Pause the market» button will suddenly appear?  
These developers are overconfident in their ability to remain productive.  
Writing messy code makes them go fast in the short term and slows them down in the long term.

> The only way to go fast, is to go well.

Stop be overconfident.  
Start taking the responsibility for the mess you've made.

The solution is ~~to start over from scratch and redesign the whole system~~. No, it will be just another manifestation of the same overconfidence that led to the mess.  
Their overconfidence will drive the redesign into the same mess as the original project.

#### CONCLUSION

- Recognize and **avoid your overconfidence**.
- Start taking the quality of your SW **seriously**.
- You need to **know what good architecture is**, what **its attributes** are.

### CHAPTER 2. A TALE OF TWO VALUES

Every SW system provides two different values to the stakeholders: behavior and structure.  
Developers are responsible for ensuring that both of them remain high.  
Unfortunetely, developers often focus of one of them, leaving the SW system eventually valueless.

#### BEHAVIOR

Developers are hired to make machines to behave in a way that makes or saves money for the stakeholders.  
We do this by helping the stakeholders to develop a functional specification, or requirements document.  
Many programmers think that is the entirely of their job. They are sadly mistaken.

#### ARCHITECTURE

The second value of SW relates to the softness of SW. SW is intended to be a way to easily change the behavior of machines.

To fulfill its purpose, SW must be soft.  
**When the stakeholders change their minds about a feature**, that change should be **easy to make**.  
The difficulty in making such a change should be proportional only to the scope of the change, and not to the shape of the change.

#### THE GREATER VALUE

What is more important for the SW system – to work, or to be easy to change?

Business managers likely say it's more important for the SW system to work. Developers, in turn, often go alogn with this attitude. But it's a wrong attitude.  
Let's examine the extremes:

- Extreme 1:
  - a program works perfectly;
  - it's impossible to make changes when the requirements change;
  - therefore the program will become useless.
- Extreme 2:
  - a program does not work;
  - it is easy to make it work;
  - it is easy to keep it working as requirements change;
  - therefore the program will remain continually useful.

Yes, these are theoretical extremes and there are no programs that are unable to be changed.  
But there are changes-unfriendly systems, when the cost of change exceeds the benefit of change.  
Many systems reach that point in some of their features or configurations.

- 🧑‍💻 Do you want to be able to make changes in the future?
- 🧑‍💼 Of course, but the current functionality is more important than any later flexibility.
- ⏱️ A couple of months later ...
- 🧑‍💼 We need to make changes accordint to this requirements list.
- 🧑‍💻 Estimated cost of these changes will unaffordably high.
- 🧑‍💼 How did you let the system get to this point?

#### EISENHOWER'S MATRIX

|                      |                          |
| -------------------- | ------------------------ |
| Important + urgent   | Important + not urgent   |
| Unimportant + urgent | Unimportant + not urgent |

The first value of SW – behavior – is urgent but never particulary important.  
The second value of SW – architecture – is important but never particulary urgent.

Of course, some things are both important and urgent, and some – both unimportant and not urgent.

The dilemma for developers is that managers are not equipped to evaluate the importance of architecture. That's what developers were hired to do.  
It's the **responsibility of the SW development team to assert the importance of the architecture** over the urgency of features.

#### FIGHT FOR THE ARCHITECTURE

Fulfilling this responsibility means wading into a fight.  
The development team has to **struggle for** what they believe to be **best for the company**.  
And so do the management team, and the marketing team, and the sales team.

Effective SW developers uabashedly squabble with all the other stakeholders as equals.  
Remember, as a SW **developer**, you are a **stakeholder**. You have a **stake** in the SW that you need to **safeguard**.  
It's a part of you **role**, of your **duty**. It's a big part of **why you were hired**.

This challenge is doubly important if you're a SW architect. Architects are focused on creating an architecture that allows features to be easily developed, modified and extended.

If architecture comes last, then the system will become ever more costly to develop. This means that the SW development team did not fight hard enough.

## PART II. STARTING WITH THE BRICKS: PROGRAMMING PARADIGMS

### CHAPTER 3. PARADIGM OVERVIEW

No content.

#### STRUCTURED PROGRAMMING

Imposes discipline on direct transfer of control.

#### OBJECT-ORIENTED PROGRAMMING

Imposes discipline on indirect transfer of control.

#### FUNCTIONAL PROGRAMMING

Imposes discipline on variable assignment.

#### FOOD FOR THOUGHT

Each of the paradigms **removes capabilities** from the programmer. None of them adds new capabilities. Each imposes extra **discipline**. The paradigms tell us **what not to do**, more than what to do.

#### CONCLUSION

No content.

### CHAPTER 4. STRUCTURE PROGRAMMING

No content.

#### PROOF

No content.

#### A HARMFUL PROCLAMATION

No content.

#### FUNCTIONAL DECOMPOSITION

No content.

#### NO FORMAL PROOFS

No content.

#### SCIENCE TO THE RESQUE

No content.

#### TESTS

No content.

#### CONCLUSION

No content.

### CHAPTER 5. OBJECT-ORIENTED PROGRAMMING

> OOP is a programming paradighm that relies on the **concept of classes and objects**.

OO is the proper **admixture** of encapsulation, inheritance and polymorphism.

#### ENCAPSULATION

No content.

#### INHERITANCE

No content.

#### POLYMORPHISM

No content.

##### THE POWER OF POLYMORPHISM

No content.

##### DEPENDENCY INVERSION

No content.

#### CONCLUSION

OOP is the ability, through the use of polymorphism, to gain absolute control over every source code dependency in the system.

### CHAPTER 6. FUNCTIONAL PROGRAMMING

No content.

#### SQUARES OF INTEGERS

No content.

#### IMMUTABILITY AND ARCHITECTURE

No content.

#### SEGREGATION OF MUTABILITY

No content.

#### EVENT SOURCING

No content.

#### CONCLUSION

🚨 Each of the paradighms take something away from us. None of them has added to our power or out capabilities.  
🙅 What we have learned over the last half-of-century is what not to do.  
📖 The rules of SW are the same today as they were in 1946.  
👉 SW is composed of sequence, selection, iteration, and indirection.

## PART III. DESIGN PRINCIPLES

No content.

### CHAPTER 7. THE SINGLE RESPONSIBILITY PRINCIPLE

No content.

#### SYMPTOM 1: ACCIDENTAL DUPLICATION

No content.

#### SYMPTOM 2: MERGES

No content.

#### SOLUTIONS

No content.

#### CONCLUSION

No content.

### CHAPTER 8. THE OPEN-CLOSED PRINCIPLE

No content.

#### A THOUGH EXPERIMENT

Suppose, we have a system that displays a financial summary on a web page. The data is scrollable, negative numbers are rendered in red.

The stakeholders ask to make it printable as a report on a black-and-white printer. It should have pagination, page header, footer and labels. Negative numbers should be surrounded with parentheses.

Clearly, some new code must be written. But how much old code will have to change?

A good SW architecture reduces the amount of changed code to the barest minimum. Ideally, zero.

How?

- by properly separating the things that change for different reasons (SRP);
- and then organizing the dependencies between those things properly (DIP);

First, apply the SRP:

```mermaid
graph LR
  financialData(Financial data)
  financialAnalyzer[Financial analyzer]
  financialReportData(Financial report data)
  webReporter[Web reporter]
  printReporter[Print reporter]

  financialData-->financialAnalyzer-->financialReportData
  financialReportData-->webReporter
  financialReportData-->printReporter
```

The general insight here is that generating the report involves two separate responsibilities:

- report data calculation;
- presentation of the data into a web- and printer-friendly form.

Having made this separation, we need to organize the source code dependencies to ensure that changes to one of those responsibilities do not cause changes in the other.

![Partioning the processes into classes and separating the classes into components](./images/partioning-the-processes-into-classes-and-separating-the-classes-into-components.png)

Legend:

- separate components are indicated by a double-line border;
- `<I>` – interfaces;
- `<DS>` – data structures;
- open arrowheads – _using_ relationships;
- closed arrowheader – _implements_ or _inheritance_ relationships;

Some things to notice:

1. All the dependencies are the source code dependencies.  
   `class A --> class B` means that the source code of `A` mentions the name of `B`, but `B` mentions nothing about `A`.  
   For example, `FinancialDataMapper` knows about `FinancialDataGateway` through an _implements_ relationship, but `FinancialDataGateway` knows nothing at all about `FinancialDataMapper`.
2. Each double line is crossed in one direction only.  
   These arrow point toward the components that we want to protect from change.

> If a component A should be protected from changes in component B, then component B should depend on component A.

In our scheme we want to:

- protect the Presenters from changes in the Views;
- protect the Controller from changes in the Presenters;
- protect the Interactor from changes from anything.

The Interactor is in the position that best comforms to the OCP.  
Changes to the Database, or the Controller, or the Presenters, or the Views will have no impact on the Interactor.

Why should the Interactor hold such a priveleged position?

- the Interactor contains the BRs;
- the Interactor contains the highest-level policies of the app;
- all the other components deal with peripheral concerns;
- the Interactor deals with the central concern;

More about the scheme:

- the Controller is peripheral to the Interactor, but it's central to the Presenters and Views;
- the Presenters are peripheral to the Controller, but they're central to the Views;

There is a hierarchy of protection:

- Interactors are the highest-level concepts, so they're most protected;
- Views are the lowest-level concepts, so they're the least protected;
- protection of components gradualy reduces from Interactors to Views.

This is how the OCP works at the architectural level:

- architects separate functionality based on how, why, and when it changes;
- then they organize that separated functionality into a hierarchy of components;
- higher-level components in that hierarcy are protected from changes made to lower-level components.

#### DIRECTIONAL CONTROL

Much of the complexity in the diagram is intended to point the dependencies between the components in the correct direction.

For example, the `FinancialDataGateway` interface between the `FinancialReportGenerator` and the `FinancialDataMapper` exists to invert the dependency that would otherwise have pointed from the Interactor component to the Database component.  
The same is true for the `FinancialReportPresenter` and the two View interfaces.

#### INFORMATION HIDING

The `FinancialReportRequester` interface serves a different purpose. It protects the `FinancialReportController` from knowing too much about the internals of the Interactor. Without `FinancialReportRequester`, the Controller would have transitive dependencies on the `FinancialEntities`.

Transitive dependencies are a violation of the general principle that SW entities shouldn't depend on things that they do not directly use.

Our first priority is to protect the Interactor from changes to the Controller.  
We also want to protect the Controller from changes to the Interactor by hiding the internal of the interactor.

#### CONCLUSION

No content.

### CHAPTER 9. THE LISKOV SUBSTITUTION PRINCIPLE

No content.

#### GUIDING THE USE OF INHERITANCE

Imagine that we have a `License` class.  
This class has a method `calcFee`, which is called by the `Billing` app.  
There are two «subtypes» of `License`: `PersonalLicense` and `BusinessLicense`. They use different algorithms to calculate the license fee.

![License, and its derivatives, conform to LSP](./images/license-and-its-derivatives-conform-to-lsp.png)

The design conforms to the LSP because the behavior of the `Billing` app does not depend, in any way, on which of the two subtypes it uses. Both of the subtypes are substitutable for the `License` type.

#### THE SQUARE / RECTANGLE PROBLEM

![The infamous square / rectangle problem](./images/the-infamous-square-rectangle-problem.png)

In this example, `Square` isn't a proper subtype of `Rectangle`, because the height and width of the `Rectangle` are independently mutable; in contrast, the height and width of the square must change together.  
The LSP is violated.

#### LSP AND ARCHITECTURE

The LSP concerns not only how to use **inheritance**.  
The LSP has morphed into a **broader principle** that pertains to **interfaces** and **implementations**.

The LSP is applicable when users depend on **well-defined interfaces**, and on the **substitability of the implementations** of those interfaces.

#### EXAMPLE LSP VIOLATION

Suppose we have a RESTful system that serves for a taxi aggregator.

An order endpoint example:

```
purplecab.com/driver/Bob
  /pickupAddress/24 Maple St.
  /pickupTime/153
  /destination/ORD
```

A new taxi vendor «Acme» has been joined to our aggregator.  
Their developers did not read the aggregator API docs very carefully and used `dest` instead of `destination` in URL.  
Suppose, there is no way to fix this on their side.

What would happen to our architecture? Obviously, we'd need to add a special case. Requests from «Acme» drivers should be processed using a different set of rules.

The simplest way to accomplish this goal is:

```
if (driver.getDispatchUri().startsWith("acme.com")) { ... }
```

No sane architect would add such a construct to the system that mentions `"acme.com"`. We do not want to have mysterious errors and other consequenses. If there will be another case for the «PurpleTaxi» vendor, will we add one more `if`?

More clean and scalable solution would be to add a configuration file like this:

```
{
  "Acme.com": "/pickupAddress/%s/pickupTime/%s/dest/%s",
  "*.*": "/pickupAddress/%s/pickupTime/%s/destination/%s",
}
```

#### CONCLUSION

The LSP can, and should, be extended to the level of architecture. A simple violation of substitutability can cause a system's architecture to be polluted with a significant amount of extra mechanisms.

### CHAPTER 10. THE INTERFACE SEGREGATION PRINCIPLE

No content.

#### ISP AND LANGUAGE

No content.

#### ISP AND ARCHITECTURE

No content.

#### CONCLUSION

No content.

### CHAPTER 11. THE DEPENDENCY INVERSION PRINCIPLE

No content

#### MORE ABOUT DEPENDENCY INVERSION

No content.

#### STABLE ABSTRACTIONS

No content.

#### FACTORIES

Creation of volatile concrete objects requires special handling.  
In most OO languages we'd use an Abstract Factory to manage this undesirable dependency.

![Use of the Abstract Factory pattern to manage the dependency](./images/use-of-the-abstract-factory-pattern-to-manage-the-dependency.png)

The `Application` uses the `ConcreteImpl` through the `Service` interface. However, the `Application` must somehow create instances of the `ConcreteImpl`. To achieve this without creating a source code dependency on the `ConcreteImpl`, the `Application` calls the `makeSvc` method of the `ServiceFactory` interface. This method is implemented by the `ServiceFactoryImpl` class, which derives from `ServiceFactory`. That implementation instantiates the concrete `ConcreteImpl` and returns it as a `Service`.

The curved line is an architectural boundary. It separates the abstract component from the concrete component. All source code dependencies cross that curved line pointing in the same direction, toward the abstract side.  
The abstract component contains all the high-level BRs. The concrete component contains all the implementation details of those BRs.

The flow of control crosses the curved line in the opposite direction of the source code dependencies – which is why we refer to this principle as Dependency Inversion.

#### CONCRETE COMPONENTS

The concrete component in figure 11.1 contains a single dependency, so it violates the DIP. This is typical. DIP violations cannot be entirely removed but they can be gathered into a small number of concrete components and kept separate from the rest of the system.

#### CONCLUSION

As we cover higher-level architectural principles, the DIP will show up again and again.  
The DIP will be the most visible organizing principle in our architecture diagrams.  
The curved line in figure 11.1 will become the architectural boundaries in later chapters.  
The way the dependencies cross the curved line in one direction, and toward more abstract entities, will become a new rule called the Dependency Rule.

## PART IV. COMPONENT PRINCIPLES

SOLID tells us how to arrange bricks into walls and rooms. Component principles tells us how to arrage the rooms into buildings.

### CHAPTER 12. COMPONENTS

A component is an **independently developable and independently deployable unit**.

#### A BRIEF HISTORY OF COMPONENTS

No content.

#### RELOCATIBILITY

No content.

#### CONCLUSION

After 50 years, we has arrived to component plugin architecture to be the casual default.

### CHAPTER 13. COMPONENTS COHESION

Which modules belong to which components?

The three principles of component cohesion:

- **REP**: the reuse / release equivalence principle;
- **CCP**: the common closure principle;
- **CRP**: the common reuse principle.

#### THE REUSE / RELEASE EQUIVALENCE PRINCIPLE

> A granule of reuse it a granule of release.

Anything that we reuse must be released and tracked.

Release **numbers** and release **notes** for a component allow:

- reused components are compatible with each other;
- ease integration of new versions.

REP gives us our first **hint at how to partition** our design into components.

The principle means that the **modules formed into a component** must belong to a **cohesive group**. A component cannot consist of a random mixture of modules. There must be a **common purpose** all modules share. It's quite obvious.

What is not obvious: modules grouped together into a component should be **releasable**. The same release number, release tracking and release docs should make sense both to the author and the users.

#### THE COMMON CLOSURE PRINCIPLE

> Gather together into components those modules that change at the same times and for the same reasons. Separate those modules that change at different times and for different reasons.

This is the SRP restated for components.

For most apps, **maintainability is more important than reusability**. If an app code must change, you would prefer the **changes** to be **concentrated in a single component**, rather than be distributed across many components. So, we deploy only the changed component. The others do not even know about the changes.

#### THE COMMON REUSE PRINCIPLE

> Do not force users of a component to depend on things they do not need.

CRP is another principle that helps us to decide which modules should be placed into a component. **Modules that tend to be reused together belong to the same component.** In such a component, we would expect to see **modules** that have lots of **dependencies on each other** – coupled modules.

The CRP tells us:

- which modules **to put together** in a component;
- which modules **not to put together** in a component;

CRP tells us that **modules that aren't tightly bound** to each other should be in **separate** components.

The more our app grows, the more we begin to concern about reusable components, the more the CRP influences the components composition.

##### RELATION TO ISP

**CRP** is the **generic** version of **ISP**:

- ISP tells us not to depend on **modules** that have **methods** we do not use;
- CRP tells us not to depend on **components** that have **modules** we do not use.

In general: **do not depend on things you do not need**.

#### THE TENSION DIAGRAM FOR COMPONENT COHESION

The three component principles tend to fight each other:

- **REP** and **CCP** are **inclusive**: both tell to **make components larger**;
- **CRP** is **exclusive**: it tells to **make components smaller**.

This is the **tension** between these principles that good architects seek **to resolve**.

**Tension diagram** tells **how** the three **principles** of cohesion **interact** with each other.  
The edges of the diagram describe the **cost of abandoning** the principle on the opposite vertex.

![Tension diagram for component cohesion](./images/tension-diagram-for-component-cohesion.png)

Conclusions:

- **focusing** on just the **REP and CRP** causes that too **many components are impacted** when simple changes are made;
- **focusing** on just the **REP and CCP** causes too many **unneedeed releases** to be generated.

A good architect **finds a position** in that tension triangle **that meet the current concerns** of the development team.  
A good architect is also aware that those **concerns change over time**. For example, early in the development of a project, the CCP is much more important than the REP, because develop-ability is more important than reuse.

Generally, projects **tend to start on the right** hand side of the triangle, where **the only sacrifice is reuse**. As the project **matures** and other projects begin to draw from it, the project will **slide over to the left**. This means that the **component structure** of a project can **vary with time and maturity**. It has more to do with the way the project is developed and used than with what the project actually does.

#### CONCLUSION

**Balancing** these forces with the needs of the app is **nontrivial**. Moreover, the **balance is** almost always **dynamic**.

### CHAPTER 14. COMPONENT COUPLING

The next **3 principles** deal with the **relationships between components**. Here again we'll run into **tension between develop-ability and logical design**. The forces that impinge upon the architecture are technical, political and volatile.

#### THE ACYCLIC DEPENDENCIES PRINCIPLE

> Allows no cycles in the component dependency graph.

The dependency structure must always be **monitored for cycles**. When **cycles** occur, they **must be broken**. Sometimes, this will mean creating a new component, making the dependency structure grow.

##### THE WEEKLY BUILD

No content.

##### ELIMINATING DEPENDENCY CYCLES

We should **partition** the development environment **into releasable components**. A component becomes a **unit of work** that can be **responsibility of a developer or a team**. When developers get a component working, they give it a number and **release** it **for** the **others**. Each team start **using** the new version **as soon as** they are **ready** to migrate to it. **Small steady increments** instead of immediate affects.

To make it work, you must manage the dependency structure of the components.

![Typical component diagram](./images/typical-component-diagram.png)

The structure has **no cycles**, it is a **directed acyclic graph**.

Example:

- a new version of `Presenters` is released;
- we need to find affected components;
- we just follow the dependency arrows backward (`View` and `Main`).

When `Main` is released, it has no effect on any component of the system. They do not know about `Main` and they do not care when it changes. It means that the impact of releasing `Main` is relatively small.

The **process of building** the entire system is very **clear** because we **understand the dependencies** between its parts. It proceeds from the bottom up: first – `Entities`, last – `Main`.

##### THE EFFECT OF A CYCLE IN THE COMPONENT DEPENDENCY GRAPH

Cycles in dependency graph cause «morning after syndrome» (breaking code when someone else makes changes in the codebase) and make it difficult to release components.

With cycles, it can be **difficult** to work out the **order** in which you must build the components. There **probably** is **no correct order**.

##### BREAKING THE CYCLE

There are two ways:

1. apply the DIP;
2. create a new component that cycled components will both depend on.

##### THE "JITTERS"

No content.

##### TOP-DOWN DESIGN

A conclusion from the issues discussed so far: a **component structure cannot be designed from the top down**.

We should localize and **isolate volatility**.  
We **do not want components that change frequently** and for capricious reasons **to affect components that ought to be stable**. For example, we **do not want** cosmetic changes to the **GUI** to have an **impact** on our **BRs**.  
**Component dependency graph** is created by architects to **protect stable high-value components from volatile components**.

If we tried to design the component dependency structure before we designed any modules, we would likely fail. We would not know much about common closure -> we would be unaware of any reusable elements, and we would cernainly create components that produced dependency cycles. Thus the **component dependency structure evolves with the logical design of the system**.

#### THE STABLE DEPENDENCIES PRINCIPLE

> Depend in the direction of stability.

Design can't be completely static, **some volatility is necessary**. With CCP, we create components that are **sensetive** to certain kinds of changes but **immune** to others. **Some** of these components are **designed to be volatile**, we expect them to change.

A module that you designed to be easy to change **can be made difficult to change** by someone else who simply hangs a dependency on it.

**SDP says** that modules that are intended to be easy to change should not be depended on by modules that are harder to change.

##### STABILITY

Stability is related to the **amount of work required to make a change**.

One way to make a component difficult to change is to make lots of other SW components depend on it. A **component with lots of incoming dependencies is very stable** because it **requires** a great deal of **work** to reconcile any changes with all the dependent components.

```mermaid
graph TD
  componentA[ ]
  componentB[ ]
  componentC[ ]
  componentX[X]

  componentA-->componentX
  componentB-->componentX
  componentC-->componentX
```

About `X`:

- **3 components depend on `X`**, so `X` has three good **reasons not to change**; **`X` is responsible to** those three components;
- conversely, **`X` depends on nothing**, so it has **no external influence** to make it change; `X` is **independent**.

```mermaid
graph TD
  componentA[ ]
  componentB[ ]
  componentC[ ]
  componentY[Y]

  componentY-->componentA
  componentY-->componentB
  componentY-->componentC
```

About `Y`:

- **no components depend on `Y`**, so `Y` is **irresponsible**;
- there are three components that **`Y` depends on**, so **changes may come from 3 external sources**; `Y` is **dependent**.

##### STABILITY METRICS

One way to measure the stability of a component is to **count** the number of **dependencies** (imports) that **enter and leave** that component (it is called «positional» stability):

- **Fan-in**: **incoming dependencies** – the number of modules outside the component that depend on modules that are within the component.
- **Fan-out**: **outgoing dependencies** – the number of modules inside this component that depend on modules outside this component.
- Instability ranges from 0 to 1.  
  **I = 0** indicates a maximally **stable** component, **I = 1 – unstable**.

$$ Instability = {Fan–out \over Fan–in + Fan–out} $$

```mermaid
graph LR
  subgraph ComponentA
    ModuleU
    ModuleV
  end

  subgraph ComponentB
    ModuleW
  end

  subgraph <b>ComponentC</b>
    ModuleX
    ModuleY
  end

  subgraph ComponentD
    ModuleZ
  end

  ModuleU-->ModuleX
  ModuleV-->ModuleY
  ModuleW-->ModuleY
  ModuleY-->ModuleZ
```

About the `ComponentC`:

- Fan-in = 3;
- Fan-out = 1;
- Instability = 1 / (3 + 1) = 0.25.

> `I` of a component should be larger than `I` of the component that it depends on. `I` should decrease in the direction of dependency.

#### NOT ALL COMPONENTS SHOULD BE STABLE

If all the components in the system were maximally stable, the system would be unchangeable, which is not desired. We want some components to be stable and some – unstable.

```mermaid
graph TD
  ComponentA[Instable, <b>I = 1</b>]
  ComponentB[Instable, <b>I = 1</b>]
  ComponentC[Stable, <b>I = 0</b>]

  ComponentA-->ComponentC
  ComponentB-->ComponentC
```

The figure above: the changeable components on top depend on the stable component at the bottom.

```mermaid
graph TD
  ComponentA[Instable, <b>I = 1</b>]
  ComponentB[Instable, <b>I = 1</b>]
  ComponentC[<i>Supposed to be</i> stable, but <b>I = 0.33</b>]
  ComponentD[<i>Supposed to be</i> flexible, but <b>I = 0</b>]

  ComponentA-->ComponentC
  ComponentB-->ComponentC
  ComponentC-->ComponentD
```

The figure above:

- `Flexible` is a component we have designed to be easy to change, we want it to be flexible and unstable;
- some developer working on `Stable` has hung a dependency on `Flexible` – `Stable` depends on `Flexible`;
- as a result, `Flexible` is no longer easy to change; a change to `Flexible` will force us to deal with `Stable` and its dependents.

> Any component that we expect to be volatile should not be depended on by a component that is difficult to change. Otherwise, the volatile component will also be difficult to change.

We can fix it by using the DIP.

#### THE STABLE ABSTRACTIONS PRINCIPLE

> A component should be as abstract as it's stable.

##### WHERE DO WE PUT THE HIGH-LEVEL POLICY?

**High-level architecture and policy decisions** should not change very often. We do **not** want them to be **voliatile**. Such SW should be **placed into stable components** (`I = 0`). **Unstable components** (`I = 1`) should **contain** only the SW that is **volatile** – SW that we want to be able to **easily change**.

However, **if high-level policies** are placed **into stable components**, then the source code that represents those policies **will be difficult to change**. This could make the overall **architecture inflexible**. How a component with `I = 0` be flexible enough to windstand change? The **OCP helps** us. The OCP tells that it's possible and desirable to create classes that are flexible enough to be extended without requiring modification. Which kind of classes conform this principle? **Abstract classes.**

##### INTRODUCING THE STABLE ABSTRACTIONS PRINCIPLE

The **SAP** sets up a **relationship between stability and abstractness**.

The SAP states:

- a **stable component should be abstract** so that its stability does not prevent it from **being extended**;
- an **unstable components should be concrete** since it its instability allows the concrete code within it **to be easily changed**.

Thus, if a **component** is to be **stable**, it **should consist of interfaces and abstract classes** so that it **can be extended**. Stable components that are extensible are flexible and do not overly constrain the architecture.

**SAP + SDP = DIP for components.** Because SDP says that dependencies should run in the direction of stability, and SAP says that stability implies abstraction. Thus dependencies run in the direction of abstraction.

The DIP, however, deals with classes – and with classes there are no shades of gray. Either a class is abstract or it is not. SAP + SDP deals with components and allows that a component can be partially abstract and partially stable.

##### MEASURING ABSTRACTION

Abstractness (`A`) is the **ratio of interfaces and abstract classes** in a component **to** the **total** number of **classes** in the component.

- `Nc` – the number of classes in a component;
- `Na` - the number of abstract classes and interfaces in the component;
- `A` – abstractness, `A = Na / Nc`.

`A` ranges from 0 to 1. `A = 0` implies that the component has no abstract classes at all. `A = 1` implies that the component contains nothing but abstract classes.

##### THE MAIN SEQUENCE

Let's define relationships between `I` and `A`.

![The I / A graph](./images/the-instability-abstraction-graph.png)

There are two «good» kinds of components in this graph:

- stable and abstract at (0, 1);
- unstable and concrete (1, 0).

Not all components fall into one of these two positions, because components often have degrees of abstraction and instability.

![Zones of exclusion](./images/zones-of-exclusion.png)

«Zones of exclusion» shows reasonable positions and «bad» zones for components.

###### THE ZONE OF PAIN

A component at (0, 0):

- is **difficult to change** because it is highly stable and concrete;
- is not desirable because it is **rigid**;
- **cannot be extended** because it is **not abstract**;
- a well-designed component cannot take a position near (0, 0).

Example: a DB schema.  
It is volatile, concrete and highly depended on. Updating a DB schema is painful.

###### THE ZONE OF USELESSNESS

A component at (1, 1):

- maximally **abstract** + **no dependents** = **useless**;
- they are often abstract classes that noone ever implemented;

##### AVOIDING THE ZONES OF EXCLUSION

Our most **volatile components** should be kept from as **far from** both **zones of execution** as possible. The locus of points that are **maximally distant from each zone** is the **line** that connects (0, 1) and (1, 0), called the **main sequence**.

A component that sits on the main sequence:

- is **not "too abstract"** for its stability;
- is **not "too unstable"** for its abstractness;
- is **not** particularly **useless**;
- is **not** particularly **painful**;
- is **depended on** to the extent that it is abstract;
- is **depends on others** to the extent that it is concrete.

The **most desirable** positions are **(0, 1) and (1, 0)**. Good architects strive to position the majority of their components at those endpoints. In practice, some small fraction of components are neither perfectly anstract nor perfectly stable. Those components have the **best characteristics** if they are **on, or close, to the main sequence**.

##### DISTANCE FROM THE MAIN SEQUENCE

$$ D = |A + I - 1| $$

`D` ranges from 0 to 1. Components with `D` not near to zero can be reexamined and restructured. You can set a reasonable threshold, for example 0.1.

What can be calculated:

- `D` for each component:
  ![Plot of D for a project components](./images/plot-of-d-for-a-project-components.png)
- `D` for each component over time:
  ![Plot of D for a single component over time](./images/plot-of-d-for-a-single-components-over-time.png)
- mean `D` for an entire project;

#### CONCLUSION

No content.

## PART V. ARCHITECTURE

### CHAPTER 15. WHAT IS ARCHITECTURE?

Architects:

- ~~pull back from code to focus on higher-level issues, because they are not average devs~~;
- may **not** write as **much code** as other programmers do;
- **take programming tasks**, while they **also guide the team** toward a design that maximizes productivity;
- **take programming tasks to experience the effects** of their architectural decisions.

The **architecture** of a SW **system** is its **shape**:

- **division** of the system into components;
- **arrangement** of those components;
- **communication** between those components.

The **purpose** of architecture is to **facilitate the development, deployment, operation, and maintenance** of the SW system.

The **strategy** behind the facilitation is to leave as many **options open** as possible, for as long as possible.

For architecture, **supporting proper behavior** is:

- ~~the main goal~~;
- one of the responsibilities;
- critical;
- ~~active and essential~~;
- passive and cosmetic.

There are many systems with terrible architectures, that work just fine. Their troubles do not lie in their operation, but in their deployment, maintenance, and development.

The **primary purpose** of architecture is to **support the life cycle** of the system.

Good architecture makes the system:

- easy to understand;
- easy to develop;
- easy to maintain;
- easy to deploy.

The **ultimate goal** is to **minimize** the lifetime **cost** of the system and to **maximize** programmer **productivity**.

#### DEVELOPMENT

A system is **easy to develop** -> the system has **long and healthy lifetime**.

Different teams imply different architectural decisions:

- On the **one hand**, a **small team** can **effectively develop a monolithic system** without well-defined components or interfaces. Such a team would likely find the limitations of an architecture something of an impediment during the early days of development. This is a reason why some systems lack good architecture: they were begun with none, because the team was small and did not want the impediment of a superstructure.
- On the **other hand**, a system being developed by **several big teams**, **cannot progress unless** the system is **divided** into well-defined **components with** reliable stable **interfaces**.

#### DEPLOYMENT

A goal of architecture is to make deployment **fast and cheap** (ideally, deploy with a single action).

#### OPERATION

The **impact** of architecture on operation is **less** than on development, deployment and maintenance. Because hardware is cheap and people are expensive, many operational difficulties can be resolved by throwing more hardware (storage and servers) at the system.

The architecture should make the **operation appartent** and **elevate**:

- the UC,
- the features,
- the required behavior

of the system to first-class entities that are visible landmarks for the devs.

This **simplifies understanding** of the system and greatly aids in depevelopment and maintenance.

#### MAINTENANCE

Of all the aspects of a SW system maintenance is the most **costly**.

The **primary cost of maintenance** is in **spelunking and risk**.

**Spelunking is** the cost of **digging through the existing SW**, trying to determine the best place and the best strategy to add a new feature or to repair a defect. Making such changes is **costly and risky** because it introduces inadvertent defects.

A carefully thoughtful architecture **mitigates these costs**. Separating the system into components, and isolating those components through stable interfaces **illuminates the pathways** for future features and **reduces the risks** of inadvertent breakage.

#### KEEPING OPTIONS OPEN

Keep SW soft. The softness depends on how the components are formed and interconnected.

The way you keep SW soft is to leave as **many options open** as possible, for as **long** as possible. These options are the details that do not matter.

A **system** can be decomposed into **two major elements** – policy and details:

- **Policy** contains the **true value** of the system, it embodies BRs and procedures.
- **Details enable** humans, developers and other systems **to communicate with the policy**, but that **do not impact** the behavior of the **policy** at all. Details include DBs, servers, FWs, communication protocols, etc.

A good architecture recognizes **policy** as the most **essential** element of the system while making the **details irrelevant** to that policy. This **allows decision about** those **details** to be **delayed**.

- **build the architecture without committing any details**;
- **delay decisions** about the **details** as long as possible -> have the **options open** longer;
- run **experiments** and use various details (various DBs, FWs, servers, etc);
- at the moment when the decisions can no longer be deferred, have **more information** about the details applicability, performance, etc to **make the decisions properly**.

**If** the decisions have **already** been **made** by someone else, **pretend that** they have **not** beed **and shape the system** such that those decisions can still be deferred or changed for as long as possible.

> Maximize the number of decisions not made.

#### DEVICE INDEPENDENCE

No content.

#### JUNK MAIL

No content.

#### PHYSICAL ADDRESSING

No content.

#### CONCLUSION

No content.

### CHAPTER 16. INDEPENDENCE

As we previously stated, a good architecture must support:

- UCs and operation;
- maintenance;
- development;
- deployment.

#### USE CASES

The **first priority** of the architecture is to **support the intent** of the system. If the system is a shopping cart app, then the architecture must support shopping cart UCs.

Architecture **does not manage behavior**. Instead, it **supports behavior by clarifying and exposing that behavior** so that the intent of the system is visible at the architectural level.

A shopping cart app should look like a shopping cart app. Its **UCs should be plainly visible** within the structure of the system. Developers should not have to hunt for behaviors. The behaviors should be first-class elements visible at the top level of the system. Those elements should be modules that have prominent positions within the architecture and they should have names that clearly describe their function.

Chapter 21 «Screaming architecture» will make this point much clearer.

#### OPERATION

If the system must handle 100,000 customers per second or to query big data in milliseconds, then the **architecture must be structured to allow it**.

It may mean:

- an array of services running in parallel on different servers;
- an array of services running in parallel on a server in different threads;
- a simple monolithic program running in a single thread.

This decision is one of the options that a good architect leaves open. For example, it is hard to upgrade a monolith to a multiple processes, threads or services should the need arise.

#### DEVELOPMENT

Architecture plays a significant role in supporting the dev environment.

Conway's law:

> Any organization that designs a system will produce a design whose structure is the copy of the organization's communication structure.

A system that must be developed by many teams with different concerns must have an architecture that **facilitates independent actions** by those teams, so that the **teams do not interfere with each other** during development. This is accomplished by properly **partitioning** the system **into** well-isolated, independently developable **components**. Those components can be allocated to teams that can work independently of each other.

#### DEPLOYMENT

**The goal** is «immediate deployment» after build. A good architecture does not rely on dozens of configurations scripts and properly file tweaks.

Again, this is achieved through the proper **partitioning** and isolation of the **components**, including those master components that tie the whole system together and ensure that each component is properly started, integrated and supervised.

#### LEAVING OPTIONS OPEN

A good architecture **balances all of those concerns** with a component structure that mutually satisfies them all.

Achieving this balance is pretty hard. The problem is that all the UCs, the operational constrains and the deployment **requirements** are **unknown or dynamic** as the system moves through its life cycle. The goals we must meet are indistinct and inconstant.

Architecture principles help balance those concerns even when you do not have a clear picture. They help partition our system into well-isolated components that allow to leave as many options as possible, for as long as possible, making the system easy to change.

#### DECOUPLING LAYERS

The architect wants the structure that supports all the necessary UCs. He does not know what they are, but he knows the basic intent of the system. It is a shopping cart / bill of materials / orders processing. So the archictect can employ SRP and CCP to **separate** those things that change for different reasons and **collect** those things that change for the same reasons – **giving the context of the intent** of the system.

For example, GUI and BRs change for different reasons. Separate them so that they can be independently changed.

BRs may be closely tied to the app, or may be general. For example, the validation of the inputs is a BRs that is closely tied to the app. In contrast, the calculation of interest and the counting of inventory are BRs that are more closely associated with the domain. These two **different kinds of BRs** will change at different rates, and for different reasons – they should be **separated** to be changed independently.

The DB, the query language are **technical details** that **have nothing to do with the BRs or the UI**. The architecture should **separate them from the rest of the system** so that they can be independently changed.

Thus we find the system divided into **decoupled horisontal layers** – GUI, app-specific BRs, app-independent BRs, DB, etc.

#### DECOUPLING USE CASES

The **UCs themselves** also change for different reasons. «Adding an order» and «deleting an order» are two UCs that change at different rates and for different reasons. UCs are a very natural way to **divide** the system.

At the same time, **UCs** are narrow **vertical slices** that **cut through the horizontal layers** of the system. Each UC uses some UI, app-specific BRs, app-independed BRs, DB functionality. Thus, divide the system into horizontal layers and vertial UCs.

|                     | Add an order | Remove an order | Edit an order | List orders |
| ------------------- | ------------ | --------------- | ------------- | ----------- |
| UI                  | x            | x               | x             |             |
| App-specific BRs    | x            | x               | x             |             |
| App-independent BRs | x            | x               | x             |             |
| DB                  | x            | x               | x             |             |

To achieve this decoupling, we **separate** the **«add-order» UI** from the **«delete order» UI**, etc.

**You can add new UCs without interferring with old ones.** Each UC uses a different aspect of the UI and DB, then adding new UCs will unlikely affect older ones.

#### DECOUPLING MODE

Lets think about independence in context of operations. **If** the UI and the DB are **separated** from the BRs, then they **can run in different servers**.

To run components in separate servers, the components should not depend on being together on the same server / process / thread. They must be independed services, which communicate over a network of some kind.

Such components are often called «services» or «micro-services», and an architecture based on them is called «services-oriented» (SOA).

It is not about that SOA is the best possible architecture. The point is that **sometimes we have to separate** our **components** all the way to the **service level**.

#### INDEPENDENT DEVELOP-ABILITY

When **components decoupled**, the **interference** between teams is **mitigated**.

- The BRs do not know about the UI. Good. Thus the UI team does not affect the BRs team.
- The UCs are docoupled from one another. Good. Thus the team focusing on the «add order» UC will not interfere with the team focusing on the «delete order» UC.

Layers and UCs are decoupled -> architecture supports teams organization, irrespective of whether they are organized as feature teams, component teams, layer teams, etc.

#### INDEPENDENT DEPLOYABILITY

With well-done decoupling, it is possible to hot-swap layers and UCs in running systems. Adding a new case should be as easy as adding a new source code file.

#### DUPLICATION

Developers often fall into a duplication fear trap. Duplication is generally a bad thing in SW.

But there are different kinds of duplication:

- **True** duplication, in which every change in one instance necessitates **the same change to every duplicate** of it.
- **False (accidental)** duplication. If two appartently duplicated sections of code evolve along different paths – if they **change at different rates and for different reasons** – then they are not true duplicates. In a few years you will find them very different from each other.

How to resolve it:

- a **true** duplication is **recognized** -> the **instances are merged** into one instance -> code **maintanance** is made **cheaper**;
- an **accidental** duplication is **recognized** -> the **instances** are kept **separated** -> the **cases** will be **decoupled**.

#### DECOUPLING MODES (AGAIN)

Layers and UCs can be decoupled in different modes:

- **Source level.**  
  We control the dependencies between source code modules. So that changes to one module do not force change or recompilation of others.  
  Components execute in the same address space. They **communicate** with each other using simple **FN calls**. There is a **single executable** loaded into computer memory. It is often called **monolithic** architecture.
- **Deployment (binary code) level.**  
  We control the dependencies between deployable units (`.jar`s, `.gem`s, `.dll`s, shared libs, etc). So that changes to the source code in one module does not force others to be rebuilt and redeployed.  
  **Some** of the components **may still live in** the same address space, and communicate through FN calls. **Other** components **may live in** other processes in the same processor and communicate through interprocess communications, sockets, or shared memory. Important: the decoupled **components are partitioned into independently deployable units** (`.jar`s, `.gem`s, `.dll`s, shared libs, etc).
- **Service (execution unit) level.**  
  We reduce the dependencies down to the level of data structures and **communicate solely through network packets** such that **every execution unit is entirely independent of source and binary changes to others** (e. g., services or micro-services).

What is **the most optimal mode** to use? It is hard to say during the early phases of the project and the answer **changes during as the project matures**.

**Example**:

- **now** the system runs comfortably on one server, **source code level** decoupling (monolith) is sifficient;
- **in a year**, some components need to run in **different processes**;
- **in two years**, the system need some components to run in **separate services**.

**One solution** (popular at the moment) is to simply decouple at the service level by default.

Problems with this approach:

- it encourages coarse-grained decoupling; no matter, how "micro" the micro-services get, the decoupling is not likely to be fine-grained enough;
- it is expensive, both in development time and in system resources; dealing with service boundaries where none are needed is a waste of memory, cycles, and effort (memory and cycles are cheap, but effort is not).

It is wise to push **decoupling** to the point where a **service can be formed, should it become necessary**. **But** then to **leave** the components **at the same address space** as long as possible. This leaves the option for a service open.  
With this approach, initially the component are separated at the source code level. That may be good enough for the duration of the project's lifetime. If, however, development or deployment issues arise, driving some of the decoupling to a deployment level may be sufficient, at least for a while.  
As the development, deployment and operational issues increase, I **carefully choose**, which deployable units to turn into services, and **gradually shift** the system in that direction.  
Over time, the operational needs of the system **may decline**. What once required decoupling at the service level may now require only development- or deployment-level decoupling.

A good architecture allows a system to be born as a monolith, deployed as a single file, but then to grow into a set of independently deployable units, and then all the way to independent services and / or micro-services. Later, as things change, it should allow for reversing that progression and sliding all the way back into a monolith.

A good architecture protects the majority of the source code from those changes. It **leaves the decoupling mode open as an option** so that large deployments can use one mode, where as small deployment can use another.

It is tricky. Switching between decoupling modes is not a trivial configuration (though sometimes it is). Decoupling mode is likely to change with time a good architect foresees and appropriately facilitates these changes.

#### CONCLUSION

No content.

### CHAPTER 17. BOUNDARIES: DRAWING LINES

Architecture is the art of drawing lines that I call boundaries. Those boundaries **separate SW elements** from one another, and restrict those on one side **from knowing** about those on **the other**. **Some** of those lines are **drawn** very **early** in the project's life – even before any code is written. **Others** are drawn **later**. Those that drawn early are drawn for the purposes of deferring decisions for as long as possible, and of keeping those decisions from polluting the core BRs.

Recall that the goal of an architect is to minimize the human resources required to build and maintain the system. What it is that saps this kind of people-power? Coupling – and especially coupling to premature decisions.

What kind of decisions are premature? Decisions that have nothing to do with the business requirements – the UCs – of the system. These includes decisions about FWs, DBs, etc.

A **good** architecture:

- is one in which **decisions** like these are rendered **ancillary and deferrable**;
- **does not depend** on those decisions;
- allows those **decisions** to be **made** at the **latest possible moment**, without significant impact.

#### A COUPLE OF SAD STORIES

No content.

#### FITNESSE

To delay decision about the DB, we can just put an interface between all data accesses and the data reposity.

#### WHICH LINES DO YOU DRAW, AND WHEN DO YOU DRAW THEM?

You draw lines between things that matter and things that do not.

- the **GUI** does not matter to the **BRs**, so there **should be a line between them**;
- the **DB** does not matter to the **GUI**, so ...;
- the **DB** does not matter to the **BRs**, so ...;

Other statements:

- ~~the BRs does care about the DB~~;
- ~~the DB is inextricably connected to the BRs~~;
- ~~the DB is an embodiment of the BRs~~;
- the DB is a tool that the BRs can use indirectly;
- the BRs does not need to know about the schema, or the QL, or other details about the DB;
- **all** the BRs need **to know** is that **there is** a set of **FNs** that can be used **to fetch or save data**; this allows us to put the DB behind an **interface**.

```mermaid
graph TD
  Br[BRs]
  DbInterface(DB interface)
  DbAccess[DB access]
  Db[DB]

  subgraph BrComponent
    Br
    DbInterface
  end

  subgraph DbComponent
    DbAccess
    Db
  end

  Br==>DbInterface
  DbAccess--A boundary line-->DbInterface
  DbAccess==>Db
```

About the diagram:

- the structure in a real-world app may be more complex;
- the direction of the line is important;
- the DB knows about the BRs;
- the BRs do not know about the DB;
- the DB does not matter to the BRs;
- the DB cannot exist without the BRs.
- the _DB access_ contains code that translates the calls made by the _BrComponent_ into the QL of the DB;
- the _BrComponent_ **can use any kind** of DB;
- the _DbComponent_ **can be replaced** with another **implementation** (Oracle, MySQL, flat files) – the _BrComponent_ does not care;
- the DB **decision** can be **deferred** and you can **focus on** getting the **BRs** written and tested first.

#### WHAT ABOUT INPUT AND OUTPUT?

What the system is? People often see the GUI and think that the GUI is the system. They define the a in terms of the GUI, so they believe that they should see the GUI start working immediately. They fail to realize a critically important principle: **the IO is irrelevant**.

We often see about the behavior of the system in terms of the behavior of the IO. Your experience is dominated by the interface: the screen, the mouse, the buttons and the sounds. But there is a model behind that interface – a sophisticated set of data structures and FNs – driving it. More importantly, that model does not need the interface. It would happily execute its duties, modelling all the events in the game without the game ever being displayed on the screen. **The GUI does not matter to the model – the BRs.**

```mermaid
graph BT
  Br[BRs]
  Gui[GUI]

  subgraph BrComponent
    Br
  end

  subgraph GuiComponent
    Gui
  end

  Gui--A boundary line-->BrComponent
```

About the figure:

- the BRs and the GUI are **separated by a boundary line**;
- the less relevant component **depends on** the more relevant one;
- the arrow shows **which component knows** about the other and, therefore, **which component cares** about the other; the GUI cares about the BRs.
- the **GUI can be replaced** with any other kind of interface – and the **BRs would not care**.

#### PLUGIN ARCHITECTURE

The discussed approach is kind of pattern. This pattern allows addition of other components, it allows third-party plugins.

> The core BRs are kept separate from, and independend of, those components that are either optional or can be implemented in many different forms.

```mermaid
---
title: Plugging in to the BRs
---
graph BT
  Br[BRs]
  Gui[GUI]
  Db[DB]

  subgraph BrComponent
    Br
  end

  subgraph GuiComponent
    Gui
  end

  subgraph DbComponent
    Db
  end

  Gui--A boundary line-->BrComponent
  Db--A boundary line-->BrComponent
```

About the figure above:

- The GUI is considered to be a plugin. We have made it possible to plug in **different or multiple GUIs**: web, desktop, modile, console, etc.
- The DB is considered to be a plugin. We have made it possible to plug in **different or multiple DBs**: SQL, NoSQL, file-based DB, etc.
- We **do not know what implementations** of GUI or DB the business will **need in the future**.
- Implementations replacements might not be trivial. If the initial deployment of our system was web-based, then writing the plugin for a mobile app could be challenging. Some of the communications between the BRs and the GUI may require reworking. Ideally, we should **write** these **communications** in a GUI-**agnostic** way.

#### THE PLUGIN ARGUMENT

It is **good** to have **deeply asymmetric relationship between the components**. We want certain modules to **immune** to others. We do not want the BRs to break when the GUI or the DB schema changes (fragility).

Plugin architecture creates **firewalls** across which **changes cannot propagate**. If the GUI plugs in to the BRs, then changes to the GUI cannot affect those BRs.

Boundaries are drawn there where is an axis of change. The components on **one side** of the boundary change at **different rates, and for different reasons, than** the ones on **the other side**.

This is simply the **SRP** again. It tells us where to draw our boundaries.

#### CONCLUSION

First, **partition the system into components**. Then, **draw boundaries**. **Some** of those components **are core BRs, others are plugins**. We arrange the code so that the dependencies are directed from the plugins from the core BRs.

Recognize it as an applications of the **DIP** and the **SAP**. Dependency arrows are arranged to point **from lower-level details to higher-level abstractions**.

### CHAPTER 18. BOUNDARY ANATOMY

Boundaries, separating components come in different forms.

#### BOUNDARY CROSSING

At runtime, boundary crossing is just a FN calling a FN on the other side and passing along some data.
The trick to creating an appropriate boundary is to manage the source code deps.

#### THE DREADED MONOLITH

Monolith:

- it is simply a **disciplined segregation** of FNs and data **within a single processor and a single address space**;
- the **most common** architecture;
- uses the **source-level decoupling mode**;
- has no strict physical representation;
- from a deployment point of view it is most commonly a single executable file, like `.jar` or `.exe`;
- almost always depend on some kind of dynamic polymorphism to manage their internal deps;
- **the simplest boundary crossing is** a FN call from a low-level client to higher-level service;
- **when a high-level client needs to call a lower-level service**, dynamic polymorphism is used to invert the dependency against the flow of control; the runtime dep opposes the compile-time dep;
- high-level components **remain independent** of lower-level details;
- **communitactions** between components are very **fast and cheap**; they are typically **just FNs calls**;

#### DEPLOYMENT COMPONENTS

DC are almost the same as monoliths. The FNs generally all exist **in the same processor and address space**. The strategies for segregating the components and managing their deps are the same.

As with monoliths, **communications across DC boundaries** are just FN calls and, therefore, **are cheap**.

#### THREADS

Both monoliths and deployment component can use threads. Threads **are not architectural boundaries** or units of deployment, but rather **a way to organize the schedule and order of execution**.

#### LOCAL PROCESSES

- is a much **stronger physical architectural boundary**;
- typically created from the command line or an equivalent system call;
- run in the **same processor**, **or** in the **same set of processes** within a multicore, **but** run in **separate address spaces**;
- **communicate with each other** using OS communications like sockets, mailboxes or message queues;
- each LP may be a statically linked monolith, or a set of dynamically linked deployment components;
- think of an LP as a kind of **uber-component**: the LP consists of lower-level components that manage their dependencies through dynamic polymorphism;
- the segregation strategy between LPs is the same as for monoliths and binary components; source code **deps point** in the same direction across the boundary, and always toward the higher-level component;
- the higher-level LP source code must not contain the names or physical addresses of lower-level LPs; the **architectural goal** is for lower-level LPs to be plugins to higher-level processes;

#### SERVICES

- the **strongest boundary**;
- typically created from the command line or an equivalent system call;
- do **not depend on their physical location**;
- two communicating services may, or may not operate in the same physical processor or multicore;
- **communicate over the network**;
- communications across service boundaries are very slow compared to FN calls; latency is acceptable;
- lower-level services should "**plug in**" to higher-level services;
- **higher-level** services should **contain no** specific physical **knowledge** (URI, etc) **about** any **lower-level** service;

#### CONCLUSION

Most systems, other than monoliths, use **more than one boundary strategy**. A system using service boundaries may also have some local process boundaries. Indeed, as service is just a facade for a set of interacting local processes. A service or a local process will almost certainly be either a monolith composed of source code components or a set of dynamically linked deployment compoents.

This means that the boundaries in a system will often be **a mixture** of local chatty boundaries and boundaries that work with latency.

#### CHAPTER 19. POLICY AND LEVEL

A program is a detailed description of the policy by which inputs are transformed into outputs.

The policy is broken into many smaller statements of policy (SoP).

Each of the SoPs can:

- describe particular BRs;
- define certain reports formatting;
- validations some input;
- etc.

We should separate these SoPs from one another, and regroup them based on the ways they change. SoPs that change at the same time, for the same reasons, and at the same level, belong to the same component.

The art of architecture often involves forming the regrouped components into a **directed acyclic graph**. The nodes of the graph are the components that contain policies at the same level. The directed edges are the deps between these components.

#### LEVEL

> Level is the distance from inputs and outputs.

**The father a policy** from both the inputs and outputs of the system, **the higher its level**. The policies that manage input and output are the lowest-level policies in the system.

```mermaid
---
title: A simple encryption program
---
graph TD
  readChar
  table
  translate
  writeChar

  readChar==Char==>translate==Char==>writeChar
  table==>translate

  readChar--A SC dep-->translate
  writeChar--A SC dep-->translate
```

_Translate_ is the highest-level component because it is farthest from the inputs and outputs.

Note that data flow and the SC deps do not always point in the same direction. It is a part of architecture. We want SC deps to be decoupled from data flow and coupled to levels.

##### An incorrect architecture

```javascript
function encrypt() {
  while (true) {
    writeChar(translate(readChar()))
  }
}
```

The higher-level `encrypt` FN depends on lower-level `readChar` and `writeChar` FNs.

##### A better architecture

```mermaid
---
title: Сlass diagram showing a better architecture
---
graph TD
  CharReaderInterface[CharReader interface]
  CharWriterInterface[CharWriter interface]
  ConsoleReader
  ConsoleWriter
  Encrypt

  subgraph Encryption
    CharReaderInterface
    CharWriterInterface
    Encrypt
  end

  Encrypt-->CharReaderInterface
  Encrypt-->CharWriterInterface
  ConsoleReader-->CharReaderInterface
  ConsoleWriter-->CharWriterInterface
```

Notes about the diagram:

- all the deps of the _Encryption_ element point **inward**;
- _Encryption_ is the **highest**-level element;
- _ConsoleReader_ and _ConsoleWriter_ are **low** level because they close to the inputs and outputs;
- this structure **decouples** the high-level encryption policy from the lower-level IO policies; this makes the encryption policy usable in a wide range of contexts; changes to the IO policies do not affect the encryption policy.

Policies are grouped into components based on the way they change (SRP and CCP in action).

|                          | Higher-level policies | Lower-level policies |
| ------------------------ | --------------------- | -------------------- |
| Changes frequence        | Low                   | High                 |
| Changes urgency          | Low                   | High                 |
| Changes importance level | High                  | Low                  |

Keeping policies separate, with all SC deps pointing in the direction of the higher-level policies, reduces the impact of change.

Lower-level components should be **plugins** to higher-level ones.

#### CONCLUSION

No content.

### CHAPTER 20. BUSINESS RULES

There are several different kinds of BRs. BRs are rules or procedures that make or save business money.

Some BRs we call **_critical business rules_** (CBRs), because they are critical to the business and would **exist anyway**, even if the system were not automated.

CBRs typically require some data to work with. E. g. to implement banking interest calculation, we need: a loan balance, an interest rate, a payment schedule.  
We call this data **_critical business data_** (CBD) – data that would **exist anyway**, even if the system were not automated.

The **CBRs and CBD** are inextricably **bound**, so they are a good candidate for an object. We will call this kind of object an **_entity_**.

#### ENTITIES

An entity:

- is an object that **embodies a small set of CBRs operating on CBD**;
- **either contains CBD or has easy access to it**;
- has **interface** of the entity consists of the **FNs that implement the CBRs that operate on the CBD**.

```mermaid
---
title: Loan entity as a module in UML
---
classDiagram
  class Loan
  Loan: - principle
  Loan: - rate
  Loan: - period
  Loan: + makePayment()
  Loan: + applyInterest()
  Loan: + chargeLateFee()
```

The `Loan` module:

- gathers together the SW that is critical to the business;
- **separated from other concerns** of the system;
- stands alone as a **representative of the business**;
- is **unsullied with concerns about DBs, UIs and third-party FWs**; it could serve the business in any system, irrespective of how that system was presented, or how the data was stored, or how the data is arranged; the **entity is pure business** and nothing else.

#### USE CASES

There are BRs called **_use cases_** those.

About UCs:

- UCs are **not as pure** as entities.
- UCs make or save money for the business by defining the way that an automated system operates.
- UCs **describe app-specific BRs** as opposed to the CBRs within the entities.
- UCs would not be used in a manual environment, because they **make sense only as part of an automated system**.
- UCs contain BRs that specify **how and when the CBRs within the entities are invoked**. UCs control the dance of the entities.
- UCs **do not describe how the system appears to the user**. UCs do not describe the UI other than to informally specify the data coming in from that UI, and the data going back through that UI. From a UC it is impossible to tell whether the app is delivered on the web, or on a thick client, or on a console, or is a pure service.
- Describe the app-specific BRs that govern the interaction between the users and the entities. **How the data gets in and out of the system is irrelevant to the UCs.**
- A UC is an **object**. Each UC **has FNs implementing app-specific BRs**. It also **has data elements** that include **input data, output data, and references to the appropriate entities** with which it interacts;
- Entities have no knowledge of the UCs that control them – DIP in action. **High-level entities know nothing about low-level UCs. Instead, UCs know about entities.**

Examples of UCs:

- UC A specifies the input to be provided by the user;
- UC B specifies the output to be returned to the user;
- UC C specifies the processing steps involved to produce the output;

**Why are entities high level and UCs lower level?** Because **UCs are specific to a single app** and, therefore, are closer to the inputs and outputs of that system. **Entities are generalizations that can be used in different apps**, so they are farther from the inputs and outputs of the system. **UCs depend on entities. Entities do not depend on UCs.**

#### REQUEST AND RESPONSE MODELS

**UCs expect input data, and they produce output data.** However, a well-formed UC object should have **no inkling about the way that data is communicated** to the user, or to any other component.

A UC module **accepts simple request DSs** for its input, and **returns simple response DSs** as its output. These DSs are **not dependent on anything**. They do not derive from standard FW interfaces such as `HttpRequest` and `HttpResponse`. UCs know nothing of the web or UI. This lack of dependencies is critical.

#### CONCLUSION

BRs should remain **pristine**, unsullied by concerns like UI or DB. BRs should be **the most independent and reusable code** in the system.

### CHAPTER 21. SCREAMING ARCHITECTURE

When you see the blueprints of a building, its architecture screams "House" / "Library" / "Hospital".

So what does the architecture of your app scream? When you look at the top level directory structure and SC files do they scream "Health care system", or "Accounting system", or "Inventory management system"? Or do they scream "Rails", or "Django", or "ASP"?

#### THE THEME OF AN ARCHITECTURE

An app architecture should **scream about the UCs** of the app.

Architectures are **not about FWs**. They should not be supplied by FWs. FWs are tools to be used, not architectures to be conformed to. **If your architecture is based on FWs, then it cannot be based on your UCs.**

#### THE PURPOSE OF AN ARCHITECTURE

Good architectures are centered on UCs so that architects can safely describe the structures that support those UCs with **no commiting to FWs, tools, and other environments issues**. The first concern of an architect is to make sure that the building is usable – not to ensure that the house is made of bricks. Yes, using bricks do matter, but they should not be in the center of the architecture.

A good architecture allows decisions about FWs, etc to be deferred, revisited and changed. FWs are options to be left open. A good architecture **emphasizes the UCs and decouples them from peripheral concerns**.

#### BUT WHAT ABOUT THE WEB?

Is the web an architecture? Does the fact that your app is delivered on the web dictate the architecture of your system? Not. The web is a delivery mechanism – an IO device. Your system architecture should be ignorant about how it will be delivered: a web app, or a console app, or a thick client app, etc.

#### FRAMEWORKS ARE TOOLS, NOT WAYS OF LIFE

FWs can be very powerful and useful. Their authors show you the way to use the FW. Often they assume an all-encompassing, let-the-FW-do-everything position. This is not the position you want to take.

**Look at each FW with a jaded eye. View it skeptically.** Yes, it might help, but for what cost?

Ask yourself:

- **How** you should **use** it?
- **How** you should **protect yourself** from it?
- **How** you can **preserve the UC-emphasis** of your architecture?
- What strategy you should develop to **prevent the FW from taking over your architecture**?

#### TESTABLE ARCHITECTURES

If your architecture is all about UCs, and if you keep your FWs at arm's length, then you are able to **unit-test** all those **UCs without any FWs in place**:

For your unit tests, your do not need the web server running or the DB connected. Your entity object should be plain old objects that have no deps on FWs, or DBs or other complications. Your UC objects should coordinate your entity objects.

#### CONCLUSION

Your architecture should **tell readers about the system, not about the FWs used** in the system.

When new programmers look at an repo, their **first impression** should be "Oh this is a health care system.". Those new programmers should **be able to learn all the UCs** of the system, yet still no know how the system is delivered.  
They may say: "We see some things like models – but where are the views and controllers?".
And you should respond: "Those are details that need not concern us at the moment. We will decide about them later.".

### CHAPTER 22. THE CLEAN ARCHITECTURE

**Different ideas** about architecture (hexagonal architecture, DCI, BCE, etc) vary in their details, but they are **very similar**:

- they have the same objective which is the **separation of concerns**;
- they achieve this separation by **dividing the SW into layers**;
- each has at least one **layer for BRs**, and another layer **for system and user interfaces**.

Each of these architectures produces systems that have the following **characteristics**:

- **Independent of FWs.** This allows you to use such FWs as tools, rather than forcing your cram your system into their limited constrains.
- **Testable.** The BRs can be tested without the UI, DB, web server, etc.
- **Independent of the UI.** The UI can change easily without changing the rest of the system and BRs. Web UI -> console UI? Easy.
- **Independent of the DB.** You can swap out Postgres for Mongo, file-based DB, or something else. Your BRs are not bound to the DB.
- **Independent of any external agency.** Your BRs do not know anything about the interfaces to the outside world.

![The clean architecture](./images/the-clean-architecture.png)

#### THE DEPENDENCY RULE

The circles in the figure above represent different areas of SW. The further in you go, the higher level the SW becomes. The outer circles are mechanisms, the inner – policies.

The overriding rule that makes this architecture work is the **dependency rule**:

> SC deps must point only inward, toward higher-level policies.

**Nothing in an inner circle can know anything about and an outer circle.** In particular, the name of anything declared in an outer circler must not be mentioned by the SC in an inner circle. This includes FNs, classes, variables, or any other named entities. **Outer circles do not impact inner circles.**

##### ENTITIES

**Entities encapsulate enterprise-wide CBRs.** An entity can be an object with methods, or it can be a set of DSs with FNs. It does not matter so long as the entities can be used by many different apps in the enterprise.

If you do not have an enterprise and are wring just a single app, the these entities are business objects of the app. The encapsulate the **most general and high-level rules.** They are the least likely to change when something external changes (e. g., page navigation or security). **No operational change should affect the entity layer.**

##### USE CASES

UCs layer **implements all the app-specific BRs** of the system. These UCs **orchestrate data flow to and from the entities**.

About interconnections of the UCs layer:

- changes in UCs layer **do not affect entities**;
- UCs layer **is not affected by changes made in UI, DB, FWs**; the UCs layer is isolated from such concerns;
- **changes to the operation might affect** the UCs layer;
- if some UC details change, the UCs layer SC will certainly be changed.

##### INTERFACE ADAPTERS

The interface adapters layer **converts data from the UCs-and-entities-convenient format, to the external-agencies-convenient format**, e. g. for a DB or a client.  
It might wholly contain the MVC architecture of the GUI. Presenters, views, and controllers all belong to the interface adapters layer. The models are likely just DSs that are passed from the controllers to the UCs, and then back from the UCs to the presenters and views.

No code inward should know anything about where the data is stored (DB, files, etc), what is the IO device (web, console, etc).

This layer **also converts data from the external-agencies-convenient format, to the UCs-and-entities-convenient format**.

##### FRAMEWORKS AND DRIVERS

The outermost layer of the model is generally composed of FWs and tools such as the DB. It includes little glue code to communicate to the next level inward.

This layer is where all the details go: the web, the DB. We keep these things at the outermost position where they can do little harm.

#### ONLY FOUR CIRCLES?

The circles on the figure are intended to be schematic: there is no rule to have just 4 one, **you can add more layers**.

However, the dependency rule always applies. **SC deps always point inward. As you move inward, the level of abstraction and policy increases, the code becomes higher-level and more abstract.** The outermost level consists of lower-level concrete details.

##### CROSSING BOUNDARIES

At the lower right of the diagram is an example of **how we cross the circle boundaries**. It shows the controllers and presenters communicating with the UCs in the next layer. Note the flow of control: it begins in the controller, moves through the UC, and finishes in the presenter. Note also the SC deps: each points inwards toward the UCs. **DIP** resolves this apparent contradiction.

##### WHICH DATA CROSSES THE BOUNDARIES

Typically, this data are simple DSs. This data can simply be arguments in FNs calls.

It is important that **simple DSs should be passed through boundaries**. Do not cheat: **do not pass entity object or DB rows – we do not want the DSs to have any kind of dep** that violates the dependency rule.

For example, many DB FWs return a convenient data format in response to a query. We might call it a "row structure". Passing it "as is" would violate the dependency rule because it would force an inner circle to know something about an outer circle.

> Thus, when we pass data across a boundary, it is always in the form that is most convenient for the inner circle.

#### A TYPICAL SCENARIO

No content.

#### CONCLUSION

Conforming to these simple rules is not difficult, and it will save you a lot of headaches going forward.
When any of the external parts of the system becomes obsolete (the DB, the web FW, etc), you **can replace those obsolete elements with a minimum of fuss**.

### CHAPTER 23. PRESENTERS AND HUMBLE OBJECTS

No content.

#### THE HUMBLE OBJECT PATTERN

The _Humble Object_ pattern is a pattern that **separates behaviors that is hard to test from behaviors that is easy to test**.

The ideas is simple: **split the behavior into two modules**.

- **One** module **is humble**. It contains all the **hard-to-test behaviors** stripped down to their barest essense.
- **The other** module contains all the **testable behaviors** that were stripped out of the humble object.

For example, GUIs are hard to unit test because it is very difficult to write tests that can see the screen and check that the appropriate elements are displayed there. However, most of the behavior of the GUI is, in fact, easy to test. Using the Humble object pattern, we can separate these two kinds of behaviors into two different modules called the Presenter and the View.

#### PRESENTERS AND VIEWS

**The View is a humble object that is hard to test.** The code in this object is as **simple** as possible. It moves data into the GUI but **does not process that data**.

**The Presenter is the testable object.** Its job is to **accept the data** from the app **and format it for presentation** so that the View can simply add it to the screen.

Examples:

- If the app wants a date displayed in a field, it will hand the Presenter a `Date` object. The Presenter will then format that data into an appropriate string and place it in a simple DS called the View Model, where the View can find it.
- If the app wants to display money on the screen, it might pass a `Currency` object to the Presenter. The Presenter will format that object with the appropriate decimal places and currency markers, creating a string, that it can place in the View Model. If that currency value should be turned red if it is negative, then a simple boolean flag in the View model will be set appropriately.
- Every button in the screen will have a name. That name will be a string in the View Model, placed there by the Presenter. If those buttons should be grayed out, the Presenter will set an appropriate boolean flag in the View model. Every menu item name is a string in the View model, loaded by the Presenter. The names for every radio button, checkbox, and text field are loaded, by the Presenter, into tables of properly formatted strings in the View model.

Everything that appears on the screen, and that the app has some kind of control over, is represented in the View Model as a string, or a boolean, or an enum. The View only loads the data from the View Model into the screen. Thus View is humble.

#### TESTING AND ARCHITECTURE

Testability is an attribute of a good architecture. The Humble Object pattern is a good example, because the separation of the behaviors into testable and non-testable parts often defines an architectural boundary. The Presenter / View boundary is one of those boundaries, but there are many others.

#### DATABASE GATEWAYS

Between the UC interactors and the DB are the DB gateways. These gateways are polymorphic interfaces that contain methods for every create, read, update, or delete operation performed by the app on the DB.

Example:  
If the app needs to know the last names of all the users who logged in yesterday, then the `UserGateway` interface will have a method named `getLastNameOfUsersWhoLoggedInAfter` that takes a `Date` as its argument and returns a list of last names.

We do not allow SQL in the UCs layer; instead, we use gateway interfaces that have appropriate methods. Those gateways are implemented by modules in the DB layer. That implementation is the humble object. It simply uses SQL, or whatever the interface to the DB is, to access the data required by each of the methods. The interactors, in contrast, are not humble because they encapsulate app-specific BRs. Although they are not humble, those interactors are testable, because the gateways can be replaced with appropriate stubs and test doubles.

#### DATA MAPPERS

There is no such thing as an ORM because objects are not DSs, at least from the users' point of view. The users of an object cannot see the data, since it is all private. Those users only the public methods of that object. So, from the user's point of view, an object is simply a set of operations.

A DS, in contrast, is a set of public data variables that have no implied behavior. ORMs would be better named "data mappers", because they load data into DSs from DBs.

ORMs reside in the DB layer. ORMs form another kind of Humble Object boundary between the gateway interfaces and the DB.

#### SERVICE LISTENERS

If an app consumes or provides services, the Humble Object pattern creates a service boundary.

The app loads data into simple DSs and then passes them across the boundary to modules that properly format the data and send it to external services. On the input side, the input services will receive data from the service interface and format it into a simple DS that can be used by the app. That DS is then passed across the service boundary.

#### CONCLUSION

At each architectural boundary, we are likely to find the Humble Object pattern lurking somewhere nearby. The communication across this boundary will almost always involve some kind of simple DS, and the boundary will frequently divide hard- and easy-to-test parts. The use of this pattern at architectural boundaries vastly increases the testability of the entire system.

### CHAPTER 24. PARTIAL BOUNDARIES

Full-fledged architectural boundaries are expensive. They require:

- reciprocal polymorphic `Boundary` interfaces;
- having `Input` and `Output` DSs;
- dependency management necessary to isolate the two sides;
- maintenance.

Creating and maintaining such a full-fledged boundary you are might even _not gonna need it_ is expensive. In that case, you may implement a partial boundary.

#### SKIP THE LAST STEP

One way to construct a partial boundary is to do all the work necessary to create independently compilable and deployable components, and then simply keep them together in the same component.

Partial boundary requires the same amount of code and preparatory design as a full boundary. However, it does not require the administration of multiple components.
No version number tracking, no release management burden.

#### ONE-DIRECTIONAL BOUNDARIES

The full-fledged architectural boundary uses reciprocal boundary interfaces to maintain isolation in both directions, which is expensive.

The figure below demonstrates demonstrates how to hold the place for later extension for a full-fledged boundary. It exemplifies the traditional Strategy pattern. A `ServiceBoundary` interface is used by clients and implemented by `ServiceImpl` classes.

![The strategy pattern](./images/the-strategy-pattern.png)

This sets the stage for a future architectural boundary. The necessary dependency inversion is in place in in attempt to isolate the `Client` from the `ServiceImpl`. The separation can degrade pretty rapidly, as shown by the nested dotted arrow in the diagram. Without reciprocal interfaces, nothing prevents this kind of backchannel other than the discipline of the devs.

#### FACEDES

An even simpler boundary is the Facade pattern. Even the dependency inversion is sacrificed. The boundary is defined by the `Facade` class, which lists all the services as methods, and deploys the service calls to classes that the client is not supposed to access.

```mermaid
graph LR
  Client-->Facade
  Facade-->ServiceA
  Facade-->ServiceB
  Facade-->ServiceC
```

#### CONCLUSION

We have seen three simple ways to partially implement an architectural boundary. Each of them has its pros and cons.

It is an architect who should decide where an architectural boundary might one day exist, and whether to fully or partially implement that boundary.

### CHAPTER 25. LAYERS AND BOUNDARIES

It is easy to think of systems as being composed of three components: UI, BRs, and DB. For most systems, there are more components.

#### HUNT THE WUMPUS

No content.

#### CLEAN ARCHITECTURE?

We can easily apply the clean architecture approach, with UCs, boundaries, entities, and corresponding DSs. But have we really found all the significant architectural boundaries?

For example, language is not the only axis of change for UI. We also might want to vary the mechanism by which we communicate the text (console, SMS, a chat app, etc).

That means that there is **a potential architectural boundary defined by this axis of change**. We should construct an API that crosses that boundary and isolates the language from the communications mechanism.

![Architectural boundaries axes](./images/architectural-boundaries-axes.png)

The dashed outlines indicate abstract components that defined an API that is implemented by the components above or below them. For example, the _Text delivery_ API is implemented in _SMS_ and _Console_.

**The API is defined and owned by the user, rather by the implementer:**

- `GameRules` communicates with `Language` through an API that `GameRules` defines and `Language` implements;
- `Language` communicates with `TextDelivery` using an API that `Language` defines but `TextDelivery` implements;

If we look inside `GamesRules`, we would find:

- polymorphic `Boundary` interfaces used by `GameRules` and implemented by `Language`;
- polymorphic `Boundary` interfaces used by `Language` and implemented by code inside `GameRules`;

If we look inside `Language`, we would find the same:

- polymorphic `Boundary` interfaces implemented by `TextDelivery`;
- polymorphic `Boundary` interfaces used by `TextDelivery` and implemented by `Language`;

In each case, the **API** defined by those `Boundary` interfaces **is owned by the upstream component**.

**The variations**, such as `English`, `SMS`, and `CloudData` **are provided by polymorphic interfaces** in the abstract API component, **and implemented by the concrete components** that serve them. For example, we would expect polymorphic interfaces defined in `Language` to be implemented by `English` and `Spanish`.

We can simplify the diagram by eliminating all the variations and focusing on just the API components.

![Architectural boundaries axes simplified](./images/architectural-boundaries-axes-simplified.png)

Note that all the arrows point up. `GameRules` contains the highest-level policies, so it is placed at the top.

Consider the **direction of information flow**:

- all **input comes from the user** through the `TextDelivery` component at the **bottom left**;
- that info **raises** through the `Language` component, **getting translated** into commands to the `GameRules`;
- `GameRules` processes the user input and sends appropriate data **down to `DataStorage` at the lower right**;
- `GameRules` then sends output back down to `Language`, which translates the API back to the appropriate language;
- then the info is delivered to the user through `TextDelivery`.

The flow of data is divided into **two streams**:

- the left one is concerned with communicating with the user;
- the right one is concerned with data persistence.

Both streams meet at the top at `GameRules`, which is the ultimate processor of the data that goes through both streams.

#### CROSSING THE STREAMS

As systems become more complex, the component structure may split into many such streams.

![Architectural boundaries axes with more streams](./images/architectural-boundaries-axes-with-more-streams.png)

#### SPLITTING THE STREAMS

Not all the streams eventually meet at the top in a single component, the structure might be more complex.

![The higher level policy manages the player](./images/the-higher-level-policy-manages-the-player.png)

#### CONCLUSION

We must be careful to **recognize when architectural boundaries are needed**.

As architects, we have to:

- carefully **recognize when** architectural boundaries **are needed**;
- be aware that architectural boundaries, when **fully implemented**, are **expensive**;
- recognize that **when** architectural boundaries are **ignored**, they are very expensive to add in later – even in the presense of tests and refactoring discipline.

**On the one hand**, remember of **YAGNI**. Over-engineering is often much worse than under-engnineering.  
**On the other hand**, when you discover that you truly need an architectural boundary when none exists, the **costs and risks** can be very **high to add such a boundary**.

You must see the future. You must guess – intelligently. You must weight the costs and **determine where the architectural boundaries lie**:

- **which** should be **fully implemented**;
- **which** should be **partially implemented**;
- **which** should be **ignored**.

This is **not a one-time decision**. Rather, you watch. You pay the attention as the system evolves. You note where boundaries **may become required**.

At that point, you weight the **cost** of **implementing** these architectural boundaries **VS ignoring** them – and you **review your decision frequently**.

> Your goal is to implement the boundaries right at the inflection point where the cost of implementing becomes less than the cost of ignoring.

### CHAPTER 26. THE MAIN COMPONENT

In every system there is at least one component that creates, coordinates, and oversees the others. Let's call this component `Main`.

#### THE ULTIMATE DETAIL

About the `Main` component:

- it is the initial entry point of the system;
- nothing, than the OS, depends on `Main`;
- it is the ultimate detail – the lowest-level policy;
- its job is to create
- it is in this `Main` component that deps should be injected by a Dependency Injection FW; once they are injected into `Main`, `Main` should distribute those deps normally, without using the FW;
- `Main` is **a dirty low-level module in the outermost circle of the clean architecture**; it loads everything up for the high-level system, and then hands control over to it;
- think of `Main` as **the dirtiest** of all the dirty components;
- think of `Main` as **a plugin to the app** – a plugin that sets up the initial conditions and configurations, gathers all the outside resources, and then hands control over to the high-level policy of the app;
- since it is a plugin, it is **possible to have many** `Main` components, one for each config (for dev, for test, for prod, for USA to deploy to, for Germany to deploy to, for CompanyA customer, for CompanyB customer, etc.);
- when you think about `Main` as a plugin component, sitting behind an architectural boundary, the problem with configuration becomes a lot easier to solve.

### CHAPTER 27. SERVICES: GREAT AND SMALL

Service-oriented "architectures" and micro-service "architectures" have become very **popular** of late. Some of the **reasons** (they are only **parially true**):

- services seem to be strongly **decoupled** from each other;
- services appear to support **independence of development and deployment**.

#### SERVICE ARCHITECTURE?

Is using services, by their nature, an architecture? No.  
The architecture of a system is defined by boundaries that separate high-level policies from low-level detail and follow the Dependency Rule. Splitting the app into services is like splitting into functions, and this is not necessarily architecturally significant.

Services are, after all, are function calls across process and / or platform boundaries.

#### SERVICE BENEFITS?

This section is going to challenge the current popular orthodoxy of service architecture.

##### THE DECOUPLING FALLACY

Some **popular statements** about services **decoupling**:

- services are decoupled because each one runs in a different process, or event a different processor;
- services do not share variables;
- the interface of each service must be well-defined.

These benefits are **illusions**.

Yes, services are decoupled at the level of individual variables. However, they can still be coupled by shared resources within a processor, or on the network.

As for interfaces being well-defined, that is certainly true – but it is no less true for functions.

##### THE FALLACY OF INDEPENDENT DEVELOPMENT AND DEPLOYMENT

There is some true in this belief – but only some:

- first, history has shown that large enterprise systems can be built from monoliths and component-based systems as well as service-based systems;
- second, services cannot always be independently developed, deployed, and operated. As long as they are coupled by data and behavior.

#### THE KITTY PROBLEM

No matter how strongly your services are "decoupled". New significant features might touch each of your "independent" services.

#### OBJECTS TO THE RESQUE

In a component-based architecture, with a guidance of SOLID, we would have created a set of classes that could be polymoprhically extended to handle new features.

The boundaries would be in place, the dependencies would follow the Dependency Rule.

#### COMPONENT-BASED SERVICES

Services do not need to be little monoliths. Services can, instead, be designed using SOLID, and adding new components within a service can be done without changing the existing components within this service.

#### CROSS-CUTTING CONCERNS

Services must be designed with internal component architectures that follow the Dependency Rule.

#### CONCLUSION

Services, in their nature, are not architecturally significant elements.

The architecture of a system is:

- **defined by boundaries** drawn within that system, **and** by the **deps** that cross those boundaries;
- **not defined by physical mechanisms** by which elements communicate and execute.

### CHAPTER 28. THE TEST BOUNDARY

Yes, the tests are part of the system, and they participate in the architecture just like every other part of the system does.

#### TESTS AS SYSTEM COMPONENTS

About tests **from architecture point of view**:

- **all kinds** of tests are architecturally **equivalent**;
- tests, by their nature, follow the **Dependency Rule**;
- tests are very detailed and **concrete**;
- tests always **depend inward** toward the code being tested;
- **nothing** within the system **depends on the tests**;
- tests are **independently deployable**; they are deployed in test system rather in prod ones;
- tests are **the most isolated** system component; they are not necessary for system operation; no user depends on them; their role to support development, not operation; they are no less a system component than any other; in many ways they represent the model that all other system components should follow.

#### DESIGN FOR TESTABILITY

Tests that are not well-integrated into design of the system into the design of the system are fragile. They make the system rigid and difficult to change.

The issue is coupling. Tests that are strongly coupled to the system must change along with the system. Even a trivial change to a system component can cause many coupled tests to break or require changes. This is known as the Fragile Test Problem.

Fragile tests make the system rigid. When devs realize that simple changes to the system can cause massive test failures, they may resist making those changes.

The first rule of software design – whether for testability or for any other reason – is always the same: **do not depend on volatile things**. GUIs are volatile. Test suites that operate the system through the GUI must be fragile. Therefore design the system, and the tests, so that business rules can be tested without using the GUI.

#### THE TESTING API

The way to accomplish this goal is to create a specific API that tests can use to verify all the BRs. This API should have superpowers that allow the tests to avoid security constrains, bypass expensive resouces (such as DBs), and force the system into particular testable states. This API will be a superset of the suite of interactors and interface adapters that are used by the user interface.

The **purpose** of the testing API is to **decouple the tests from the app**. It is more than just detaching the tests from the UI: the goal is to decouple the structure of the tests from the structure of the app.

##### STRUCTURAL COUPLING

Structural coupling is a strong and harmful form of coupling. Imagine a test suite that has a test class for every prod class, and a set of tests methods for every prod method. Such a test suite is strongly coupled to the structure of the app.

When one of those prod methods or classes changes, a large number of tests must change as well. Consequently, the tests are fragile, and they make the prod code rigid.

**The role** of the testing API is **to hide the structure of the app from the tests**:

- evolving and refactoring of the prod code do not affect the tests;
- evolving and refactoring of the tests do not affect the prod code.

##### SECURITY

No content.

#### CONCLUSION

No content.

### CHAPTER 29. CLEAN EMBEDDED ARCHITECTURE

No content.

## PART VI. DETAILS

### CHAPTER 30. THE DATABASE IS A DETAIL

From an architectural point of view, the DB is a non-entity – it is a detail somewhere below the architectural level.

I am not taking about the data model. The structure you give to the data is highly significant to the architecture of your system. But the DB is not the data model. The DB is a utility that provides access to the data. Do not allow low-level mechanisms to pollute the system architecture.

#### RELATIONAL DATABASES

There is nothing architecturally significant in arranging data into rows withing tables. The UCs of your app should neither know nor care about such matters. Knowledge of the tabular structure of the data should be restricted to the lowest-level utility functions in the outer circles of the architecture.

Many data access FWs allow DB rows and tables to be passed around the system as objects. Allowing this is an architectural error. It couples the UCs, BRs, and even the GUI to the relational structure of the data.

#### WHY ARE DATABASE SYSTEMS SO PREVALENT?

No content.

#### DETAILS

DB is just a mechanism to move the data back and forth between the surface of the disk and RAM. It is just a bucket of bits where we store our data on a long-term basis.

Architecture should not know about the form of the data stored in the disk. It should not also know that the disk exists at all.

#### BUT WHAT ABOUT PERFORMANCE?

Yes, performance is one of the concerns of the architecture. Writing and reading data should be performed quickly, but that is a low-level concern which should be addressed with low-level data access mechanisms.

#### ANECDOTE

No content.

#### CONCLUSION

> The data is significant. The DB is a detail.

### CHAPTER 31. THE WEB IS A DETAIL

No content.

#### THE ENDLESS PENDULUM

The web is **just the latest** in a series of oscillations that our industry has gone through since 1960s.

The web changes its forms over the time. ClassicClientServer -> LightServerAndFatClient -> FatServerAndLightClient -> ???

At the moment the web and its current form are prominent. As architects, though, we have to look at the long term.

You should decouple your BRs from your GUI. You do not know whether your app will take shape of the web, desktop app or mobile app.

#### THE UPSHOT

The upshot is simply this: the GUI is a detail. The web is a GUI, an IO device. So the web is detail. As an architect, you want to put details like that behind boundaries that keep them separate from your core BRs.

#### CONCLUSION

This kind of abstraction is not easy, and it will likely take several iterations to get right. But it is possible.

### CHAPTER 32: FRAMEWORKS ARE DETAILS

FWs are generally good things. However, FWs are not architectures – though some try to be.

#### FRAMEWORK AUTHORS

Most authors offer their work for free bacause they want to be helpful to the community. However, those authors do not have your best interests in heart. They cannot because they do no know you and your problems.

The FW author know their own problems, and the problems of their coworkers and friends. And they write their FWs to solve those problems – not yours. Of course, your problems will likely overlap with those other problems quite a bit, otherwise FWs would not be so popular.

#### ASYMMETRIC MARRIAGE

You make a huge commitment to your FW, but the FW author makes no commitment to you.

You read through the docs that the author provides. You wrapping your architecture around that FW. The author recommends that you derive from the FW's base classes and import the FW's facilities into your business objects. The author urges you to couple your app to the FWs as tightly as possible.

For the FW author, coupling to their FW is not a risk, because the author has absolute control over that FW.

What is more, the author wants you to couple to the FW, because once coupled in this way, it is hard to break away.

You take on all the risks and burden; the FW author takes on nothing at all.

#### THE RISKS

- The architecture of the FW is often not very clean. FWs tend to **violate the Dependency Rule**. They ask you to inherit their code into your business objects - your Entities! They want their FW coupled into that innermost circle. Once in, that FW is not coming bad out.
- The FW may help you with some early features of your app. However, as your project matures, it may outgrow the facilities of the FW. You will find the **FW fighting you more and more as time passes**.
- The FW may **evolve in a direction that you do not find helpful**. You may be stuck upgrading to new versions that do not help you. You may even find old features, which you made use of, dissapearing or changing in ways that are difficult for you to keep up with.
- **A new and better FW** may come along that you wish you could **switch to**.

#### THE SOLUTION

> Do not marry the framework.

You can use the FW – just do not couple to it. Keep it at arm's length. Treat the FW as a detail that belongs in one of the outer circles of the architecture. **Do not let it into the inner circles.**

**If the FW wants you to derive your business objects (Entities) from its base classes, say no. Derive proxies instead, and keep those proxies in components that are plugins to your BRs.**

**Do not let FWs into your core code. Instead, integrate them into components that plug in into your core code, following the Dependency Rule.**

For example, maybe you like Spring. Spring is a good dependency injection FW. Maybe you use Spring to auto-wire your deps. That is fine, but you should not sprinkle `@autowired` annotations all through you business objects (Entities). Your business objects should not know about Spring.  
Instead, you can use Spring to inject deps into your `Main` component. It is ok for `Main` to know about Spring since `Main` is the dirtiest, lowest-level component in the architecture.

#### I NOW PRONOUNCE YOU ...

It is ok to marry \<your-language\>-standard-library or things like this.

#### CONCLUSION

When faced with a FW, try not to marry it right away. See if there are not ways to date it for a while before you take a plunge. Keep the framework behind an architectural boundary if at all possible, for as long as possible.
