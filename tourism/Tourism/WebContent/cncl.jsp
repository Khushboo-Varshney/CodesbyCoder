<%@ page import="java.sql.*" %>
<%      
try{
			String contact_no=request.getParameter("t1");
			response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/mysql");
			Statement st=con.createStatement();
            int i=st.executeUpdate("DELETE FROM orders WHERE contact_no="+ contact_no);
            out.println("Your order is cancelled");
            }

                  catch(Exception e)
                   {
                   System.out.print(e);
                    e.printStackTrace();
%>
            <%@include file="cncl.html" %>
<%
	}
			%>	
