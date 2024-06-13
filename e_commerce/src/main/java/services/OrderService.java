package services;

import models.Order;
import models.User;
import models.Cart;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private int orderIdCounter = 1;

    public void placeOrder(User user, Cart cart, String address, String paymentMethod) {
        Order order = new Order(orderIdCounter++, user, cart, address, paymentMethod, "Pending");
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    public void updateOrderStatus(int id, String status) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setStatus(status);
        }
    }
}
