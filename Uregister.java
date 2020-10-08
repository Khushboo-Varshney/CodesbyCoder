package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Uregister
 */
//@WebServlet("/Uregister")
public class Uregister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String name=request.getParameter("t1");
			String email=request.getParameter("t2");
			String password=request.getParameter("t3");
			String pswrepeat=request.getParameter("t4");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement psmt=con.prepareStatement("insert into curegi values(?,?,?,?)");
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setString(3, password);
			psmt.setString(4, pswrepeat);
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("<i><b>Successfully registered</i></b>");
			else
				out.println("<i>Registration failed</i>");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}

}
