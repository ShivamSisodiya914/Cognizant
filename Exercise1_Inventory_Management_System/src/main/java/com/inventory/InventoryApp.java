package com.inventory;

public class InventoryApp {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addProduct(new Product("P100", "Laptop", 5, 1200.50));
        inventoryManager.addProduct(new Product("P200", "Mouse", 20, 25.00));

        System.out.println("Initial inventory:");
        inventoryManager.getAllProducts().forEach(System.out::println);

        Product updatedProduct = new Product("P100", "Gaming Laptop", 3, 1400.00);
        inventoryManager.updateProduct("P100", updatedProduct);

        System.out.println("\nAfter update:");
        System.out.println(inventoryManager.getProduct("P100"));

        inventoryManager.deleteProduct("P200");
        System.out.println("\nAfter deletion:");
        inventoryManager.getAllProducts().forEach(System.out::println);
    }
}
