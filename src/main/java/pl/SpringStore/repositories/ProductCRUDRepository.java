package pl.SpringStore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.ProductModel;

import java.util.List;

@Repository
public interface ProductCRUDRepository extends CrudRepository<ProductModel, Integer> {

    List<ProductModel> findAll();
    ProductModel findByProductId(Integer productId);
    List<ProductModel> findByName(String name);
    List<ProductModel> findByCategory(String category);
    List<ProductModel> findByManufacturer(String manufacturer);

}
