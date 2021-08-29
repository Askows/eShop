package com.example.eshop.Services;

import com.example.eshop.dto.UserRegistrationDto;
import com.example.eshop.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

}
