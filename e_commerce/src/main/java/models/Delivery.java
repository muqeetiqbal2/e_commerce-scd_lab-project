package models;

public class Delivery {
    private int id;
    private Order order;
    private String trackingNumber;
    private String deliveryStatus; // e.g., "In Transit", "Delivered"

    public Delivery(int id, Order order, String trackingNumber, String deliveryStatus) {
        this.id = id;
        this.order = order;
        this.trackingNumber = trackingNumber;
        this.deliveryStatus = deliveryStatus;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
