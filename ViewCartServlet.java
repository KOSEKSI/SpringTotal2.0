package shopping;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;
public class ViewCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			pw.println("please login");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else{
		String uname=(String)hs.getAttribute("uname1");
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
		
	
			
			Collection products=(Collection) hs.getAttribute("products");
			if(products==null)
			{
				pw.println("<br>no products are available");
			}
			else
			{
				pw.println("<br>your cart details are <br>");
				pw.println("<table align='center' border='1' cellspacing='5' cellpadding='5'><tr><th>ProductCode</th><th>ProductName</th><th>ProductPrice</th><th>ProductQuantity</th><th>ProductTotal</th></tr>");
				Iterator i=products.iterator();
				float sum=0;
				while(i.hasNext())
				{
					ProductBean pb=(ProductBean)i.next();
					//pw.println("product code"+pb.getPCode()+"product name"+pb.getPName()+"product pprice"+pb.getPprice()+"product Quantity"+pb.getPQuantity()+"<br>");
					float price=pb.getPprice()*pb.pQuantity;
					sum=sum+price;
					pw.println("<tr><td>"+pb.getPCode()+"</td><td>"+pb.getPName()+"</td><td>"+pb.getPprice()+"</td><td>"+pb.getPQuantity()+"</td><td>"+price+"</td></tr>");
					
				}
				pw.println("<tr><td colspan='4'>GrandTotal</td><td>"+sum+"</td></tr>");
				pw.println("</table>");
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