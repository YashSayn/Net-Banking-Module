package com.Exception;

// Insufficient Balance Exception class

public class InsufficiantBalance extends Exception
{
private String message;
	
	public InsufficiantBalance(String message)
	{
		this.message= message;
	}
	public String toString()
	{
		return "Problem occured due to..."+message;
	}

}
