package com.account.dao;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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
	
	@Autowired
	private MongoTemplate mongoTemplate;

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
		ObjectId id = new ObjectId(customerId);
		Customer cust = mongoTemplate.findOne(
				  Query.query(Criteria.where("_id").is(id)), Customer.class);
		
		if(cust!=null) {
			cust.setAccountId(accountId);
			customerRepository.save(cust);
		}else {
			System.out.println("Customer Record Not found");
		}
		
	}
	
}
