package com.checkout.mircroservices.app.products.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.checkout.commons.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
