package services;

import models.Delivery;
import models.Order;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private List<Delivery> deliveries = new ArrayList<>();
    private int deliveryIdCounter = 1;

    public void createDelivery(Order order, String trackingNumber) {
        Delivery delivery = new Delivery(deliveryIdCounter++, order, trackingNumber, "In Transit");
        deliveries.add(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public Delivery getDeliveryById(int id) {
        return deliveries.stream().filter(delivery -> delivery.getId() == id).findFirst().orElse(null);
    }

    public void updateDeliveryStatus(int id, String status) {
        Delivery delivery = getDeliveryById(id);
        if (delivery != null) {
            delivery.setDeliveryStatus(status);
        }
    }
}
