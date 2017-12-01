package pl.SpringStore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.models.Role;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.RoleRepository;
import pl.SpringStore.repositories.UsersRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Created by arabk on 01.12.2017.
 */
@Service
public class RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    public void register(RegisterForm registerForm) {
        Set<Role> roles = roleRepository.findByRole("USER");
        Users user = new Users(registerForm);
        user.setRoles(roles);
        usersRepository.save(user);
        log.info("Registering the new user {}", user.toString());
    }
    public Optional<Users> findByLogin(RegisterForm registerForm) {
        return usersRepository.findByLogin(registerForm.getLogin());
    }
}
