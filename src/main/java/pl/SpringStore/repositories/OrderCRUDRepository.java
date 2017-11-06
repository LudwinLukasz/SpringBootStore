package pl.SpringStore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.OrderModel;

/**
 * Created by monik on 03.11.2017.
 */
@Repository
public interface OrderCRUDRepository extends CrudRepository<OrderModel,Integer> {



    OrderModel findById(int orderId);


}
