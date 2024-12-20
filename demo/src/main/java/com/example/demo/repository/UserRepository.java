package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserEntity;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
 
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
