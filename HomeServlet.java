package shopping;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HomeServlet extends HttpServlet{
	public void init() throws ServletException
	{
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs!=null)
		{
			String uname=(String) hs.getAttribute("uname1");
			String pass=(String) hs.getAttribute("pass1");
		
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
			   pw.println("<font size='6'>Welcome,"+uname+"</font></td>");
			   pw.println("</tr>");
			   pw.println("<tr align='center'>");
			   pw.println("<td colspan='2'>");
			   pw.println("<em>&copy);Copyrights 2016-17</em></td>");
			   pw.println("</tr>");
			   pw.println("</table>");
			   pw.println("</body></html>");
			   

		}
		else
		{
			pw.println("please Login first");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
