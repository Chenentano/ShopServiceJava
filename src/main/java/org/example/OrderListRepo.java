package org.example;

import java.util.ArrayList;
import java.util.List;

class OrderListRepo implements OrderRepo {
    private List<Order> orders;

    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getSingleOrder(String orderId) {
        for (Order order : orders) {
            if (order.orderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}

