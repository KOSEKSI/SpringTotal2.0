<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%
			    String uname=(String)session.getAttribute("uname1");
				String pass=(String)session.getAttribute("pass1");
						
				if(uname!=null && pass!=null)
				{
				%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShoppingCart</title>
</head>
<body>
 
<table width='100%'height='90%'border='1'> 
			    <tr align='center'> 
			    <td height='39'colspan='2'> 
			    <strong><font size='5'>MyShopping site</font> 
			    </strong> 
			    </tr> 
			    <tr>
				<td width='18%'height='500'valign='top'>
			    <p>&nbsp;</p> 
			    <blockquote><p> 
			    <a href="getProducts"> 
			    </a></p> 
			       <a href="view"> 
			    view products</a></p> 
			    <a href="viewcart"> 
			    View Cart Details</a></p> 
			    <a href="logout"> 
			    Logout</a></p> 
			    </blockquote></td> 
			   
			    <td width='82%' align='left' valign='top'> 
			  
			    <font size='6'>Welcome,<%=uname %></font></td>
			    
			    </tr> 
			    <tr align='center'> 
			    <td colspan='2'> 
			    <em>&copy);Copyrights 2016-17</em></td> 
			    </tr> 
			    </table>
</body>
</html>
<% 
			    }
				else
				{
					%>
				    please login first.....<br/>
				    <%@include file="login.html" %>
				    <% 	
				}
			    %>