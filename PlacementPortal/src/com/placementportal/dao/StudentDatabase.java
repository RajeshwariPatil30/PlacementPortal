package com.placementportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.placementportal.bean.Student;


public class StudentDatabase {
	
	public int insert(Student student) {
		int i=0;
		String sql="INSERT INTO test (username,password,email) VALUES (?,?,?)";
		try {
			ConnectionFactory factory=new ConnectionFactory();
			factory.connect();
			Connection connection= factory.getConnection();
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1,student.getUsername());
			stmt.setString(2,student.getPassword());
			stmt.setString(3,student.getEmail());
			i=stmt.executeUpdate();
			return i;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
		
	}

	public Student checkvalid(String username,String password) throws ClassNotFoundException, SQLException
	{
		ConnectionFactory factory=new ConnectionFactory();
		factory.connect();
		Connection con= factory.getConnection();
		
		Student student=null;
		ResultSet rs=null;
		String query="select * from test where username=? and password=?";
		
		PreparedStatement statement=con.prepareStatement(query);
		statement.setString(1,username);
		statement.setString(2,password);
		
		rs=statement.executeQuery();
		if(rs != null)
		{
			try
			{
		      rs.next();
	
			String user=rs.getString("username");
			String pass=rs.getString("password");
						
			student=new Student();
			student.setUsername(username);
			student.setPassword(password);
		
			if(student.getUsername().equals(user) && student.getPassword().equals(pass))
			{
				con.close();
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		}
		return student;
		
		
	}
}
