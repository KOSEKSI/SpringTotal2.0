package empreg;
import java.io.*;
import javax.servlet.*;
public class EmpStore2 extends GenericServlet{
	public EregBean erb;
	public ServletContext sct;
	public void init()throws ServletException
	{
		sct=this.getServletContext();
		erb=(EregBean)sct.getAttribute("eregbean");
		
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException ,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
	
		pw.println("--------------Details---------------");
		pw.println("<br>id:"+erb.getEid());
		pw.println("<br>ename:"+erb.getEname());
		pw.println("<br>gender:"+erb.getEgen());
		pw.println("<br>languages:"+erb.getElang());
		pw.println("<br>DOB:"+erb.getEdob());
		pw.println("<br>Address:"+erb.getAddr());
		pw.println("<br><form action='fsub' method='post'><input type='submit' value='FinalSubmit'></form>");
	
	}

}
