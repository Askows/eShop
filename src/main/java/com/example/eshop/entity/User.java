package com.example.eshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @SequenceGenerator(name = "products_sequence", sequenceName = "products_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")
    private Long id;
    private String UserName;
    private String Name;
    @Column(unique = true)
    private String email;
    private String Password;
    private String Address;
    private String Phone;

    //1 user
//    @OneToMany(mappedBy = "user")
//    private List<Order> orderList;



    public User(String userName, String name, String email, String password, String address, String phone) {
        this.id = id;
        UserName = userName;
        Name = name;
        this.email = email;
        Password = password;
        Address = address;
        Phone = phone;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }
}
