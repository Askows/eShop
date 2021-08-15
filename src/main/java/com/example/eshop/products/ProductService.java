package com.example.eshop.products;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Connection to MySQL database

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //Show all products
    public List<Products> list(){
        return productRepository.findAll();
    }
    //Add products to database
    public void add(Products products){
        productRepository.save(products);
    }
    //Delete product by Id from database
    public void delete(Long productsId) {
        productRepository.deleteById(productsId);
    }
    //Upddate product in database
    public void update(Products products) {
        Optional<Products> row = productRepository.findById(products.getId());
        if(row.isPresent()){
            Products item = row.get();
            if(!products.getName().isEmpty()){
                item.setName(products.getName());
            }
            if(products.getPrice() != 0){
                item.setPrice(products.getPrice());
            }
            productRepository.save(item);
        }


    }
}
