package pl.SpringStore.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arabk on 22.11.2017.
 */
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int roleId;

    private String role;

    @ManyToMany(mappedBy="roles",fetch = FetchType.LAZY)
    private Set<Users> users;

    public Role() {
    }
    public Role(int roleId, String role) {
        this.roleId = roleId;
        this.role=role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
