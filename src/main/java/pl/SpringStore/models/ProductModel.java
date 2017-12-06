package pl.SpringStore.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discounted;

    public ProductModel() {
    }

    public ProductModel(int productId, String name, BigDecimal unitPrice) {
        this.productId=productId;
        this.name=name;
        this.unitPrice=unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsOnOrder() {
        return unitsInOrder;
    }

    public void setUnitsOnOrder(long unitsOnOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    @Override
    public String toString() {
        return "Produkt [productId= " + productId + ", nazwa= " + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModel that = (ProductModel) o;

        if (unitsInStock != that.unitsInStock) return false;
        if (unitsInOrder != that.unitsInOrder) return false;
        if (discounted != that.discounted) return false;
        if (!productId.equals(that.productId)) return false;
        if (!name.equals(that.name)) return false;
        if (!unitPrice.equals(that.unitPrice)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!manufacturer.equals(that.manufacturer)) return false;
        return category.equals(that.category);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + unitPrice.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (int) (unitsInStock ^ (unitsInStock >>> 32));
        result = 31 * result + (int) (unitsInOrder ^ (unitsInOrder >>> 32));
        result = 31 * result + (discounted ? 1 : 0);
        return result;
    }
}
