package com.serviceProviders;

import java.io.FileInputStream;
import java.util.Properties;
import com.services.AccountServices;

//object building method to hide the actual business logic class
public class BusinessObjectProvider 
{
	public static AccountServices provideObject()
	{
		AccountServices obj=null;
		FileInputStream fis=null;
		
		try
		{
			//another way to create object with io streams.
			
			fis = new FileInputStream(".//Resources//AccountInfo.properties" + "");
			Properties p = new Properties();
			p.load(fis);									
			
			String className = p.getProperty("businessClass");
			obj=(AccountServices)Class.forName(className).newInstance();		//object creation
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
		
	}
}