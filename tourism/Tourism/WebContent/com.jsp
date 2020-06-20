<jsp:useBean id="mybean" class="mypack.Complain"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.complain())
		out.println("successfully registered");
	else
		out.println("registration failed");
%>