package com.oneclick.ecom.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class DatabaseUtility implements Framework_Constants 
{
	Connection conn;
	
//	public void getDBConnection()
//	{
//		try 
//		{
//			Driver d = new Driver();
//			DriverManager.registerDriver(d);
//			DriverManager.getConnection(url,username,password);
//		} catch (Exception e) {
//		}
//	}
	public void getDBConnection()
	{
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			conn= DriverManager.getConnection(url,username,password);
			//DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza-hrm","root","root");
			                                            //ip add           //name of db
		} catch (Exception e) {
		}
	}
	
	public void closeDBConnection() throws SQLException
	{
		try {
			conn.close();
		} catch (Exception e) {
		}
		
	}
	
	public ResultSet executeSelectQuery(String query)					
	{
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeQuery(query);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public int executeNonSelectQueryy(String query)
	{
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);			
		} catch (Exception e) {
		}
		return result;
	}
	
	
	public List<String> getColoumnData(String query,String coloumnName){
		List<String> data=new ArrayList<>();
		try {
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery(query);
			while(result.next()) {
				data.add(result.getString(coloumnName));
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	 
	
}

