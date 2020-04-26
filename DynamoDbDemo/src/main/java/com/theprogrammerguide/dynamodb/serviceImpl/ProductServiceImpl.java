package com.theprogrammerguide.dynamodb.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theprogrammerguide.dynamodb.controllers.ProductController;
import com.theprogrammerguide.dynamodb.dao.ProductDao;
import com.theprogrammerguide.dynamodb.models.Product;
import com.theprogrammerguide.dynamodb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductDao  productDao;
	
	@Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Override
	public Product readProduct(String pid) {
		// TODO Auto-generated method stub
		
		logger.info("pid  ProductServiceImpl"+pid);
		return productDao.readProduct(pid);
	}

}
