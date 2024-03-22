package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orders;

    public OrderMapRepo() {
        this.orders = new HashMap<>();
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.orderId(), order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.orderId());
    }

    @Override
    public Order getSingleOrder(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}