package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import services.UserService;

public class RegisterController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private UserService userService = new UserService();

    @FXML
    protected void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        User user = new User(0, name, email, password);
        userService.registerUser(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Success");
        alert.setHeaderText(null);
        alert.setContentText("User registered successfully!");
        alert.showAndWait();
    }
}
