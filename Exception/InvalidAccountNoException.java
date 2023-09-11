package com.Exception;

// Invalid Account No Exception Class

public class InvalidAccountNoException extends Exception
{
private String messagee;
	
	public InvalidAccountNoException(String messagee)
	{
		this.messagee=messagee;
	}
	public String toString()
	{
		return "Problem occured due to..." +messagee;
	}

}
