package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderRepo orderRepo = new OrderListRepo();

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(new Product("Laptop", 1200, 10));
        productRepo.addProduct(new Product("Phone", 800, 20));

        ShopService shopService = new ShopService(orderRepo, productRepo);
        List<String> orderedProducts = List.of("Laptop", "Phone");
        shopService.placeOrder("1", "Charlie", 2000.00, orderedProducts);

        List<String> invalidProducts = List.of("Laptop", "Tablet");
        shopService.placeOrder("2", "David", 1500.00, invalidProducts);

        System.out.println("\nAll orders in the repository:");
        for (Order order : shopService.getOrderRepo().getAllOrders()) {
            System.out.println("Order ID: " + order.orderId() + ", Customer: " + order.customerName() + ", Total Amount: $" + order.totalAmount());
        }
    }
}