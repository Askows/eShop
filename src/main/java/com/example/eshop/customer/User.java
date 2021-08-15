package com.example.eshop.customer;

import javax.persistence.*;

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

    public User( String userName, String name, String email, String password) {
        this.id = id;
        UserName = userName;
        Name = name;
        this.email = email;
        Password = password;
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
