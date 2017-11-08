package pl.SpringStore.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by arabk on 26.10.2017.ń
 */
public class LoginForm {

    @NotBlank
   // @Pattern(regexp ="^[a-z0-9_-]{3,50}$")
    @Pattern(regexp ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String login;

    @NotBlank
  //  @Pattern(regexp = "[1-9][0-9]*")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15})")
    private String password;

    public LoginForm() {}

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
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
