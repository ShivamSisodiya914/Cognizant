package com.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<String, Product> inventory = new LinkedHashMap<>();

    public boolean addProduct(Product product) {
        if (product == null || product.getProductId() == null || product.getProductId().isBlank()) {
            return false;
        }

        if (inventory.containsKey(product.getProductId())) {
            return false;
        }

        inventory.put(product.getProductId(), product);
        return true;
    }

    public boolean updateProduct(String productId, Product updatedProduct) {
        if (productId == null || productId.isBlank() || updatedProduct == null) {
            return false;
        }

        if (!inventory.containsKey(productId)) {
            return false;
        }

        inventory.put(productId, updatedProduct);
        return true;
    }

    public boolean deleteProduct(String productId) {
        if (productId == null || productId.isBlank()) {
            return false;
        }

        return inventory.remove(productId) != null;
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return Collections.unmodifiableCollection(inventory.values());
    }

    public int getProductCount() {
        return inventory.size();
    }
}
