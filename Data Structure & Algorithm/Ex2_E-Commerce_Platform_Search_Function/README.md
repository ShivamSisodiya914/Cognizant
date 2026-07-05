# Exercise 2: E-commerce Platform Search Function

## 1. Asymptotic Notation and Big O

Big O notation describes how the runtime of an algorithm grows as the input size increases. It helps developers compare solutions and choose efficient approaches for large datasets.

- Best case: the fastest possible scenario.
- Average case: typical performance for random input.
- Worst case: the maximum possible time an algorithm may take.

For search operations:
- Linear search checks each element one by one.
- Binary search cuts the search space in half each step.

## 2. Product Class

The Product class stores the main fields used for searching:
- productId
- productName
- category

## 3. Implemented Search Algorithms

The project contains:
- Linear search for unsorted data
- Binary search for sorted data

## 4. Time Complexity Comparison

- Linear search: O(n)
- Binary search: O(log n)

Binary search is more suitable for a large e-commerce catalog because it is much faster once the data is sorted.

## 5. How to Run

Compile and run the test class from the project root:

```bash
javac -d out $(find src/main/java src/test/java -name "*.java")
java -cp out com.ecommerce.SearchAlgorithmsTest
```
