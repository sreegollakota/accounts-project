package com.account.customer.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.account.model.Customer;

@Repository
//RestResource(collectionResourceRel = "customers", path = "customers")

public interface CustomerRepository extends MongoRepository<Customer, String>{	


	//Customer getCustomerById(String customerId);

	//Customer addNewCustomer(Customer customer);
	
	//void addAccountToCustomer(String accountId,String customerId);
	
}	
