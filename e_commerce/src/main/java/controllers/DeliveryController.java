package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import models.Delivery;
import services.DeliveryService;

public class DeliveryController {
    @FXML
    private ListView<String> deliveryListView;

    private DeliveryService deliveryService = new DeliveryService();

    @FXML
    public void initialize() {
        updateDeliveryView();
    }

    private void updateDeliveryView() {
        deliveryListView.getItems().clear();
        for (Delivery delivery : deliveryService.getDeliveries()) {
            deliveryListView.getItems().add("Delivery ID: " + delivery.getId() + ", Status: " + delivery.getDeliveryStatus());
        }
    }

    @FXML
    protected void handleUpdateDeliveryStatus() {
        // Implement delivery status update logic
        // Example:
        int deliveryId = 1; // This should come from user input
        deliveryService.updateDeliveryStatus(deliveryId, "Delivered");
        updateDeliveryView();
    }
}
