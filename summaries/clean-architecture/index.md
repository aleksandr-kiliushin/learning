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

## Part 1. Introduction

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

The goal of software architecure is to minimize the human resources required to build and maintain the required system.

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

CONTINUE HERE.

### Chapter 2. A tale of two values
