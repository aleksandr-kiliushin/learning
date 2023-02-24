# BINARY SEARCH

## Use cases

- searching for a person in a phonebook;
- searching for a word in a dictionary;
- searching for a user by their username in a DB table.

## Input

- a **sorted** list of elements;
- a search criteria that matches to the list sorting logic.

## Output

- if an element is found, returns **position** where it is located;
- if an element is not found, returns -1.

## Example 1. Guess a number

There is a number we should guess. It is in range 1..10. After each try, we have a feedback if the number we said is too low or too high:

- 5?
- Too low.
- Ok. The number is in range 6..10, the others are eleminated. 8?
- Too low.
- Ok. The number is in range 9..10, the others are eleminated? 10?
- Too high.
- 9?
- Yes!

## Complexity

$O(log{_2}n)$

For a range of 1..10: $O(log{_2}10) = 3.32$.  
So you need at most 4 iterations to find the number.
