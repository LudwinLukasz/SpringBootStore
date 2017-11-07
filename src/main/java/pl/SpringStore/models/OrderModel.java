package pl.SpringStore.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by monik on 02.11.2017.
 */
@Entity
@Component
@Table(name="order")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int idUser;
    private String name;

    public OrderModel() {
    }

    public OrderModel(Long id, int idUser, String name) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
