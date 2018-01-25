package pl.SpringStore.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class AddProductForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Min(0)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal unitPrice;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String category;

    @Min(1)
    @Max(1000)
    private int unitsInStock;

    public AddProductForm() {
    }

    public AddProductForm(String name, String description, BigDecimal unitPrice, String manufacturer, String category, int unitsInStock) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.manufacturer = manufacturer;
        this.category = category;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
