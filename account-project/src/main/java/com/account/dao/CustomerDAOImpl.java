package com.account.dao;

import java.util.List;
import java.util.logging.Logger;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.account.model.Customer;
import com.account.service.CustomerRepository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	private Logger LOG;
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		ObjectId id = new ObjectId(customerId);
		Customer cust = mongoTemplate.findOne(
				  Query.query(Criteria.where("_id").is(id)), Customer.class);
		if(cust!=null)
			return cust;
		else {
			LOG.info("Customer not found");
			return null;
		}
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void addAccountToCustomer(String accountId, String customerId) {
		ObjectId id = new ObjectId(customerId);
		Customer cust = mongoTemplate.findOne(
				  Query.query(Criteria.where("_id").is(id)), Customer.class);
		
		if(cust!=null) {
			cust.setAccountId(accountId);
			customerRepository.save(cust);
		}else {
			//TODO:End the customer not found exception to calling class
			LOG.info("Customer Record Not found");
		}
		
	}
	
}
