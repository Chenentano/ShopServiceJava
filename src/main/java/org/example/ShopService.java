package org.example;

import java.util.List;

class ShopService {
    private OrderRepo orderRepo;
    private ProductRepo productRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public void placeOrder(String orderId, String customerName, double totalAmount, List<String> orderedProducts) {
        boolean productsExist = true;
        for (String productName : orderedProducts) {
            Product product = productRepo.getProductByName(productName);
            if (product == null) {
                System.out.println("Product '" + productName + "' does not exist. Order cannot be placed.");
                productsExist = false;
                break;
            }
        }

        if (productsExist) {
            Order newOrder = new Order(orderId, customerName, totalAmount);
            orderRepo.addOrder(newOrder);
            System.out.println("New order placed successfully.");
        }
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }
}

