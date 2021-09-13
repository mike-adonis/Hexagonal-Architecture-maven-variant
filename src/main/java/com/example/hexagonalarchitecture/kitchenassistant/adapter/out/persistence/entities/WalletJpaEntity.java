package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user_wallet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal balance;

    private Date dateOfCreation;

}
