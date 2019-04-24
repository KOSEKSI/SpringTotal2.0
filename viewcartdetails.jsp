<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,java.util.Collection,java.util.Iterator,shopping.ProductDao,shopping.ProductBean" %>  

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
			  
			    <font size='6'>Welcome,<%=uname %></font>
			    <%


				
				
			    Collection products=(Collection)session.getAttribute("products");
		if(products==null)
		{
			%>
			no products available
			<% 
		}

		else{
			%>		
	<br>your cart details are <br> 
	<table align='center' border='1' cellspacing='5' cellpadding='5'><tr><th>ProductCode</th><th>ProductName</th><th>ProductPrice</th><th>ProductQuantity</th><th>ProductTotal</th></tr> 

	<%
	Iterator i=products.iterator();
	float sum=0;
	while(i.hasNext())
	{
		ProductBean pb=(ProductBean)i.next();
		// product code"+pb.getPCode()+"product name"+pb.getPName()+"product pprice"+pb.getPprice()+"product Quantity"+pb.getPQuantity()+"<br> 
		float price=pb.getPprice()*pb.getPQuantity();
		sum=sum+price;
	%>
		 <tr><td><%=pb.getPCode() %></td><td><%=pb.getPName() %></td><td><%=pb.getPprice() %></td><td><%=pb.getPQuantity() %></td><td><%=price %></td></tr> 
	<%
	}
		%>
		 <tr><td colspan='4'>GrandTotal</td><td><%=sum %></td></tr> 
</table>
 <a href="book">book--></a>
<% 
 
		}
		
			    %>
			   
			    </td>
			    
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
				 
				
				
				
				