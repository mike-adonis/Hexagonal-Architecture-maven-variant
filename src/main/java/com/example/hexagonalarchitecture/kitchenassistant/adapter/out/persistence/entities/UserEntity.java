package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressJpaEntity addressJpaEntity;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private WalletJpaEntity walletJpaEntity;



}