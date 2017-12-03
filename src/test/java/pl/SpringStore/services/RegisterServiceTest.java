package pl.SpringStore.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.models.Role;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.RoleRepository;
import pl.SpringStore.repositories.UsersRepository;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by arabk on 02.12.2017.
 */
public class RegisterServiceTest {

    private RegisterService registerService;

    private UsersRepository mockUsersRepository = Mockito.mock(UsersRepository.class);
    private RoleRepository mockRoleRepository = Mockito.mock(RoleRepository.class);

    @Before
    public void setup() {
        registerService = new RegisterService(mockUsersRepository, mockRoleRepository);
    }

    @Test
    public void setUserRoleTest() {

        //given
        Role role = new Role(2,"USER");
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        given(mockRoleRepository.findByRole("USER")).willReturn(roles);
        RegisterForm registerForm = new RegisterForm("ala","ma","kota","kot");

        //when
        Users users = registerService.setUserRole(registerForm);

        //then
        assertThat(users.getRoles(),is(roles));

    }


}
