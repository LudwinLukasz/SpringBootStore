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
import pl.SpringStore.services.impl.RegisterServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by arabk on 02.12.2017.
 */
public class RegisterServiceImplTest {

    private RegisterService registerService;

    private UsersRepository mockUsersRepository = Mockito.mock(UsersRepository.class);
    private RoleRepository mockRoleRepository = Mockito.mock(RoleRepository.class);

    @Before
    public void setup() {
        registerService = new RegisterServiceImpl(mockUsersRepository, mockRoleRepository);
    }

    @Test
    public void setUserRoleTest() {

        //given
        Role role = new Role(2,"USER");
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        given(mockRoleRepository.findByRole("USER")).willReturn(roles);
        RegisterForm registerForm = new RegisterForm("ala","ma","kota","Koteczek1234");

        //when
        Users user = new Users(registerForm);
        registerService.setUserRole(user);

        //then
        assertThat(user.getRoles(),is(roles));

    }

    @Test
    public void registerTest() {
        //given
        RegisterForm registerForm = new RegisterForm("ala","ma","kota","Koteczek1234");
        Users user = new Users(registerForm);
        user.setRoles(mockRoleRepository.findByRole("USER"));
        given(mockUsersRepository.findByLogin("kota")).willReturn(java.util.Optional.ofNullable(user));

        //then
        assertThat(user.getLogin(),is("kota"));
    }

}
