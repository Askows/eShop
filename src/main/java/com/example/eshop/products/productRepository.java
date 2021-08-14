package com.example.eshop.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Products,Long> {
}
