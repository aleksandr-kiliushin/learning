# SELECTION SORT

## Use cases

- sort elements in ascending or descending order.

## Input

- an unsorted array / linked list of elements;
- sorting criteria.

## Output

- a sorted array / linked list of elements.

## Example 1. Sort files by their size

1. Create an empty `sortedArray` to store sorted elements.
2. Perform simple search through the `initialArray` to find the largest file.
3. Add the found file to `sortedArray` at the index `0`. Remove this file from `initialArray`.
4. Repeat 2. and 3. until `initialArray` becomes empty.

## Complexity

$O(n^2)$

For an array of 10 elements: $O(log{_2}10) = 100$.
