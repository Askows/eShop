package com.example.eshop.products;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Products {
    @Id
    @SequenceGenerator(name = "products_sequence", sequenceName = "products_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")
    private Long id;
    private String name;
    private double price;



    public Products(String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Products() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}




