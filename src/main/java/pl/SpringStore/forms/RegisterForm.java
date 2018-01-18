package pl.SpringStore.forms;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Created by arabk on 26.10.2017.
 */
public class RegisterForm {

    @NotBlank
    @Pattern(regexp ="^[A-Za-z0-9_-żźćńółęąśŻŹĆĄŚĘŁÓŃ]{1,25}$")
    private String name;

    @NotBlank
    @Pattern(regexp ="^[A-Za-z0-9_-żźćńółęąśŻŹĆĄŚĘŁÓŃ]{1,25}$")
    private String surname;

    @NotBlank
    @Pattern(regexp ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String login;

    @NotBlank
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15})")
    private String password;

    public RegisterForm() {}

    public RegisterForm(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
