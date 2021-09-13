package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.repository;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.OrderEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntryRepository extends JpaRepository<OrderEntryEntity, Long> {
}
