package com.checkout.mircroservices.app.products.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arenasoccer.mircroservices.commons.controllers.CommonController;
import com.checkout.commons.models.entity.Product;
import com.checkout.mircroservices.app.products.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Products microservice", description = "This API has a CRUD for products")
public class ProductController extends CommonController<Product, ProductService> {

	@PutMapping("/{id}")
	@ApiOperation(value = "Update a product", notes = "Update a product by Id")
	public ResponseEntity<?> edit(@RequestBody Product product, @PathVariable Long id) {
		Optional<Product> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Product productDb = o.get();
		productDb.setName(product.getName());
		productDb.setQuantity(product.getQuantity());
		productDb.setCost(product.getCost());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
	}

}
