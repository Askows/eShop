package com.example.eshop.entity;

import com.example.eshop.Services.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @SequenceGenerator(name = "products_sequence", sequenceName = "products_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")
    private Long id;
    @Column(name = "First_name")
    private String FirstName;
    @Column(name = "Last_name")
    private String LastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String Password;
    @ManyToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name= "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(
                            name="role_id" ,referencedColumnName = "id"))
        private Collection<Role> roles;



    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, Collection<Role> roles) {
        id= id;
        FirstName = firstName;
        LastName = lastName;
        email = email;
        Password = password;
        this.roles = roles;
    }
    public User( String firstName, String lastName, String email, String password, Collection<Role> roles) {
        FirstName = firstName;
        LastName = lastName;
        email = email;
        Password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.LastName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}




