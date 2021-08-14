package com.example.eshop.products;


import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("shop/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "list")
    public List<Products> list(){
        return productService.list();
    }
    @PostMapping(path = "item")
    public List<Products> add(@RequestBody Products products){
         productService.add(products);
         return productService.list();
    }
}


