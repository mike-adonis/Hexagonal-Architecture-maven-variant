package com.example.hexagonalarchitecture.kitchenassistant.application.port.out;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.OrderEntryEntity;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.dtos.StockRequest;

public interface OrderEntryPort {

    Long createOrderEntry(Long userId, StockRequest request);

    OrderEntryEntity findById(Long id);
}
