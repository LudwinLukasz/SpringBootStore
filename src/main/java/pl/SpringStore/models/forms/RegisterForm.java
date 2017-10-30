package pl.SpringStore.models.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by arabk on 26.10.2017.
 */
public class RegisterForm {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String login;

    @NotBlank
    //  @Pattern(regexp = "[1-9][0-9]*")
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
