package com.account.dao;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.account.model.Account;
import com.account.service.AccountRepository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public Account addAccountToCustomer(@RequestBody Account account,String customerId) {
				Query query = new Query();
				query.addCriteria(Criteria.where("customerId").is(customerId));
		
				accountRepo.save(account);
				return account;
	}
	
	@Override
	public double getBalance(String accountId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(new ObjectId(accountId)));
		Account tmpAccount = mongoTemplate.findOne(query,Account.class);
		if(tmpAccount!=null) 
			return tmpAccount.getBalance();
		else
			return 0;
	}

	@Override
	public Account save(Account acct) {
		return accountRepo.save(acct);
	}

}
