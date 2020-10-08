package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class AdLoginServlet
 */
//@WebServlet("/AdLoginServlet")
public class AdLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		String pass=request.getParameter("t2");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			PreparedStatement psmt=(PreparedStatement) con.prepareStatement("select * from users where name=? and password=?");
			psmt.setString(1,name);
			psmt.setString(2, pass);
			ResultSet rs=(ResultSet) psmt.executeQuery();
			RequestDispatcher rd=null;
			if(rs.next())
			{
				String role=rs.getString(1);
				request.setAttribute("client",role);
				rd=request.getRequestDispatcher("/welcome");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("adlogin.html");
				out.println("invalid user name & password");
				rd.include(request, response);
			}
		}catch(Exception e)
		{
			System.out.println(e);
	}

}
}
