# Inventory Management System

## 1. Why data structures and algorithms matter
Data structures and algorithms are essential when managing large inventories because they determine how quickly the system can store, search, update, and remove products. A warehouse may contain thousands of records, so inefficient operations can slow down the application and make it harder to scale.

## 2. Suitable data structures
For this problem, a `HashMap` is a good fit because products can be identified by a unique `productId` and looked up quickly. A `LinkedHashMap` is used here to preserve insertion order while still offering fast access.

## 3. Project structure
- `src/main/java/com/inventory/Product.java` defines the product model.
- `src/main/java/com/inventory/InventoryManager.java` handles add, update, delete, and lookup operations.
- `src/main/java/com/inventory/InventoryApp.java` demonstrates the system.
- `src/test/java/com/inventory/InventoryManagerTest.java` verifies core behavior.

## 4. Time complexity
Using `HashMap` for storage:
- Add: average $O(1)$
- Update: average $O(1)$
- Delete: average $O(1)$

## 5. Optimization ideas
- Use `HashMap` or `LinkedHashMap` for fast access by `productId`.
- Keep the data in memory for fast operations.
- Add validation for duplicate IDs and invalid input.
- If the inventory grows very large, consider database storage or indexing.

## 6. How to run
From the project root, run:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.inventory.InventoryApp
```

To run the tests:

```bash
javac -cp src/main/java -d out $(find src/test/java -name "*.java")
java -cp out com.inventory.InventoryManagerTest
```
