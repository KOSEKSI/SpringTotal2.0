package userreg1;
import java.io.*;
import javax.servlet.*;
public class ViewServlet extends GenericServlet{
	public RegisterBean rb;
	public ServletContext sct;
	@ Override
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegisterBean) sct.getAttribute("rgbean");
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException ,IOException 
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("you entered details are<br>");
		pw.println("UserName:&nbsp&nbsp"+rb.getUName());
		pw.println("<br>Password:&nbsp&nbsp"+rb.getPWord());
		pw.println("<br>FirstName:&nbsp&nbsp"+rb.getFName());
		pw.println("<br>LastName:&nbsp&nbsp"+rb.getLName());
		pw.println("<br>Address:&nbsp&nbsp"+rb.getADdr());
		pw.println("<br>Emailid:&nbsp&nbsp"+rb.getEMailid());
		pw.println("<br>Phone:&nbsp&nbsp"+rb.getPHone());
		pw.println("<br><form action='reg3'><input type='submit' value='Final Submit'></form>");
	}

}
