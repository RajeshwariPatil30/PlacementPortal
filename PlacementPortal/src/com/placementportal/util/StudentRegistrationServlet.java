package com.placementportal.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.placementportal.bean.Student;
import com.placementportal.dao.StudentDatabase;

public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StudentRegistrationServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int i=0;
//		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		Student student=new Student();
		
		student.setUsername(username);
		student.setPassword(password);
		student.setEmail(email);
		
		StudentDatabase studentDatabase=new StudentDatabase();
		i= studentDatabase.insert(student);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("loginpage.html");
		dispatcher.include(request, response);

		//		writer.write(i+"Insert record sucessfully");

	}

}
