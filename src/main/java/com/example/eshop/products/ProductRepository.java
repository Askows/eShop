package com.example.eshop.Order;

import com.example.eshop.products.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
}
