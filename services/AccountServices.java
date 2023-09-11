package com.services;

import com.Exception.InsufficiantBalance;

//business logic methods
public interface AccountServices 
{
	int openAccount(String type, float amount);
	float deposit(int accNo, float amount);
	float withdraw(int accNo, float amount) throws InsufficiantBalance;
	float balEnquiry(int accNo);
	String printAccountDetails(int accNo);
}
