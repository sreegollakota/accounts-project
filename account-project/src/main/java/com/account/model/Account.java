package com.account.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * 	• Start date
	• Balance
	• List Transactions
	• Product type / current and saving
accountId
 */

@Document
public class Account {
	@Id
	private String accountId;
	private Date startDate;
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", startDate=" + startDate + ", balance=" + balance
				+ ", productType=" + productType + ", transactions=" + transactions + "]";
	}
	private double balance;
	private String productType;
	private Map<String,String> transactions;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Map<String,String> getTransactions() {
		return transactions;
	}
	public void setTransactions(Map<String,String> transactions) {
		this.transactions = transactions;
	}
	
	

}
