package com.stylecart.stylecart.repository;

import com.stylecart.stylecart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long >{
    
}
