package com.example.eshop.GeneralContorler;

import com.example.eshop.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GeneralController {

    @GetMapping(path = "/")
    public String index(final ModelMap modelMap){
        return "wellcome";
    }
    @GetMapping(path = "registration")
    public String registrationForm(final ModelMap modelMap){
        return "register";
    }

    // Login form
    @RequestMapping("/login")
    public String login(final ModelMap modelMap) {
        return "login";
    }

    // Login form with error ?????????????????????????????????????????
    @RequestMapping("/login-error")
    public String loginError(final ModelMap modelMap) {
        modelMap.addAttribute("loginError", true);
        return "login";
    }

}
