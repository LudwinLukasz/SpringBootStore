package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.Users;

import java.util.Optional;

/**
 * Created by arabk on 22.11.2017.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String userName);
    Optional<Users> findByLogin(String userLogin);

}