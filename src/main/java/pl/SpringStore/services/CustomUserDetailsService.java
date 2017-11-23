package pl.SpringStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.SpringStore.models.CustomUserDetails;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.UsersRepository;

import java.util.Optional;

/**
 * Created by arabk on 22.11.2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Users> optionalUsers = usersRepository.findByName(userName);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return optionalUsers.map(CustomUserDetails::new).get();
    }
}
