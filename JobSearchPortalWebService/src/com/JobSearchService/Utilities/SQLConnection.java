package com.JobSearchService.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection 
{
	public SQLConnection()
	{
		
	}
	
	public static Connection getSQLConnection() throws Exception
	{
		String URL = "jdbc:mysql://localhost:3306/JOBSEARCHPORTAL";
		String USER = "root";
		String PASS = "Soums";
		 Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
    	return conn;
	}
}
