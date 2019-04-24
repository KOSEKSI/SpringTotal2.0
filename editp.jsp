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
		 
		 <table border='1' align='center' cellpadding="5" cellspacing="10"><tr><th>PCode</th><th>PName</th><th>PPrice</th><th>PQuantity</th></tr> 
		<%
		Iterator i=products.iterator();
		while(i.hasNext()){
			ProductBean pb=(ProductBean)i.next();
			int pr=(int)pb.getPprice();
			 %>
			 <form method="post" action="editproducts"> 
			 <tr> 
			 <td><%=pb.getPCode() %><input type="hidden" name="pc" value="<%=pb.getPCode() %>"> </td>
			 <td><input type="text" name="pn" value="<%=pb.getPName() %>"></td>
			 <td><input type="text" name="pp" value="<%=pr%>"></td> 
			 <td><input type="text" name="pq" value="<%=pb.getPQuantity() %>"></td>
			 <td><input type="submit" value="edit"></td> 
			 </tr>
			 </form>			
		<% 
			
		}
		%>
		 </table> 
		 
		 
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
				    <%@include file="admin.html" %>
				    <% 	
				}
			    %>
				 
				
				
				
				