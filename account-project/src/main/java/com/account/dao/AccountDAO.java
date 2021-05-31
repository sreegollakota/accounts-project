package com.account.dao;

import java.util.List;

import com.account.model.Account;

public interface AccountDAO {

	List<Account> getAllAccounts();

	Account getAccountById(String accountId);

	Account addAccountToCustomer(Account account,String customerId);
	
	double getBalance(String accountId);

}
