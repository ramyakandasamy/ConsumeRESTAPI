package com.theprogrammerguide.dynamodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.theprogrammerguide.dynamodb.models.Product;
import com.theprogrammerguide.dynamodb.service.ProductService;

@RestController
public class ProductController {
	
	
	private ProductService productservice;
	@Autowired
	public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	 
	
	@RequestMapping(value = "/Product/{pid}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Product> readProduct(@PathVariable String pid) {
		
		logger.info("pid  "+pid);
        try {
        	
        	logger.info("pid aaa "+pid);
            Product response = productservice.readProduct(pid);
            
            logger.info("pid bbb "+pid);
            
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
