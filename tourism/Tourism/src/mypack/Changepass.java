package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Changepass
 */
//@WebServlet("/Changepass")
public class Changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String name=request.getParameter("t1");
			String pass=request.getParameter("t2");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement psmt=con.prepareStatement("update users set pass='" + pass +"' where name='" + name +"'");
			//psmt.setString(1, name);
			//psmt.setString(2, pass);
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("successfully updated");
			else
				out.println("updation failed");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
