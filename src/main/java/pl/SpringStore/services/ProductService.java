package pl.SpringStore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.repositories.ProductCRUDRepository;

import java.util.Collections;


@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductCRUDRepository productCRUDRepository;

    public Iterable<ProductModel> findAll() {
        try {
            return productCRUDRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occured during connection to database.");
            return Collections.emptyList();
        }
    }

    public ProductModel findByProductId(Integer productId) {
        try {
            return productCRUDRepository.findOne(productId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Product with id={} does not exist");
        }
        return null;
    }
}
