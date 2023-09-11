package com.client;

import java.util.Scanner;

import com.Exception.InsufficiantBalance;
import com.serviceProviders.BusinessObjectProvider;
import com.services.AccountServices;

public class ClientCode 
{

	public static void main(String[] args) 
	{
		
		//object from business object provider class
		
		try {
			AccountServices accountServices = BusinessObjectProvider.provideObject();
			
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the account type of your choice....");
			String accType = scanner.next();
			
			System.out.println("Please enter the amount you want to enter in the account....");
			float amount = scanner.nextFloat();
			
			System.out.println("Please enter the amount you want to deposite in the account....");
			float depositeAmount = scanner.nextFloat();
			
			System.out.println("Please enter the amount you want to withdraw from the account....");
			float withdrawAmount = scanner.nextFloat();
			
			int accNo = accountServices.openAccount(accType, amount);
			System.out.println("Account opened with accNo "+accNo);
			
			String accDetails = accountServices.printAccountDetails(accNo);
			System.out.println(accDetails);
			
			float depositeDetails = accountServices.deposit(accNo, depositeAmount);
			System.out.println(depositeDetails);
			
			float withdrawalDetails = accountServices.withdraw(accNo, withdrawAmount);
			System.out.println(withdrawalDetails);
			
			float currentBalanceDetails = accountServices.balEnquiry(accNo);
			System.out.println(currentBalanceDetails);
			
			}
		catch(InsufficiantBalance e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}

