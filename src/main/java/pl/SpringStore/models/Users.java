package pl.SpringStore.models;

import pl.SpringStore.forms.LoginForm;
import pl.SpringStore.forms.RegisterForm;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arabk on 22.11.2017.
 */
@Entity
@Table(name="user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;

    private String name;
    private String surname;
    private String login;
    private String password;
    private int active;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    public Users() {
    }

    public Users(Users users) {
        this.active=users.getActive();
        this.id=users.getId();
        this.login=users.getLogin();
        this.name=users.getName();
        this.password=users.getPassword();
        this.roles=users.getRoles();
        this.surname=users.getSurname();
    }

    public Users(LoginForm form) {
        login = form.getLogin();
        password = form.getPassword();
    }

    public Users(RegisterForm form) {
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
