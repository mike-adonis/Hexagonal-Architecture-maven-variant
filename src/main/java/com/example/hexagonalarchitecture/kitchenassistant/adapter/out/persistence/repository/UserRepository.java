package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.repository;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
