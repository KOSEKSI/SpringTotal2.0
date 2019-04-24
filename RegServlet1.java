package userreg1;
import java.io.*;
import javax.servlet.*;
public class RegServlet1 extends GenericServlet {
public RegisterBean rb;
public ServletContext sct;
public void init()throws ServletException
{
	sct=this.getServletContext();
	rb=new RegisterBean();
}
@ Override
public void service(ServletRequest req,ServletResponse res)throws ServletException ,IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String Uname=req.getParameter("uname1");
	String Pword=req.getParameter("pass1");
	String Fname=req.getParameter("fname1");
	String Lname=req.getParameter("lname1");
	rb.setUName(Uname);
	rb.setPWord(Pword);
	rb.setFName(Fname);
	rb.setLName(Lname);
	sct.setAttribute("rgbean", rb);
	RequestDispatcher rd=req.getRequestDispatcher("input2.html");
	rd.forward(req, res);
}
}
