package com.account.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.dao.CustomerDAO;
import com.account.model.Customer;

@RestController
@RequestMapping(value = "/")

public class CustomerController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerDAO customerDao;
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Customer> getAllUsers() {
		LOG.info("Getting all users.");
		return customerDao.getAllCustomers();
	}
	
	@RequestMapping(value="customer/create",method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer custDetails) {
		LOG.info("Saving Customer Data");
		return customerDao.addNewCustomer(custDetails);
	}
	
	@RequestMapping(value="/customer/addAccount",method=RequestMethod.POST)
	public void addAccountToCustomer(@RequestBody Map<String, String> json) {
		
		String accountId, customerId;
		accountId =json.get("accountId");
		customerId = json.get("customerId");
		customerDao.addAccountToCustomer(accountId, customerId);
	}
	
}
