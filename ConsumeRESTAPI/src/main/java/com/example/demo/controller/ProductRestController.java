package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Product;

@RestController
public class ProductRestController {

	private static final Logger log = LoggerFactory.getLogger(ProductRestController.class);

	@Value("${endpoint}")
	String endpoint;

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/getProducts")
	public Product getProductDetails() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		log.info("endpoint " + endpoint);
		Product productFound = restTemplate.exchange(endpoint, HttpMethod.GET, entity, Product.class).getBody();

		return productFound;
	}

}
