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
                 new Products("Keyboard",25.8),
                new Products("mouse",21.8),
                new Products("mousepad",14.8),
                new Products("headset",30.8)



         ));
        };
    }
}
