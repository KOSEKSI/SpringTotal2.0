package servletapp4;
import java.io.*;
import javax.servlet.*;
public class BioData extends GenericServlet{

	public void service (ServletRequest req,ServletResponse res) throws ServletException ,IOException
	{
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String mname=req.getParameter("mname");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String religion=req.getParameter("religion");
		String siblings=req.getParameter("siblings");
		long contact=Long.parseLong(req.getParameter("contact"));
		String nation=req.getParameter("nation");
		
		PrintWriter pwr=res.getWriter();
		res.setContentType("text/html");
		pwr.println("<h1>You Are Entered BIO Details Are</h1>");
		pwr.println("Name:"+name+"<br>");
		pwr.println("fName:"+fname+"<br>");
		pwr.println("mName:"+mname+"<br>");
		pwr.println("DOB:"+dob+"<br>");
		pwr.println("gender:"+gender+"<br>");
		pwr.println("address:"+address+"<br>");
		pwr.println("Religion:"+religion+"<br>");
		pwr.println("Siblings:"+siblings+"<br>");
		pwr.println("Contact:"+contact+"<br>");
		pwr.println("Nation:"+nation+"<br>");
	}
}
