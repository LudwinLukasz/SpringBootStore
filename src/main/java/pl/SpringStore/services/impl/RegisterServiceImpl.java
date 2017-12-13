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
//    @Autowired
//    UsersRepository usersRepository;
//
//    @Autowired
//    RoleRepository roleRepository;

    public void register(RegisterForm registerForm) {
        Users user = setUserRole(registerForm);
        usersRepository.save(user);
        log.info("Registering the new user {}", user.toString());
    }

    public Users setUserRole(RegisterForm registerForm) {
        Set<Role> roles = roleRepository.findByRole("USER");
        Users user = new Users(registerForm);
        user.setRoles(roles);
        return user;
    }

    public Optional<Users> findByLogin(RegisterForm registerForm) {
        return usersRepository.findByLogin(registerForm.getLogin());
    }

}
