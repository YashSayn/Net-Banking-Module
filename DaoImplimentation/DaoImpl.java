package com.DaoImplimentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bean.Accoun;
import com.dao.DaoInterface;
import com.serviceProviders.DatabaseConnectionProvider;

public class DaoImpl implements DaoInterface
{
	Connection con = DatabaseConnectionProvider.getDBConnection();
	
	// inserting data into the database via MYSQL queries
	
	public void insertData(Accoun acc) 
	{
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into accountData values(?,?,?)");
			pst.setInt(1, acc.getAccNo());
			pst.setString(2, acc.getAccType());
			pst.setFloat(3, acc.getAccBal());
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
