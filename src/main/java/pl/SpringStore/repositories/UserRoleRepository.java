package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SpringStore.models.Users;

/**
 * Created by arabk on 29.11.2017.
 */
public interface UserRoleRepository  extends JpaRepository<Users, Integer> {
}
