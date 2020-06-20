<%@ page import="java.sql.*" %>
<%          String name=request.getParameter("t1");
			String contact_no=request.getParameter("t2");
			String address=request.getParameter("t3");
			String email=request.getParameter("t4");
			String tour_name=request.getParameter("t5");
			response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement psmt=con.prepareStatement("insert into orders values(?,?,?,?,?)");
			psmt.setString(1, name);
			psmt.setString(2, contact_no);
			psmt.setString(3, address);
			psmt.setString(4, email);
			psmt.setString(5, tour_name);
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("Ordered successfully");
			
			else
			{
				out.println("Order failed");
%>
            <%@include file="MakeOrder.html" %>
<%
	}
			%>	
			 <%
        String redirectURL = "http://localhost:8081/Tourism/payment.html";
        response.sendRedirect(redirectURL);
    %>		
			