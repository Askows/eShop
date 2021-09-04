package com.example.eshop.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "new_product")
    private Boolean newProduct;

    @Column(name = "hot_product")
    private Boolean hotProduct;

    private double price;
    @Column(name = "old_price")
    private double oldPrice;
    @Column(name="image")
    private String image;

    @Column(length = 65535)
    @Type(type = "text")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_type_id")
    private ProductType productType;

    public Product() {
    }

    public Product(Long id, String name, Boolean newProduct, Boolean hotProduct, double price, double oldPrice, String image, String description, ProductType productType) {
        this.id = id;
        this.name = name;
        this.newProduct = newProduct;
        this.hotProduct = hotProduct;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.description = description;
        this.productType = productType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNewProduct(Boolean newProduct) {
        this.newProduct = newProduct;
    }

    public void setHotProduct(Boolean hotProduct) {
        this.hotProduct = hotProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getNewProduct() {
        return newProduct;
    }

    public Boolean getHotProduct() {
        return hotProduct;
    }

    public double getPrice() {
        return price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}




