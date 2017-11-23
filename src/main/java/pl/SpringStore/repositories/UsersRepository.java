package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SpringStore.models.Users;

import java.util.Optional;

/**
 * Created by arabk on 22.11.2017.
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String userName);
    Optional<Users> findByLogin(String userLogin);
}