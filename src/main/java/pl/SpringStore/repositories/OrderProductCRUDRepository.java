package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.OrderModelProduct;

import java.util.List;

/**
 * Created by arabk on 09.12.2017.
 */
@Repository
public interface OrderProductCRUDRepository extends JpaRepository<OrderModelProduct, Integer> {


    List<OrderModelProduct> findByOrderId(Integer currentOrder);

    @Modifying
    @Query("update OrderModelProduct o set o.quantity = ?1 where o.id = ?2")
    void setQuantityById(Integer quantity, Integer id);
}
