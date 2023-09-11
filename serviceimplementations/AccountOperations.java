package com.serviceimplementations;

import com.DaoImplimentation.DaoImpl;
import com.Exception.InsufficiantBalance;
import com.Exception.InvalidAccountNoException;
import com.bean.Accoun;
import com.services.AccountServices;

public class AccountOperations implements AccountServices 
{
	private Accoun acc;
	DaoImpl dao = new DaoImpl();
	
	public int openAccount(String type, float amount) 
	{
		acc = new Accoun(type, amount);
		
		//put data into the database
		
		dao.insertData(acc);
		return acc.getAccNo();
	}

	// validation method
	
	public boolean validateAccNo(int accNo) throws InvalidAccountNoException
	{
		boolean val = false;
		
		if(acc.getAccNo()==accNo)
		{
			val = true;
			
		}
		else
		{
			throw new InvalidAccountNoException("Incorrect Account Number ...");
			
		}
		return val;
	}
	
	//deposit method
	
	public float deposit(int accNo, float amount) 
	{
		float upBal = 0;
		try
		{
			if(validateAccNo(accNo))
			{
				acc.setAccBal(acc.getAccBal()+amount);
				upBal = acc.getAccBal();
				System.out.println("The Balance after Deposite is : " +upBal);
			}
			else
			{
				System.out.println("Invalid Account Number..... Please try again");
				upBal = 0.0f;
			}
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}
		return upBal;
	}

	// withdraw method
	
	public float withdraw(int accNo, float amount)throws InsufficiantBalance 
	{
		float upBal = 0;
		try
		{
		
			if(validateAccNo(accNo))
			{
				acc.setAccBal(acc.getAccBal()-amount);
				upBal = acc.getAccBal();
				 
				System.out.println("The Balance after withdraw is : " +upBal);
				
				
					if(upBal >1150000)
					{
						System.out.println("Account have sufficiant balance");
					}
					else
					{
						throw new InsufficiantBalance("Account have insufficiant balance");
					}
			}
			else
			{
				System.out.println("Invalid Account Number..... Please try again");
				upBal = 0.0f;
			}
		}
			catch(InvalidAccountNoException e)
			{
				e.printStackTrace();
			}
		
		return upBal;
		
	}

	// balance enquiry method
	
	public float balEnquiry(int accNo) 
	{
		try
		{
			if(validateAccNo(accNo))
			{
				acc.getAccBal();
			
				System.out.println("The total balance in the account is : " +acc.getAccBal());
			}
			else
			{
				System.out.println("Invalid Account Number..... Please try again");
			
			}
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}
		
		return acc.getAccBal();
		
	}

	//printing account details 
	
	public String printAccountDetails(int accNo) 
	{
		String accData = null;
		try 
		{
			if(validateAccNo(accNo))
			{
				accData = acc.toString();
			}
			else
			{
				accData = "Invalid Account Number....please try again";
			}
		}
		catch(InvalidAccountNoException e)
		{
			e.printStackTrace();
		}
		return accData;
	}
	

}
