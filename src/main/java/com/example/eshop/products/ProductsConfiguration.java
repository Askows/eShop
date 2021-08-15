package com.example.eshop.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductsConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
         productRepository.saveAll(List.of(
                 new Product("Keyboard",25.8),
                new Product("mouse",21.8),
                new Product("mousepad",14.8),
                new Product("headset",30.8)



         ));
        };
    }
}
