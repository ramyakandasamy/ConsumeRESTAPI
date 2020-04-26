package com.theprogrammerguide.dynamodb.dao;

import org.springframework.stereotype.Repository;

import com.theprogrammerguide.dynamodb.models.Product;

@Repository
public interface ProductDao {

	public Product readProduct(String userId);

}
