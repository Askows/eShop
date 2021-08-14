package com.example.eshop.products;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("errors")
@RequestMapping("/products")
public class ProductController {

    private final productRepository productRepository;

    @GetMapping
    public String showHomePage(final ModelMap modelMap) {
        modelMap.addAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName());
        modelMap.addAttribute("newPet", new Products());
        return "welcome";
    }

    @GetMapping("/all")
    public String showAllPets(final ModelMap modelMap) {
        modelMap.addAttribute("petList", productRepository.findAll());
        return "products-list";
    }

    @PostMapping("/save")
    public String savePet(final ModelMap modelMap, @Valid Products products, Errors errors) {
        if (errors.hasErrors()) {
            modelMap.addAttribute(
                    "errors",
                    errors.getAllErrors().stream()
                            .map(error -> error.getDefaultMessage())
                            .collect(Collectors.toList()));
        } else {
            productRepository.save(products);
        }
        return "redirect:/pet";
    }
}
