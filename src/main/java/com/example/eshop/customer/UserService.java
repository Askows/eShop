package com.example.eshop.customer;

import com.example.eshop.products.Products;
import com.example.eshop.response.RestApiException;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Show all users
    public List<User> list(){
        return userRepository.findAll();
    }
    //Add products to database
    public void add(User user){
        if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }
        userRepository.save(user);
    }
    //Delete product by Id from database
    public void delete(Long productsId) {
        userRepository.deleteById(productsId);
    }


}
