package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.AddressJpaEntity;
import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities.UserEntity;
import com.example.hexagonalarchitecture.kitchenassistant.domain.Address;
import com.example.hexagonalarchitecture.kitchenassistant.domain.User;
import com.example.hexagonalarchitecture.kitchenassistant.domain.Wallet;
import org.springframework.stereotype.Component;

@Component
class UserMapper {

    User mapToDomainEntity(
            UserEntity userEntity) {
        AddressJpaEntity userAddress = userEntity.getAddressJpaEntity();
        return User.withId(userEntity.getId(), new Address(userAddress.getHouseNo(), userAddress.getStreetName(), userAddress.getLocalGovernment(), userAddress.getState()), new Wallet(userEntity.getWalletJpaEntity().getBalance()));

    }

}
