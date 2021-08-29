package com.example.eshop.entity;

import com.example.eshop.SecurityConfig.Role;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
    private String email;
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

    public User( String firstName, String lastName, String email, String password, Collection<Role> roles) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
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
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
        Password = password;
    }
}




