package com.checkout.mircroservices.app.products.services;

import org.springframework.stereotype.Service;

import com.arenasoccer.mircroservices.commons.services.CommonServiceImpl;
import com.checkout.commons.models.entity.Product;
import com.checkout.mircroservices.app.products.models.repository.ProductRepository;

@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, ProductRepository> implements ProductService {

}
