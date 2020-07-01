package com.checkout.microservices.app.orders.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arenasoccer.mircroservices.commons.services.CommonServiceImpl;
import com.checkout.commons.models.entity.Product;
import com.checkout.microservices.app.orders.models.entity.Order;
import com.checkout.microservices.app.orders.repository.OrderRepository;

@Service
public class OrderServiceImpl extends CommonServiceImpl<Order, OrderRepository> implements OrderService {

	@Override
	public BigDecimal billSumAllProducts(List<Order> orders) {
		BigDecimal totalSum = BigDecimal.ZERO;
		List<List<Product>> products=orders.stream().map(Order::getProducts).collect(Collectors.toList());
		List<Product> listProducts = new ArrayList<>(); 
		products.forEach(list -> {
			listProducts.addAll(list);			
		});
		totalSum = listProducts.stream().map(Product::getCost).reduce(BigDecimal.ZERO,
					BigDecimal::add);
		return totalSum;
	}

	@Override
	public void createAndSendOrders(List<Order> orders) {
		orders.forEach(o -> {
			this.save(o);
		});

	}

}
