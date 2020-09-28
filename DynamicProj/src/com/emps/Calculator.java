package com.emps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html><head><meta charset=ISO-8859-1><title>Insert title here</title><style type=text/css>");
		pw.println("h1 {background-color: navy;	color: white;text-align: center;padding: 20px;    }  table{");
		pw.println(" border-collapse: collapse; border: 2solid blue; } </style></head>");
		pw.println(" <body> <form action =Calculator method = POST >");
		pw.println(" <h1> Calculator Application</h1>");
		pw.println("<table border=1 cellpadding=20px align=center>");
		pw.println("<tr><td>Enter First Number : </td><td><input type=text size = 20 name =firstNum></td></tr>");
	    pw.println("<tr><td>Enter Second Number : </td><td><input type=text size = 20 name =secNum></td></tr>");
		pw.println("<tr><td colspan=2 align =center><input type=submit value =ADD name =b1>"
				+ "<input type=submit value =SUB name = b1><input type=submit value =MUL name =b1></td></tr>");
		pw.println("</table>   </form>	</body>	</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		double firstNum = Double.parseDouble(request.getParameter("firstNum"));
		double secNum =  Double.parseDouble(request.getParameter("secNum"));
		String  event = request.getParameter("b1");
		if(event.equals("ADD")) {
			
			
			pw.println("<h1 style =color :green;>SUM : <input type = text value = "+ (firstNum + secNum)+"></h1>");
		}
		else if(event.equals("SUB")) {
			pw.println("<h1 style =color :green;>SUB : "+(firstNum - secNum)+"</h1>");
		}
		else {
			pw.println("<h1 style =color :green;>PRODUCT : "+(firstNum * secNum)+"</h1>");
		}
		
	}

}
