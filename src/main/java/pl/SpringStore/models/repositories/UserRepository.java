package pl.SpringStore.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.SpringStore.models.UserModel;

import java.util.List;

/**
 * Created by arabk on 26.10.2017.
 */
public interface UserRepository extends CrudRepository<UserModel, Integer> {

        List<UserModel> findByLoginAndPassword(String login, String password);
        List<UserModel> findByLogin(String login);
}
