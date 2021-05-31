package com.account.dao;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.account.model.Account;
import com.account.service.AccountRepository;
import com.account.service.CustomerRepository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();

	}

	@Override
	public Account getAccountById(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(accountId));
		return null;
	}

	@Override
	public Account addAccountToCustomer(@RequestBody Account account,String customerId) {
		// TODO Auto-generated method stub
				Query query = new Query();
				query.addCriteria(Criteria.where("customerId").is(customerId));
		
				accountRepo.save(account);
				// Now, user object will contain the ID as well
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

}
