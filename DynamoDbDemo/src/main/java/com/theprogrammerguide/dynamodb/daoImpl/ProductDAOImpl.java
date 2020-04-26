package com.theprogrammerguide.dynamodb.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.theprogrammerguide.dynamodb.controllers.ProductController;
import com.theprogrammerguide.dynamodb.dao.ProductDao;
import com.theprogrammerguide.dynamodb.models.Product;

@Repository
public class ProductDAOImpl implements ProductDao {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	public ProductDAOImpl(DynamoDBMapper dynamoDBMapper) {

		logger.info("ProductDAOImpl aa ");
		this.dynamoDBMapper = dynamoDBMapper;
	}

	@Override
	public Product readProduct(String pid) {

		logger.info("ProductDAOImpl " + pid);
		logger.info("dynamo " + dynamoDBMapper.load(Product.class, pid));

		return dynamoDBMapper.load(Product.class, pid);

	}

}
