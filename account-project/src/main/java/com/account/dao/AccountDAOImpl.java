package com.account.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.account.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	@Override
	public List<Account> getAllAccounts() {
		return mongoTemplate.findAll(Account.class);

	}

	@Override
	public Account getAccountById(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(accountId));
		return mongoTemplate.findOne(query, Account.class);
	}

	@Override
	public Account addAccountToCustomer(@RequestBody Account account,String customerId) {
		// TODO Auto-generated method stub
				Query query = new Query();
				query.addCriteria(Criteria.where("customerId").is(customerId));
		
				mongoTemplate.save(account);
				// Now, user object will contain the ID as well
				return account;
	}
	
	@Override
	public double getBalance(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(accountId));
		Account tmpAccount =  mongoTemplate.findOne(query, Account.class);
		return tmpAccount.getBalance();
	}

}
