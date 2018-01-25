package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCRUDRepository extends CrudRepository<Product, Integer>{

    List<Product> findAll();
    Product findByProductId(Integer productId);
    Optional<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);

    @Modifying
    @Query("update Product p set p.unitsInStock = ?1 where p.productId = ?2")
    void setUnitsInStockById(Long unitsInStock, Integer productId);

}
