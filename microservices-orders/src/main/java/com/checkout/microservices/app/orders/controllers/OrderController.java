package com.checkout.microservices.app.orders.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arenasoccer.mircroservices.commons.controllers.CommonController;
import com.checkout.commons.models.entity.Product;
import com.checkout.microservices.app.orders.models.entity.Order;
import com.checkout.microservices.app.orders.services.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Orders microservice", description = "This API has a CRUD for orders")
public class OrderController extends CommonController<Order, OrderService> {

	
	
	@PostMapping("/checkout")
	@ApiOperation(value = "Checkout the order", notes = "trigger the bill service and logistic order service")
	public ResponseEntity<?> checkout(@RequestBody List<Order> orders) {
		BigDecimal totalSum=this.service.billSumAllProducts(orders);
		this.service.createAndSendOrders(orders);
		return ResponseEntity.status(HttpStatus.CREATED).body(totalSum);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Edit order", notes = "Update order by Id")
	public ResponseEntity<?> edit(@RequestBody Order order, @PathVariable Long id) {
		Optional<Order> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Order dbOrder = o.get();
		dbOrder.setDirection(order.getDirection());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbOrder));

	}

	@PutMapping("/{id}/assign-products")
	@ApiOperation(value = "Assign Product", notes = "Assign a List of products to the order")
	public ResponseEntity<?> assignProducts(@RequestBody List<Product> products, @PathVariable Long id) {
		Optional<Order> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Order dbOrder = o.get();
		products.forEach(p -> {
			dbOrder.addProduct(p);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbOrder));
	}

	@PutMapping("/{id}/delete-product")
	@ApiOperation(value = "Delete Product", notes = "Delete a product from the order")
	public ResponseEntity<?> deleteProduct(@RequestBody Product product, @PathVariable Long id) {
		Optional<Order> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Order dbOrder = o.get();
		dbOrder.removeProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbOrder));
	}

}
