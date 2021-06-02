package com.account.service;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.account.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{	
	
}	
