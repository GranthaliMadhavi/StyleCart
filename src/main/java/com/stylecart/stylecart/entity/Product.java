package com.stylecart.stylecart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_name")
    private String vendorId;

    public Product(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    private String description;

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    private double price;

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    private String category;

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    private String image;

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

    private int stock;

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public String getVendorId(){
        return vendorId;
    }
    public void setVendorId(String vendorId){
        this.vendorId = vendorId;
    }

}
