<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,java.util.Collection,java.util.Iterator,shopping.ProductDao,shopping.ProductBean" %>  

 <%
			    String uname=(String)session.getAttribute("aduser");
				String pass=(String)session.getAttribute("adpass");
						
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
			       <a href="viewproducts2.jsp"> 
			    view products</a></p>
			    <a href="addp.jsp"> 
			    Add products</a></p> 
			    <a href="editp.jsp"> 
			    editproducts</a></p> 
			    <a href="delp.jsp"> 
			    delete products</a></p>
			    <a href="logout2"> 
			    Logout</a></p> 
			    </blockquote></td> 
			   
			    <td width='82%' align='left' valign='top'> 
			  
			    <font size='6'>Welcome,<%=uname %></font>
			    <%


				
				ProductDao pb2=new ProductDao();
		Collection products=pb2.getProducts();
		if(products==null)
		{
			%>
			no products available
			<% 
		}

		else{
			%>
				<br><h2>List of products</h2>  
		 <form method="post" action="delpro"> 
		 <table border='1' align='center'><tr><th>Click</th><th>PCode</th><th>PName</th><th>PPrice</th><th>PQuantity</th></tr> 
		<%
		Iterator i=products.iterator();
		while(i.hasNext()){
			ProductBean pb=(ProductBean)i.next();
			 %>
			 <tr><td><input type="checkbox" name="products" value="<%=pb.getPCode() %>"></td> 
			 <td><%=pb.getPCode() %></td><td><%=pb.getPName() %></td><td><%=pb.getPprice()%></td> 
			 <td><%=pb.getPQuantity() %></td> 
						
		<% 
			
		}
		%>
		 </table> 
		 <center><input type="submit" value="Delete"><center> 
		 <form> 
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
				 
				
				
				
				