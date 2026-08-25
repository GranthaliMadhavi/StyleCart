package com.stylecart.stylecart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    private String email;
    
    @Column(name = "Pass")
    private String password;

    private String role;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public User() { //Default Constructor

    }

    //getter and setter 

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public LocalDateTime getCreateAt(){
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt){
        this.createAt = createAt;
    }
}
