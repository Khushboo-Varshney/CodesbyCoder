<jsp:useBean id="mybean" class="mypack.Makeorder"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.makeorder())
		out.println("Ordered Successfully");
	else
		out.println("Order failed");
%>