package services;

import models.Cart;
import models.Product;

public class CartService {
    private Cart cart = new Cart();

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public Cart getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}
