package pl.SpringStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.SpringStore.models.Role;
import java.util.Set;

/**
 * Created by arabk on 29.11.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Set<Role> findByRole(String role);
    Set<Role> findByRoleId(int roleId);
}
