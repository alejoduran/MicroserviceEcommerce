package com.checkout.microservices.app.orders.services;

import java.math.BigDecimal;
import java.util.List;

import com.arenasoccer.mircroservices.commons.services.CommonService;
import com.checkout.microservices.app.orders.models.entity.Order;

public interface OrderService extends CommonService<Order> {

	public BigDecimal billSumAllProducts(List<Order> orders);

	public void createAndSendOrders(List<Order> orders);

}
