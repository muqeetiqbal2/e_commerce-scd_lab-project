package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import models.Order;
import services.OrderService;

public class OrderController {
    @FXML
    private ListView<String> orderListView;

    private OrderService orderService = new OrderService();

    @FXML
    public void initialize() {
        updateOrderView();
    }

    private void updateOrderView() {
        orderListView.getItems().clear();
        for (Order order : orderService.getOrders()) {
            orderListView.getItems().add("Order ID: " + order.getId() + ", Status: " + order.getStatus());
        }
    }

    @FXML
    protected void handleViewOrderDetails() {
        // Implement order details view logic
    }

    @FXML
    protected void handleUpdateOrderStatus() {
        // Implement order status update logic
        // Example:
        int orderId = 1; // This should come from user input
        orderService.updateOrderStatus(orderId, "Shipped");
        updateOrderView();
    }
}
