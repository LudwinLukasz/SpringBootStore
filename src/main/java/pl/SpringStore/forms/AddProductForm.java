package pl.SpringStore.forms;

import org.hibernate.validator.constraints.NotBlank;
import pl.SpringStore.models.ProductModel;

import java.math.BigDecimal;

public class AddProductForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private int unitsInStock;

    public AddProductForm() {
    }

    public AddProductForm(String name, String description, BigDecimal price, int unitsInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
