package com.stylecart.stylecart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @Column(name = "product_id")
    private Long productId;

    public Long getProductId(){
        return productId;
    } 
    public void setProductId(Long productId){
        this.productId = productId;
    }

    @Column(name = "cart_id")
    private Long cartId;

    public Long getCartId(){
        return cartId;
    }
    public void setCartId(Long cartId){
        this.cartId = cartId;
    }
    private int quantity;

    public CartItem(){
        
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
