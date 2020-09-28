package com.emps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyConfigDemo
 */
public class MyConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String cnames = "";
    
	public void init(ServletConfig config) throws ServletException {
	    cnames = config.getInitParameter("cnames");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html><html><head><meta charset=ISO-8859-1>");
		pw.println("<style type=text/css>h1 {background-color: navy;color: white;text-align: center;padding: 20px;}");
		pw.println("table{border-collapse: collapse;border: 2solid blue;}</style></head>");
		pw.println("<body><form action =MyConfigDemo method=POST><h1>Registration Page</h1>");
		pw.println("<table border=1 cellpadding=20px align=center>");
		pw.println("<tr><td>Enter Your Name : </td><td><input type=text size = 20 name =name></td></tr>");
		String str[] = cnames.split(",");
		pw.println("<tr><td>Select Your Course Name: </td><td><select name =cname>");
		for(String x: str) {
			pw.println("<option>"+x+"</option>");
		}
		pw.println("</select></td></tr>");
		pw.println("<tr><td colspan=2 align =center><input type=submit value =Register></td></tr>");
		pw.println("</table></form></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter pw = response.getWriter();
	      
	      String cnames[] = {"Java",".Net","Testing","Python"};  
	      double prices[] = {30000.00,23000.00,12000.00,32000.00};
	      String name = request.getParameter("name");
	      String cname = request.getParameter("cname");
	      int ind = 0;
	      for(int i = 0; i < cnames.length;i++) {
	    	  if(cname.equals(cnames[i])) {
	    		  ind = i;
	    	  }
	    	  
	      }
	      pw.println("<h3 style=color:green> Your Name is = " + name +"<br>");
	      pw.println("Your registered course name is " + cname +"<br>");
	      pw.println("You have to pay the amount of " +prices[ind]+"Rs.. only<br>");
	      pw.println("Thank you very much </h3>");
	      
	      
	}

}
