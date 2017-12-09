package pl.SpringStore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.OrderModelProduct;

/**
 * Created by arabk on 09.12.2017.
 */
@Repository
public interface OrderProductCRUDRepository extends CrudRepository<OrderModelProduct, Integer> {


}
