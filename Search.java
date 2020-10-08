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
 * Servlet implementation class Search
 */
//@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String Subject=request.getParameter("t2");
			//String pass=request.getParameter("t2");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			  PreparedStatement ps=con.prepareStatement("select * from email where Subject=?");

              ps.setString(1,Subject);                   

              out.print("<table width=25% border=1>");

              out.print("<center><h1>View email:</h1></center>");

              ResultSet rs=ps.executeQuery();                

              /* Printing column names */

              ResultSetMetaData rsmd=rs.getMetaData();

              while(rs.next())

                 {

              out.print("<tr>");

              out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                 out.print("<td>"+rs.getString(1)+"</td></tr>");

                 out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

                 out.print("<td>"+rs.getString(2)+"</td></tr>");

                 out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

                 out.print("<td>"+rs.getString(3)+"</td></tr>");

                
              }

              out.print("</table>");



       }catch (Exception e2)

         {

             e2.printStackTrace();

         }



       finally{
    	   //out.close();

         }

	}

}
