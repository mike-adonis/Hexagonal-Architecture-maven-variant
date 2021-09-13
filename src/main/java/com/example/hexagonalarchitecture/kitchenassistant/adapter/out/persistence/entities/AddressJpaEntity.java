package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressJpaEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer houseNo;
    @Column
    private String streetName;
    @Column
    private String localGovernment;
    @Column
    private String state;


}
