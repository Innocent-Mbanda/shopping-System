package com.example.orderservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Long id;
    private String orderNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
