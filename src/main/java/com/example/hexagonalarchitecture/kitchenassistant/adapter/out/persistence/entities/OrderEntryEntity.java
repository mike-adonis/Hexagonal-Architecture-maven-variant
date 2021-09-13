package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.entities;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.dtos.StockRequest;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "customer_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private BigDecimal cost;

    private String note;

    public OrderEntryEntity(UserEntity user, StockRequest request) {
        this.user = user;
        this.items = request.getFoodItems().stream().map(OrderItem::new).collect(Collectors.toList());
        this.note = request.getAdditionalNote();
        this.cost = request.getCost();
    }


    @Entity
    @Table(name = "order_items")
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    public static class OrderItem {

        @Id
        @GeneratedValue
        private Long id;

        @Getter
        private String name;

        public OrderItem(String name) {
            this.name = name;
        }
    }

}
