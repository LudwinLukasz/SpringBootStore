package pl.SpringStore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.repositories.ProductCRUDRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductCRUDRepository productCRUDRepository;

    public List<ProductModel> products = new ArrayList<>();

    public Iterable<ProductModel> findAll() {
        try {
            return productCRUDRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred during connection to database.");
            return Collections.emptyList();
        }
    }

    public ProductModel findByProductId(int productId) {
        try {
            return productCRUDRepository.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Product with id={} does not exist");
        }
        return null;
    }

    public List<ProductModel> findByName(String name) {
        List<ProductModel> productList = new ArrayList<>();
        for (ProductModel p : productCRUDRepository.findAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(p);
            }
        }
        return productList;
    }
}
