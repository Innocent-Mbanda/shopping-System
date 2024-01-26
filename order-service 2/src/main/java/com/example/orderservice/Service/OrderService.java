package com.example.orderservice.Service;

import com.example.orderservice.Dto.OrderLineItemsDto;
import com.example.orderservice.Model.Order;
import com.example.orderservice.Model.OrderLineItems;
import com.example.orderservice.OrderRequest.OrderRequest;
import com.example.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void PlaceOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
      List<OrderLineItems>orderLineItems = orderRequest.getLineItemsDtos().stream()
                .map(this::mapToDto)
                .toList();
          order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto
    ) {
       OrderLineItems orderLineItems = new OrderLineItems();
       orderLineItems.setPrice(orderLineItemsDto.getPrice());
       orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
       orderLineItems.setSkucode(orderLineItemsDto.getSkucode());

       return orderLineItems;

    }
}
