package pl.SpringStore.services.impl;

/**
 * Created by arabk on 06.12.2017.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.models.Role;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.RoleRepository;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.RegisterService;
import java.util.Optional;
import java.util.Set;

/**
 * Created by arabk on 01.12.2017.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(pl.SpringStore.services.RegisterService.class);
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;

    @Autowired
    public RegisterServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository) {
        this.usersRepository=usersRepository;
        this.roleRepository=roleRepository;
    }

    public void register(RegisterForm registerForm) {
        Users user = new Users(registerForm);
        setUserRole(user);
        usersRepository.save(user);
        log.info("Service is registering the new user {}", user.getLogin());
    }

   public void setUserRole(Users user) {
        Set<Role> roles = roleRepository.findByRole("USER");
        user.setRoles(roles);
        log.info("Service is assigning role to user: {}",user.getRoles().stream().findAny().get().getRole());
    }

    public Optional<Users> findByLogin(RegisterForm registerForm) {
        return usersRepository.findByLogin(registerForm.getLogin());
    }

}
