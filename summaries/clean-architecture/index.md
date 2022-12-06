# Summary: Clean code by Robert C. Martin

## Foreword

> Architecture represents the significant design decisions that shape a system, where significant is measured by cost of change.

System's development changes should be:

- ~~💸 costly~~;
- ~~🤯 hard to make~~;
- ~~🏭 managed projects of their own~~;
- 🧘 folded into the daily workflow.

There are a lot of paths to build the architecture:

- 🗿 Architecture can be too strong and stable, born from authority and rigidity.  
  If change is expensive, change is eliminated, which causes subdued or headed of into a bureacratic ditch.  
  Totalitarism in architecture becomes a dystrophia for developers and a constant source of developers for all.
- 🤡 Architecture can have a strong smell of speculative generality.  
  Your project becomes filled with hard-coded guesswork, countless parameters, tombs of dead code, and more complexity than your maintanance budget can allow.
- 😊 Architecture can be maintanable and flourishing.
  - software softness is preserved as a first-class property of the system;
  - new things are discovered and created;
  - questions are asked;
  - experiments are ran.

A good architecture is ~~a destination or a frozen artifact~~ an ongoing process like a jorney or enquiry.

## Preface

Software systems are created for different domains and using various technologies.  
But they share similar rules of architecture.  
These rules are about ordering and assembling the building blocks of programs.  
They are universal regardless time and system types.

## Part I. Introduction

Getting software working is easy.  
Kids produce working code. Students start businesses based on a few lines of PHP code. Juniors make their tasks done.  
The code they produce may not be pretty; but it works.  
It works because getting something to work -- once -- is easy.

Gettings software right is hard.  
It requires knowledge, skills that most programmers don't take time to develop.  
It requires high level of and discipline and didication that most programmers never dreamed they'd need.  
It takes a passion for the craft and the desire to be a professional.

When your software is done right:

- ~~you need hords of programmers to keep it working~~;
- ~~you need massive requirements documents and huge issue tracking systems~~;
- ~~you need 24/7 programming~~;
- ~~bad code and rotten design~~;
- ~~exhausted patience of the managers~~;
- ~~trivial changes require two-week digging and involve high risks~~;
- you need only a fraction of human resources to to create and maintain;
- changes are simple and rapid;
- defects are few and far between;
- effort is minimized;
- functionality and flexibility are maximized;
- customers are happy, managers trust you;

### Chapter 1. What is design and architecture

Design and architecture are the same.  
The word «architecture» is often used to describe high-level concepts that are divorced from low-level details.  
The word «design», conversely, more often implies structures and decisions at a low level.  
But this separation is nonsensical when you look what a real architect does.  
Low-level details and high-level decision are all part of the same whole. There is no clear dividing line between them.  
There is simply a continuum of decisions from the highest to the lowest levels.

#### The goal

> The goal of software architecure is to minimize the human resources required to build and maintain the required system.

The measure of design quality is the measure of the effort required to meet the customer's needs.  
The effort is low, and stays low throughout the lifetime of the system? The design is good.  
The effort grows with each release? The design is bad.

#### Case study

You can measure how some interesting measures change during the system lifetime.

- engineering staff amount;
- time per codeline;
- codeline cost;
- company's monthly development payroll;
- other productivity indices.

#### The signature of a mess

When a system is messy, the developers' job becomes «moving the mess from one place to the next, and the next», so that they can add one more inadequately little feature.  
Company earnings fall down, developers frustrate, managers are in rage.

#### What went wrong

The morals of the «Tortoise and the Hare» story:

- Slow and steady wins the race.
- The race is not to the swift, nor the battle to the strong.
- The more haste, the less speed.

Most developers work hard, but a part of their brain sleeps -- the part that knows that clean, well-designed code matters.

Another mistake: «We can clean it up later, we just have to get to market first!» -- the Hare's mistake.  
Why later? Do you think you won't have to get new features done? Or maybe the «Pause the market» button will suddenly appear?  
These developers are overconfident in their ability to remain productive.  
Writing messy code makes them go fast in the short term and slows them down in the long term.

> The only way to go fast, is to go well.

Stop be overconfident.  
Start taking the responsibility for the mess you've made.

The solution is ~~to start over from scratch and redesign the whole system~~. It's just another manifestation of the same overconfidence that led to the mess.  
Their overconfidence will drive the redesign into the same mess as the original project.

#### Conclusion

- Recognize and avoid you overconfidence.
- Start taking the quality of your software seriously.
- You need to know what good software architecture is, what its attributes are.

### Chapter 2. A tale of two values

Every software system provides two different values to the stakeholders: behavior and structure.  
Developers are responsible for ensuring that both of them remain high.  
Unfortunetely, developers often focus of one of them, leaving the software system eventually valueless.

#### Behavior

Developers are hired to make machines to behave in a way that makes or saves money for the stakeholders.  
We do this by helping the stakeholders to develop a functional specification, or requirements document.  
Many programmers think that is the entirely of their job. They are sadly mistaken.

#### Architecture

The second value of software relates to the softness of software.  
Software is intended to be a way to easily change the behavior of machines.

To fulfill its purpose, software must be soft.  
When the stakeholders change their minds about a feature, that change should be simple and easy to make.  
The difficulty in making such a change should be proportional only to the scope of the change, and not to the shape of the change.

#### The greater value

What is more important for the software system -- to work, or to be easy to change?

Business managers likely say it's more important for the software system to work. Developers, in turn, often go alogn with this attitude. But it's a wrong attitude.  
Let's examine the extremes:

- Extreme 1:
  - a program works perfectly;
  - it's impossible to make changes when the requirements change;
  - therefore the program will become useless.
- Extreme 2:
  - a program doesn't work;
  - it is easy to make it work;
  - it is easy to keep it working as requirements change.
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

#### Eisenhower's matrix

|                      |                          |
| -------------------- | ------------------------ |
| Important + urgent   | Important + not urgent   |
| Unimportant + urgent | Unimportant + not urgent |

The first value of software -- behavior -- is urgent but never particulary important.  
The second value of software -- architecture -- is important but never particulary urgent.

Of course, some things are both important and urgent, and some -- both unimportant and not urgent.

The dilemma for developers is that managers are not equipped to evaluate the importance of architecture.  
That's what developers were hired to do.  
It's the responsibility of the software development team to assert the importance of architecture over the urgency of features.

#### Fight for the architecture

Fulfilling this responsibility means wading into a fight.  
The development team has to struggle for what they believe to be best for the company.  
And so do the management team, and the marketing team, and the sales team.

Effective software developers uabashedly squabble with all the other stakeholders as equals.  
Remember, as a software developer, you are a stakeholder. You have a stake in the software that you need to safeguard.  
It's a part of you role, of your duty. It's a big part of why you were hired.

This challenge is doubly important if you're a software architect.  
Architects are focused on creating an architecture that allows features to be easily developed, modified and extended.

If architecture comes last, then the system will become ever more costly to develop.  
This means that the software development team did not fight hard enough.

## Part II. Starting with the bricks: programming paradigms

### Chapter 3. Paradigm overview

No content.

#### Structured programming

Imposes discipline on direct transfer of control.

#### Object-oriented programming

No content.

#### Functional programming

No content.

#### Food for thought

Each of the paradigms removes capabilities from the programmer.  
None of them adds new capabilities.  
Each imposes extra discipline.  
The paradigms tell us what not to do, more than what to do.

#### Conclusion

No content.

### Chapter 4. Structured programming

It was invented by Edsger Wybe Dijkstra.

#### Proof

- 🧩 programming was hard before SP was invented;
- 😓 programmers didn't do it very well because a program contains too many details for a human brain to manage;
- 👾 a program may seem to work but fails in surprising ways;
- ∑ the idea behind it is applying the mathematical discipline of proof;
- ☝️ it turned out that the construction of a Euclidian hierarchy of postulates, theorems and lemmas are useful in programming
- 🧐 programmers can use these proven structures the way mathematicians do;
- 🙅 certain uses of the `goto` statement prevented code from being decomposed into smaller modules, thereby prevented use of the divide-and-conquer approach necessary for reasonable proofs;
- 👌 other uses of the `goto` statement are «good» (these have evoleved to `if`, `while`, etc);
- ✅ the created technique mathematically traced the input of the sequence to the output of the sequence, which has no difference from any normal mathematical proof;

#### A harmful proclamation

As the result of a 10-years discussion, Dijkstra proved harmfulness of the `goto` statement. `goto` is no longer a part of any modern language.

Nowadays, we are all structured programmers, though not by necessary by choice.  
It's just that our languages don't give us the opinion to use undisciplined direct transfer of control.  
Yes, there are some `goto` analogs in modern languages, but they are very strict, or at least scoped within the current function.

#### Functional decomposition

SP allows you to decompose a large-scale problem statement into high-level functions.  
Each of those functions can then be decomposed into lower-level functions, ad infinitum.  
Moreover, each of those functions can be represented using the restricted control structures of SP.

#### No formal proofs

Mathematics is not applicable to prove correctness of our provable functions.

#### Science to the resque

Science is fundamentally different from mathematics.  
In the context of proving of functions correctness, programming closer to science, than to mathematics.  
I can demonstrate my function works, I can show that it's correct in many different cases, but I can't prove it in the sense of a mathematical proof.  
No matter how many experiments I conduct, or how much empirical evidence I gather, there is always the chance that another experiment will fail with certain conditions.

Science doesn't work by proving statements true, but rather by proving statements false.  
Those statements that we can't prove false, after much effort, we deem to be true enough for our purposes.

#### Tests

Testing shows the presence, not the absence, of bugs.

SP forces us to recursively decompose a program into a set of small provable functions. We can then use tests to try to prove those small provable functions are incorrect. If such tests fail to prove incorrectness, then we consider the functions to be correct enough for our purposes.

#### Conclusion

SP is valuable for it's ability to create testable units. This is the reason why modern languages don't typically support unrestrained `goto` statements. At the architectural level, this is why we consider functional decomposition to be a best practice.

At every level, software is like a science and, therefore, is driven by testability.  
Architects strive to define modules, components and services to that are easily testable. To do so, they employ restrictive disciplines similar to structured programming.
