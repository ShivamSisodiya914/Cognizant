package com.inventory;

public class InventoryManagerTest {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Product laptop = new Product("P100", "Laptop", 5, 1200.50);
        Product mouse = new Product("P200", "Mouse", 20, 25.00);

        assertTrue(inventoryManager.addProduct(laptop), "Add laptop should succeed");
        assertTrue(inventoryManager.addProduct(mouse), "Add mouse should succeed");
        assertTrue(!inventoryManager.addProduct(laptop), "Duplicate product should not be added");

        Product updatedLaptop = new Product("P100", "Gaming Laptop", 3, 1400.00);
        assertTrue(inventoryManager.updateProduct("P100", updatedLaptop), "Update should succeed");
        assertTrue(inventoryManager.getProduct("P100").getProductName().equals("Gaming Laptop"), "Product name should be updated");

        assertTrue(inventoryManager.deleteProduct("P200"), "Delete should succeed");
        assertTrue(inventoryManager.getProduct("P200") == null, "Deleted product should not be present");

        System.out.println("All inventory tests passed.");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
