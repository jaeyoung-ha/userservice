package com.lgu.orderservice.service;

import com.lgu.orderservice.dto.OrderDto;
import com.lgu.orderservice.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrderByUserId(String userId);
}
