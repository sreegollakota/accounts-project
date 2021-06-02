package com.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.dao.AccountDAO;
import com.account.model.Account;

@RestController
public class AccountController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private  AccountDAO accountDao;
		
//	public AccountController(AccountRepository accountRepository) {//,AccountDAO accountDao) {
//		
//		this.accountRepository = accountRepository;
//	}
	
	@RequestMapping(value="account/create",method=RequestMethod.POST)
	public Account creatNewAccount(@RequestBody Account accountDetails) {
		LOG.info("Saving Account Data");
		return accountDao.save(accountDetails);
	}
	//• addAccount(customerID)
	//• getAccountBalance
	@RequestMapping(value="account/balance",method=RequestMethod.POST)
	public double getAccountBalance(@PathVariable String accountId) {
		return  accountDao.getBalance(accountId);
			
	}
	
}
