package userreg1;
import java.io.*;
import javax.servlet.*;
public class RegServlet2 extends GenericServlet {
public RegisterBean rb;
public ServletContext sct;
@ Override
public void init() throws ServletException
{
	
	sct=this.getServletContext();
	rb=(RegisterBean) sct.getAttribute("rgbean");
}
public void service(ServletRequest req,ServletResponse res) throws ServletException ,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String Addr1=req.getParameter("address1");
	String email1=req.getParameter("email1");
	long phone1=Long.parseLong(req.getParameter("phone1"));
	rb.setADdr(Addr1);
	rb.setEMailid(email1);
	rb.setPHone(phone1);
	sct.setAttribute("rgbean", rb);
	pw.println("<br>to view details click_on ");
	pw.println("<br><a href='view'>View_Details</a>");
}
}
