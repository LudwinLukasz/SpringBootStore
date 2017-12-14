package pl.SpringStore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.OrderModel;
import pl.SpringStore.models.Users;

import java.util.List;

/**
 * Created by monik on 03.11.2017.
 */
@Repository
public interface OrderCRUDRepository extends CrudRepository<OrderModel,Integer> {

    List<OrderModel> findByUsers(Users users);

}
