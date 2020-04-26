package com.theprogrammerguide.dynamodb.service;

import org.springframework.stereotype.Service;

import com.theprogrammerguide.dynamodb.models.Product;

@Service
public interface ProductService {

	Product readProduct(String pid);

}
