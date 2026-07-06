# Exercise 7: Financial Forecasting

## Concept of Recursion
Recursion is a technique where a method calls itself with a smaller version of the same problem until it reaches a base case. It can simplify problems that naturally break into repeated subproblems, such as repeated growth over multiple periods.

## Recursive Forecasting Approach
The recursive method in this project predicts the future value by applying the growth rate repeatedly for each period. The base case is when no periods remain, and the recursive step applies one period of growth and reduces the remaining period count.

## Time Complexity
The recursive implementation runs in O(n) time because it performs one recursive call per period. It also uses O(n) stack space in the worst case because each recursive call adds a frame to the call stack.

## Optimization
To make the recursive solution faster and more memory-efficient, an iterative loop can be used. The iterative version avoids repeated function calls and stack overhead while producing the same result.
