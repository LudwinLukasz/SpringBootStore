package pl.SpringStore.models.repositories;

import org.springframework.stereotype.Component;
import pl.SpringStore.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arabk on 30.10.2017.
 */
@Component
public class FakeProductsRepo {

    List<Product> productsList = new ArrayList<>();

    public List<Product> getProducts() {
        return productsList;
    }

    public void add(Product product) {
        productsList.add(product);
    }


}
