package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.CartService;
import services.OrderService;
import models.User;
import models.Cart;

public class CheckoutController {
    @FXML
    private TextField addressField;
    @FXML
    private TextField paymentField;

    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();

    @FXML
    protected void handleCheckout() {
        String address = addressField.getText();
        String payment = paymentField.getText();

        // Assume user is logged in and retrieved from the session
        User user = new User(1, "John Doe", "john@example.com", "password123");
        Cart cart = cartService.getCart();

        orderService.placeOrder(user, cart, address, payment);

        cartService.clearCart();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        // Close checkout window
        // Implement window close logic here if needed
    }
}
