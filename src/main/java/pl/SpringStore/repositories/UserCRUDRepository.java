package pl.SpringStore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.UserModel;

import java.util.List;

/**
 * Created by arabk on 26.10.2017.
 */
@Repository
public interface UserCRUDRepository extends CrudRepository<UserModel, Integer> {

        List<UserModel> findByLoginAndPassword(String login, String password);
        List<UserModel> findByLogin(String login);
        UserModel findOneByLogin(String login);
}
