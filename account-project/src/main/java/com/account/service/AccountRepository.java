package com.account.service;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.account.model.Account;

public interface AccountRepository extends MongoRepository<Account, String>{	

}	
