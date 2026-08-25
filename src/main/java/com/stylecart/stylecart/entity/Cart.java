package com.stylecart.stylecart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    public Cart(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "user_id")
    private Long userId;
    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    
}
