package org.example;

import java.util.ArrayList;
import java.util.List;

class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.name().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
