package shopping;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;
public class ViewProductsServlet extends HttpServlet {
	public Collection products;
	public void init() throws ServletException
	{
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs==null){
			pw.println("please login first");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
		String uname=(String) hs.getAttribute("uname1");
		
		pw.println("<html><head>");
		   pw.println("<title>Shopping cart Example</title>");
		   pw.println("</head><body>");
		   pw.println("<table width='100%'height='90%'border='1'>");
		   pw.println("<tr align='center'>");
		   pw.println("<td height='39'colspan='2'>");
		   pw.println("<strong><font size='5'>MyShopping site</font>");
		   pw.println("</strong>");
		   pw.println("</tr>");
		   pw.println("<tr>");
		   pw.println("<td width='18%'height='500'valign='top");
		   pw.println("<p>&nbsp;</p>");
		   pw.println("<blockquote><p>");
		   pw.println("<a href='"+res.encodeURL("getProducts")+"'>");
		   pw.println("</a></p>");
		      pw.println("<a href='"+res.encodeURL("view")+"'>");
		   pw.println("view products</a></p>");
		   pw.println("<a href='"+res.encodeURL("viewcart")+"'>");
		   pw.println("View Cart Details</a></p>");
		   pw.println("<a href='"+res.encodeURL("logout")+"'>");
		   pw.println("Logout</a></p>");
		   pw.println("</blockquote></td>");
		   
		   pw.println("<td width='82%' align='left' valign='top'>");
		   pw.println("<font size='6'>Welcome,"+uname+"</font>");
		ProductDao pb2=new ProductDao();
		Collection products=pb2.getProducts();
		if(products==null)
		{
			pw.println("<br>no products available");
		}
		else
		{
		pw.println("<br><h2>List of products</h2> ");
		pw.println("<form method='Post' action='store'>");
		pw.println("<table border='1' align='center'><tr><th>Click</th><th>PCode</th><th>PName</th><th>PPrice</th><th>PQuantity</th><th>RequiredQuantity</th></tr>");
		Iterator i=products.iterator();
		while(i.hasNext()){
			ProductBean pb=(ProductBean)i.next();
			pw.println("<tr><td><input type='checkbox' name='products' value='"+pb.getPCode()+"'></td>");
			pw.println("<td>"+pb.getPCode()+"</td><td>"+pb.getPName()+"</td><td>"+pb.getPprice()+"</td>");
			pw.println("<td>"+pb.getPQuantity()+"</td>");
			pw.println("<td><input type='text' name='"+pb.getPCode()+"'></td></tr>");
			pw.println("<input type='hidden' name='"+pb.getPCode()+"Name' value='"+pb.getPName()+"'>");

			pw.println("<input type='hidden' name='"+pb.getPCode()+"Names' value='"+pb.getPprice()+"'>");
			
		
			
		};
		pw.println("</table>");
		pw.println("<center><input type='submit' value='Add To Cart'><center>");
		pw.println("<form>");
		}
		pw.println("</td>");
		 pw.println("</tr>");
		   pw.println("<tr align='center'>");
		   pw.println("<td colspan='2'>");
		   pw.println("<em>&copy);Copyrights 2016-17</em></td>");
		   pw.println("</tr>");
		   pw.println("</table>");
		   pw.println("</body></html>");
		
		}
		
		
		
	}
}
