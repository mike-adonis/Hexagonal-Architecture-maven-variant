package com.example.hexagonalarchitecture.kitchenassistant.application.port.out;

import com.example.hexagonalarchitecture.kitchenassistant.domain.User;

public interface LoadUserPort {

    User loadSystemUser(Long id);

    String createDummyUser();
}
