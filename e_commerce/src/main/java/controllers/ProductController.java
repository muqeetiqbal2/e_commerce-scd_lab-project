package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Main;
import models.Product;
import services.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductController {
    @FXML
    private TextField searchField;
    @FXML
    private TextField productIdField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField imageUrlField;
    @FXML
    private TextField categoryField;

    private ProductService productService = new ProductService();

    @FXML
    protected void handleLogin() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadLogin(stage);
    }

    @FXML
    protected void handleRegister() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadRegister(stage);
    }

    @FXML
    protected void viewCart() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadCart(stage);
    }

    @FXML
    protected void checkout() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadCheckout(stage);
    }

    @FXML
    protected void viewOrders() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadOrders(stage);
    }

    @FXML
    protected void viewDeliveries() throws IOException {
        Main mainApp = new Main();
        Stage stage = new Stage();
        mainApp.loadDelivery(stage);
    }

    @FXML
    protected void addProduct() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double price = Double.parseDouble(priceField.getText());
        String imageUrl = imageUrlField.getText();
        String category = categoryField.getText();

        Product product = new Product(0, name, description, price, imageUrl, category);
        productService.addProduct(product);

        showAlert("Product Added", "The product has been added successfully.");
    }

    @FXML
    protected void updateProduct() {
        int productId = Integer.parseInt(productIdField.getText());
        String name = nameField.getText();
        String description = descriptionField.getText();
        double price = Double.parseDouble(priceField.getText());
        String imageUrl = imageUrlField.getText();
        String category = categoryField.getText();

        Product product = new Product(productId, name, description, price, imageUrl, category);
        productService.updateProduct(product);

        showAlert("Product Updated", "The product has been updated successfully.");
    }

    @FXML
    protected void deleteProduct() {
        int productId = Integer.parseInt(productIdField.getText());
        productService.deleteProduct(productId);

        showAlert("Product Deleted", "The product has been deleted successfully.");
    }

    @FXML
    protected void searchProducts() {
        String keyword = searchField.getText();
        String category = categoryField.getText();

        List<Product> products = productService.searchProducts(keyword, category);
        
        showAlert("Search Results", "Found " + products.size() + " products.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
