package shopping;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminHomeServlet  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs!=null){
		String User1=(String) hs.getAttribute("aduser");
		String Pass=(String) hs.getAttribute("adpass");
		
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

		    pw.println("<td width='18%'height='500'valign='top'>");
		    pw.println("<p>&nbsp;</p> ");
		    pw.println("<blockquote><p> ");
		    pw.println("<a href='"+res.encodeURL("getProducts")+"'> ");
		    pw.println("</a></p> ");
		       pw.println("<a href='"+res.encodeURL("view2")+"'> ");
		    pw.println("View products</a></p> ");
		    pw.println("<a href='"+res.encodeURL("addp")+"'> ");
		    pw.println("Add products</a></p>"); 
		    pw.println("<a href='"+res.encodeURL("editp")+"'>"); 
		   pw.println("Edit products</a></p> ");
		    pw.println("</blockquote>");
			pw.println("<a href='"+res.encodeURL("delp")+"'>"); 
		    pw.println("Delete products</a></p> ");
		    pw.println("</blockquote>");
			pw.println("<a href='"+res.encodeURL("logout2")+"'>"); 
		    pw.println("logout</a></p>"); 
		    pw.println("</blockquote></td> ");
		   
		   pw.println("<td width='82%' align='left' valign='top'>");
		   pw.println("<font size='6'>Welcome,"+User1);
		   pw.println("</font></td>");
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
		   pw.println("please login first");
		   RequestDispatcher rd=req.getRequestDispatcher("admin.html");
		   rd.include(req, res);
		}
		
	}

}
