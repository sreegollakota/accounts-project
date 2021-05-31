package com.account.service;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.account.model.Account;

//@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")

public interface AccountRepository extends MongoRepository<Account, String>{	

}	
