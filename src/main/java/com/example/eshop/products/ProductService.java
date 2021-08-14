package com.example.eshop.products;

import com.example.eshop.Order.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> list(){
        return productRepository.findAll();
    }
    public void add(Products products){
        productRepository.save(products);
    }
}
