package com.account.dao;

import com.account.model.Account;

public interface AccountDAO {

	Account addAccountToCustomer(Account account,String customerId);
	
	double getBalance(String accountId);
	
	Account save(Account acct);

}
