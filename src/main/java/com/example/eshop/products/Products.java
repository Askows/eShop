package com.example.eshop.products;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Pet name can't be empty")
    private String name;
    private int price;
    @NotBlank(message = "Pet type name can't be empty(CAT,MOUSE,HORSE)")
    private String group;

}




