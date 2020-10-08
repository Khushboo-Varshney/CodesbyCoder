package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewuserServlet
 */
//@WebServlet("/ViewuserServlet")
public class ViewuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String name=request.getParameter("t1");
			//String pass=request.getParameter("t2");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement ps=con.prepareStatement("select * from users where name=?");  
			ps.setString(1,name);  
			              
			out.print("<table width=50% border=1>");  
			out.print("<caption>View Users:</caption>");  
			  
			ResultSet rs=ps.executeQuery();  
			              
			/* Printing column names */  
			ResultSetMetaData rsmd=rs.getMetaData();  
			int total=rsmd.getColumnCount();  
			out.print("<tr>");  
			for(int i=1;i<=total;i++)  
			{  
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
			}  
			  
			out.print("</tr>");  
			              
			/* Printing result */  
			  
			while(rs.next())  
			{  
			out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>");  
			                  
			}  
			  
			out.print("</table>");  
			              
			}catch (Exception e2) {e2.printStackTrace();}
	}

}
