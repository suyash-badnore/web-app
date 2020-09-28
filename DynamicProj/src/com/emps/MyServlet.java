package com.emps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends GenericServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method gets exectued");
	}

	public void destroy() {
		System.out.println("Destroy method gets executed");
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html");
	      PrintWriter pw = response.getWriter();
	      pw.println("<h1 style=background-color:maroon;color:white;padding:20px;text-align:center;>"
	      		+ "Welcome to Web Technologies</h1>");
	      pw.close();
	      
	}

}
