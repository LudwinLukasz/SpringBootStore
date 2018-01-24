package pl.SpringStore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.SpringStore.forms.AddProductForm;
import pl.SpringStore.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<ProductModel> findAll();
    ProductModel findByProductId(int productId);
    List<ProductModel> findByName(String name);
    void addProduct(ProductModel product);
    Page<ProductModel> findAllPageable(Pageable pageable);

}
