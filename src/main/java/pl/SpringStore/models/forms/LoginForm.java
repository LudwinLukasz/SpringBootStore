package pl.SpringStore.models.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Created by arabk on 26.10.2017.ń
 */
public class LoginForm {

    @NotBlank
    private String login;

    @NotBlank
  //  @Pattern(regexp = "[1-9][0-9]*")
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
