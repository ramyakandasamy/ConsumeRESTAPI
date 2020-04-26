package com.theprogrammerguide.dynamodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.theprogrammerguide.dynamodb.controllers.ProductController;

@Configuration
public class DynamoDBConfiguration {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Bean
    public DynamoDBMapper dynamoDBMapper() {
		
		
		//AmazonDynamoDB client1 = AmazonDynamoDBClientBuilder.standard().build();
		logger.info("DynamoDBConfiguration ");
		
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("access id", "key")))
                .withRegion(Regions.US_EAST_1)
                .build();
        logger.info("DynamoDBConfiguration "+client);
        
        return new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
    }

}
