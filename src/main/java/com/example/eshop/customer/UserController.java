package com.example.eshop.customer;


import com.example.eshop.products.Products;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "list")
    public List<User> list(){
        return userService.list();
    }

    //Send information to database
    @PostMapping(path = "item")
    public List<User> add(@RequestBody User user){
        userService.add(user);
        return userService.list();
    }
    @DeleteMapping(path = "item/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }

}
