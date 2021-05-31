package com.account.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.account.model.Account;
import com.account.model.Customer;
import com.account.service.CustomerRepository;

@Repository
//@Service
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		// TODO Auto-generated method stub
		//return customerRepository.findById(customerId);
		return null;
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void addAccountToCustomer(String accountId, String customerId) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Customer.class);
	}

	@Override
	public Customer getCustomerById(String customerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(customerId));
		return mongoTemplate.findOne(query, Customer.class);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		mongoTemplate.save(customer);
		// Now, user object will contain the ID as well
		return customer;
	}
	
	@Override
	public void addAccountToCustomer(@RequestBody String accountId,String customerId) {
		
	    Query query = new Query();
	    Query firstGreatCmts = Query.query(Criteria.where("customerId").is(customerId));
		mongoTemplate.updateFirst(firstGreatCmts, Update.update("accountId", accountId), Customer.class);
		
	}
	*/
}
