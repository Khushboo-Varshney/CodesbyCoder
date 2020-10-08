package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcomeservlet
 */
//@WebServlet("/Welcomeservlet")
public class Welcomeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String role=(String)request.getAttribute("client");
		RequestDispatcher rd=null;
		if(role.equals("admin"))
			out.println("<h1>Welcome: </h1>"+role);
		else
			out.println("<h1>Welcome: </h1>"+role);
		rd=request.getRequestDispatcher("UserPortal.html");
		rd.forward(request, response);
	}

}
