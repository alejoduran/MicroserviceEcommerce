package com.checkout.microservices.app.orders.repository;

import org.springframework.data.repository.CrudRepository;

import com.checkout.microservices.app.orders.models.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
