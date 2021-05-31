package com.account.dao;

import java.util.List;
import java.util.Optional;

import com.account.model.Account;
import com.account.model.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomers();

	Customer getCustomerById(String customerId);

	Customer addNewCustomer(Customer customer);
	
	void addAccountToCustomer(String accountId,String customerId);


	
}
