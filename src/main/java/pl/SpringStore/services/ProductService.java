package pl.SpringStore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.SpringStore.models.ProductModel;

import java.util.List;

public interface ProductService {
    public Iterable<ProductModel> findAll();
    public ProductModel findByProductId(int productId);
    public List<ProductModel> findByName(String name);

    Page<ProductModel> findAllPageable(Pageable pageable);

}
