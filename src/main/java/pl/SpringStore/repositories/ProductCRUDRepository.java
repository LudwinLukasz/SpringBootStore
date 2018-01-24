package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.ProductModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCRUDRepository extends CrudRepository<ProductModel, Integer>{

    List<ProductModel> findAll();
    ProductModel findByProductId(Integer productId);
    List<ProductModel> findByName(String name);
    List<ProductModel> findByCategory(String category);
    List<ProductModel> findByManufacturer(String manufacturer);

    @Modifying
    @Query("update ProductModel p set p.unitsInStock = ?1 where p.productId = ?2")
    void setUnitsInStockById(Long unitsInStock, Integer productId);

}
