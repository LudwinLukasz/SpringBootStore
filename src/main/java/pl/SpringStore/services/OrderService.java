package pl.SpringStore.services;

import org.springframework.stereotype.Service;
import pl.SpringStore.models.ProductModel;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by monik on 21.11.2017.
 */
@Service
public interface OrderService {

    void addProduct(ProductModel product);

    void removeProduct(ProductModel product);

    Map<ProductModel, Integer> getProductsInCart();

    void checkout();

    void cleanUp();

    BigDecimal getTotal();
}

