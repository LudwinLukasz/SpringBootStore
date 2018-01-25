package pl.SpringStore.models;

import java.math.BigDecimal;

public class CartItemModel {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItemModel() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }
}
