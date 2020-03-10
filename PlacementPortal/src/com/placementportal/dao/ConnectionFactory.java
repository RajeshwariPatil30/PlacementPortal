package com.placementportal.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String url="jdbc:mysql://localhost:3306/portaldb";
	public static final String username="root";
	public static final String password="root";
	Connection connection;
	
	public ConnectionFactory()
	{
		connection=null;
	}
	public boolean connect() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		if(connection != null)
			return true;
		return false;
	}
	public Connection getConnection()
	{
		return connection;
	}
	public void closeConnection() throws SQLException
	{
		connection.close();
	}
}
