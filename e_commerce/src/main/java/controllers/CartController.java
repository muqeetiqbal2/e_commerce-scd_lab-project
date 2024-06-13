package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import models.Cart;
import models.Product;
import services.CartService;

public class CartController {
    @FXML
    private ListView<String> cartListView;
    @FXML
    private Label totalLabel;

    private CartService cartService = new CartService();

    @FXML
    public void initialize() {
        updateCartView();
    }

    private void updateCartView() {
        Cart cart = cartService.getCart();
        cartListView.getItems().clear();
        for (Product product : cart.getProducts()) {
            cartListView.getItems().add(product.getName() + " - $" + product.getPrice());
        }
        totalLabel.setText("Total: $" + cart.getTotalCost());
    }

    @FXML
    protected void handleCheckout() {
        // Handle checkout process here
        cartService.clearCart();
        updateCartView();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Checkout");
        alert.setHeaderText(null);
        alert.setContentText("Checkout successful!");
        alert.showAndWait();
    }
}
