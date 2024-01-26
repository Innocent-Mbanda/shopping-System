package com.example.orderservice.Controller;

import com.example.orderservice.OrderRequest.OrderRequest;
import com.example.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
     orderService.PlaceOrder(orderRequest);
     return "order placed successfully";
    }
}
