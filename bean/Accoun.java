package com.bean;

//java bean data
public class Accoun {

	private int accNo;
	private String accType;
	private float accBal;
	private static int series = 1;
	
	
	public Accoun(String accType, float accBal)
	{
		accNo =series;
		series++;
		this.accType=accType;
		this.accBal=accBal;
	}
	
	// setter methods
	
	public void setAccNo(int accNo)
	{
		this.accNo=accNo;
	}
	
	public void setAccType(String accType)
	{
		this.accType=accType;
	}
	
	public void setAccBal(float accBal)
	{
		this.accBal=accBal;
	}
	
	//getter methods
	
	public int getAccNo()
	{
		return accNo;
	}
	
	public String getAccType()
	{
		return accType;
	}
	
	public float getAccBal()
	{
		return accBal;
	}
	
	
	// toString method
	
	public String toString()
	{
		return "Information about Account is : " +accNo+ " / " +accType+ " / " +accBal;
	} 
	
	

}
