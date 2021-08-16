package com.example.eshop.Services;

import com.example.eshop.EmailException.RestApiException;
import com.example.eshop.entity.User;
import com.example.eshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Show all users
    public List<User> list(){
        return userRepository.findAll();
    }
    //Add user to database with email validation
    public void add(User user){
        if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }
        userRepository.save(user);
    }
    //Delete user by Id from database
    public void delete(Long productsId) {
        userRepository.deleteById(productsId);
    }


}
