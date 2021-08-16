package com.example.eshop.controller;


import com.example.eshop.Services.ProductService;
import com.example.eshop.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //Get information from database
    @GetMapping(path = "list")
    public List<Product> list(){
        return productService.list();
    }

    //Send information to database
    @PostMapping(path = "item")
    public List<Product> add(@RequestBody Product product){
         productService.add(product);
         return productService.list();
    }
    @DeleteMapping(path = "item/{productsId}")
    public void delete(@PathVariable Long productId){
        productService.delete(productId);
    }
    @PutMapping(path = "item")
    public void update(@RequestBody Product product){
        productService.update(product);
    }
}


