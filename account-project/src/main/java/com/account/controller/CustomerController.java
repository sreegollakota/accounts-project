package com.account.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.dao.CustomerDAO;
import com.account.model.Customer;
import com.account.service.CustomerRepository;

@RestController
@RequestMapping(value = "/")

public class CustomerController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	//@Autowired
	//private final CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDAO customerDao;
	
	/*public CustomerController(CustomerRepository customerRepository) {//,CustomerDAO customerDao) {
		
		this.customerRepository = customerRepository;
		//this.customerDao = customerDao;
	}*/


	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Customer> getAllUsers() {
		LOG.info("Getting all users.");
		//return customerRepository.findAll();
		return customerDao.getAllCustomers();
	}
	//createCustomer
	
	@RequestMapping(value="customer/create",method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer custDetails) {
		LOG.info("Saving Customer Data");
		//return customerRepository.save(custDetails);
		return customerDao.addNewCustomer(custDetails);
	}
	
	@RequestMapping(value="/customer/addAccount",method=RequestMethod.POST)
	public void addAccountToCustomer(@RequestBody String accountId,String customerId) {
		customerDao.addAccountToCustomer(accountId, customerId);
	}
	
	@RequestMapping(value="customer/hi",method=RequestMethod.POST)
	public String sayHi() {
		LOG.info("Saving Customer Data");
		return "Hi!!!";
	}
	
	//addAccountToCustomer

}
