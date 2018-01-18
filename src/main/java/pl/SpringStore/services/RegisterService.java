package pl.SpringStore.services;

import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.models.Users;
import java.util.Optional;

/**
 * Created by arabk on 01.12.2017.
 */
public interface RegisterService {

    void register(RegisterForm registerForm);

    //Users setUserRole(RegisterForm registerForm);
    void setUserRole(Users user);

    Optional<Users> findByLogin(RegisterForm registerForm);
}
