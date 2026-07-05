package com.ecommerce;

public class SearchAlgorithmsTest {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Headphones", "Audio"),
                new Product(104, "Keyboard", "Accessories"),
                new Product(105, "Smartphone", "Electronics")
        };

        SearchAlgorithms searchAlgorithms = new SearchAlgorithms(products);

        assertEqual(searchAlgorithms.linearSearch("Mouse"), 1, "Linear search should find Mouse");
        assertEqual(searchAlgorithms.linearSearch("Unknown"), -1, "Linear search should return -1 for missing product");
        assertEqual(searchAlgorithms.binarySearch("Headphones"), 0, "Binary search should find Headphones");
        assertEqual(searchAlgorithms.binarySearch("Unknown"), -1, "Binary search should return -1 for missing product");

        System.out.println("All search tests passed.");
    }

    private static void assertEqual(int actual, int expected, String message) {
        if (actual != expected) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
}
