package com.example.eshop.repository;

import com.example.eshop.entity.Product;
import com.example.eshop.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    public List<Product> findByProductType(ProductType productType);
}
