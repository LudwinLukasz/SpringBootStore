package pl.SpringStore.models;

import pl.SpringStore.forms.LoginForm;
import pl.SpringStore.forms.RegisterForm;

import javax.persistence.*;

/**
 * Created by arabk on 26.10.2017.
 */

@Entity
@Table(name="usertmp")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private String login;
    private String password;

    // jesli inne nazwy to adnotacja @Column

    public UserModel(){}

    public UserModel(int id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }


    public UserModel(LoginForm form) {
        login = form.getLogin();
        password = form.getPassword();
    }

    public UserModel(RegisterForm form) {
        name = form.getName();
        surname = form.getSurname();
        login = form.getLogin();
        password = form.getPassword();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
