package pl.SpringStore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.SpringStore.models.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Product findByProductId(int productId);
    Optional<Product> findByName(String name);
    void addProduct(Product product);
    Page<Product> findAllPageable(Pageable pageable);

}
