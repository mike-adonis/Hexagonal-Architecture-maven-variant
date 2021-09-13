package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.AddressJpaEntity;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.OrderEntryEntity;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.UserEntity;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.WalletJpaEntity;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.repository.OrderEntryRepository;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.repository.UserRepository;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.dtos.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.LoadUserPort;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.OrderEntryPort;
import com.example.hexagonalarchitecture.kitchenassistant.domain.User;
import com.example.hexagonalarchitecture.utility.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Date;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements LoadUserPort, OrderEntryPort {

    private final UserRepository userRepository;

    private final OrderEntryRepository orderEntryRepository;

    private final UserMapper userMapper;

    @Override
    public User loadSystemUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userMapper.mapToDomainEntity(user);
    }

    @Override
    public String createDummyUser() {
        UserEntity user = new UserEntity(null,
                "James Milner",
                new AddressJpaEntity(null, 12, "Osborne", "Texas-town", "Texas"),
                new WalletJpaEntity(null, BigDecimal.valueOf(200000D), new Date())
        );
        UserEntity response = userRepository.save(user);
        return response.getName().concat(" ".concat(String.valueOf(response.getId())));
    }

    @Override
    public Long createOrderEntry(Long userId, StockRequest request) {
        UserEntity user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        OrderEntryEntity response = orderEntryRepository.save(new OrderEntryEntity(user, request));
        return response.getId();
    }

    @Override
    public OrderEntryEntity findById(Long id) {
        return orderEntryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
