package com.ecommerce;

import java.util.Arrays;

public class SearchAlgorithms {
    private final Product[] products;

    public SearchAlgorithms(Product[] products) {
        this.products = Arrays.copyOf(products, products.length);
    }

    public int linearSearch(String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String targetName) {
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, java.util.Comparator.comparing(Product::getProductName));

        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = sortedProducts[middle].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return middle;
            }
            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
