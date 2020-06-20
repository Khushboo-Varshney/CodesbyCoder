<jsp:useBean id="mybean" class="mypack.Makepayment"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.makepayment())
		out.println("Payment done Successfully");
	else
		out.println("Payment failed");
%>