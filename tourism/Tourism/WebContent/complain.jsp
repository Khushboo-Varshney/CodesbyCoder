<%@ page import="java.sql.*" %>
<%          String name=request.getParameter("t1");
			String pass=request.getParameter("t2");
			String complain=request.getParameter("t3");
			response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement psmt=con.prepareStatement("insert into complain values(?,?,?)");
			psmt.setString(1, name);
			psmt.setString(2, pass);
			psmt.setString(3, complain);
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("register complain successfully");
			else
			{
				out.println("Registration of complain failed");
%>
            <%@include file="complain.html" %>
<%
	}
%>