package com.account.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transactions {
	String transacionType;//Cr/Dr
	Date dateofTransaction;
	String details;
	double amount;
	String currency;
	public String getTransacionType() {
		return transacionType;
	}
	public void setTransacionType(String transacionType) {
		this.transacionType = transacionType;
	}
	public Date getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(Date dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	String from;
	String to;

}
