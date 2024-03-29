package com.javawiz;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javawiz.entity.Product;
import com.javawiz.repository.ProductRepository;

@SpringBootApplication
public class SbH2OracleApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SbH2OracleApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SbH2OracleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner employee(ProductRepository repository) {
		return (args) ->{
			Product product = new Product();
			product.setProductId("1234");
	        product.setDescription("Spring Framework Guru Shirt");
	        product.setPrice(new BigDecimal("18.95"));
	        repository.save(product);
	        
	        Product fetchedProduct = repository.findById(product.getId()).get();
	        logger.debug("{}", fetchedProduct);
	        
	        //update description and save
	        fetchedProduct.setDescription("New Description");
	        repository.save(fetchedProduct);
	        
	      //get from DB, should be updated
	        Product fetchedUpdatedProduct = repository.findById(fetchedProduct.getId()).get();
	        logger.debug("{}", fetchedUpdatedProduct);
	        
	        //verify count of products in DB
	        long productCount = repository.count();
	        logger.debug("{}", productCount);
	        
			repository.findAll().stream().forEach(data -> {
				logger.debug("{}", data);
			});
		};
	}
}
