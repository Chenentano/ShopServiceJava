package org.example;

import java.util.List;

interface OrderRepo {
    void addOrder(Order order);
    void removeOrder(Order order);
    Order getSingleOrder(String orderId);
    List<Order> getAllOrders();
}