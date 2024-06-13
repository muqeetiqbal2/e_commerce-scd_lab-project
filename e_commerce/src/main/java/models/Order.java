package models;

public class Order {
    private int id;
    private User user;
    private Cart cart;
    private String address;
    private String paymentMethod;
    private String status; // e.g., "Pending", "Shipped", "Delivered"

    public Order(int id, User user, Cart cart, String address, String paymentMethod, String status) {
        this.id = id;
        this.user = user;
        this.cart = cart;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
