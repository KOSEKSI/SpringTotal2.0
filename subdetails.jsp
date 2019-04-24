<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="shopping.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShoppingCart</title>
</head>
<body>
<%
UserBean us=(UserBean)application.getAttribute("usreg");

%>
You are submitted details are ----><br>
<table align="left">
<tr>
	<td>UserName</td>
	<td><%=us.getUname() %></td>
</tr>
<tr>
	<td>Password</td>
	<td><%=us.getPass() %></td>
</tr>
<tr>
	<td>FirstName</td>
	<td><%=us.getFname() %></td>
</tr>
<tr>
	<td>SecondName</td>
	<td><%=us.getSname() %></td>
</tr>
<tr>
	<td>Address</td>
	<td><%=us.getAddr() %></td>
</tr>
<tr>
	<td>Phone</td>
	<td><%=us.getPhone() %></td>
</tr>
<tr>
	<td>Email</td>
	<td><%=us.getMail() %></td>
</tr>
<tr>
	<td><a href="register" >Register</a></td>
	<td></td>
</tr>
</table>

</body>
</html>