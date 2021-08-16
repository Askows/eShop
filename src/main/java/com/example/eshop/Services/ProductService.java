package com.example.eshop.Services;

import com.example.eshop.entity.Product;
import com.example.eshop.repository.ProductRepository;
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
    public List<Product> list(){
        return productRepository.findAll();
    }
    //Add products to database
    public void add(Product product){
        productRepository.save(product);
    }
    //Delete product by Id from database
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
    //Upddate product in database
    public void update(Product product) {
        Optional<Product> row = productRepository.findById(product.getId());
        if(row.isPresent()){
            Product item = row.get();
            if(!product.getName().isEmpty()){
                item.setName(product.getName());
            }
            if(product.getPrice() != 0){
                item.setPrice(product.getPrice());
            }
            productRepository.save(item);
        }


    }
}
