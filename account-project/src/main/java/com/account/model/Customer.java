package com.account.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * 	• Name
	• Date of birth
	• Address
	• List of accounts
	• customerId

 */
@Document

public class Customer {
	@Id
	String id;
	Date dateOfBirth;
	String customerName;
	String address;
	String accountId;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", dateOfBirth=" + dateOfBirth + ", customerName=" + customerName
				+ ", address=" + address + ", accountId=" + accountId + ", accounts=" + accounts + "]";
	}
	public String getCustomerId() {
		return id;
	}
	public void setCustomerId(String customerId) {
		this.id = customerId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	List <Account> accounts;

}
