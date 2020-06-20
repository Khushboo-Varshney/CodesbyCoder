<%@ page import="java.sql.*" %>
<%          String mode_of_payment=request.getParameter("t1");
			String card_no=request.getParameter("t2");
			String expiry_date=request.getParameter("t3");
			String CVV=request.getParameter("t4");
			response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			PreparedStatement psmt=con.prepareStatement("insert into payment values(?,?,?,?)");
			psmt.setString(1, mode_of_payment);
			psmt.setString(2, card_no);
			psmt.setString(3, expiry_date);
			psmt.setString(4, CVV);
			
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("Payment done successfully");
			
			else
			{
				out.println("Payment Failed");
%>
            <%@include file="payment.html" %>
<%
	}
			%>	
			 
        
    		
			