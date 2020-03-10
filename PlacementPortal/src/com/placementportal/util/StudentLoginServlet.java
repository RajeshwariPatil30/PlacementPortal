package com.placementportal.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.placementportal.bean.Student;
import com.placementportal.dao.StudentDatabase;

public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentLoginServlet() {
        super();
      }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 	{

		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		StudentDatabase studentDatabase = new StudentDatabase();

		try {
			Student user= studentDatabase.checkvalid(username, password);
			if(user == null)
			{
				System.out.println("user = "+user);
				response.sendRedirect("loginpage.html");
			}
			else
			{
				System.out.println(username);
				System.out.println(password);
				response.sendRedirect("profilepage.html");
//				HttpSession session=request.getSession();
//				session.setAttribute("user", user);
//				if(user.getRole().equalsIgnoreCase("manager"))
//				{
//					RequestDispatcher rd=request.getRequestDispatcher("navbarmgr.jsp");
//					rd.forward(request, response);
//				}
//				if(user.getRole().equalsIgnoreCase("employee"))
//				{
//					RequestDispatcher rd=request.getRequestDispatcher("navbaremp.jsp");
//					rd.forward(request, response);
//					
//				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
