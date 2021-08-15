package com.example.eshop.products;


import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping("shop/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //Get information from database
    @GetMapping(path = "list")
    public List<Products> list(){
        return productService.list();
    }

    //Send information to database
    @PostMapping(path = "item")
    public List<Products> add(@RequestBody Products products){
         productService.add(products);
         return productService.list();
    }
    @DeleteMapping(path = "item/{productsId}")
    public void delete(@PathVariable Long productsId){
        productService.delete(productsId);
    }
    @PutMapping(path = "item")
    public void update(@RequestBody Products products){
        productService.update(products);
    }
}


