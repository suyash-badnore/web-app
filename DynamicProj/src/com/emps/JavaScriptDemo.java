package com.emps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaScriptDemo
 */
public class JavaScriptDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaScriptDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter pw = response.getWriter();
	      String name = request.getParameter("s1");
	      if(name.equals("Andrapradesh")) {
	    	  
	    	  pw.println("<h2>Your selected state is "+name +"</h2>");
	    	  pw.println("<h2>Capital = Amaravathi</h2>");
	    	  
	      }
	      else if(name.equals("Telangana")) {
	    	  pw.println("<h2>Your selected state is "+name +"</h2>");
	    	  pw.println("<h2>Capital = Hyderabad</h2>");
	      }
	      
	      
	      
	}

}
