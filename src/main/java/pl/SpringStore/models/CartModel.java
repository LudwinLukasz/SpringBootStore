package pl.SpringStore.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartModel {
    private int cartId;
    private Map<Integer, CartItemModel> cartItems;
    private BigDecimal price;

    public CartModel() {
        cartItems = new HashMap<Integer, CartItemModel>();
        price = new BigDecimal(0);
    }

    public CartModel(int cartId) {
        this();
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItemModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItemModel> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void addCartItem(CartItemModel item) {
        int productId = item.getProduct().getProductId();
        if(cartItems.containsKey(productId)){
            CartItemModel existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, item);
        } else {
            cartItems.put(productId, item);
        }
        updatePrice();
    }

    public void updatePrice() {
        price = new BigDecimal(0);
        for (CartItemModel item : cartItems.values()) {
            price = price.add(item.getTotalPrice());
        }
    }
}
