package empreg;
import javax.servlet.*;
import java.io.*;
public class EmpRes extends GenericServlet{
	public EretriveBean erv;
	public ServletContext sct;
	@ Override
	public void init()throws ServletException
	{
		sct=this.getServletContext();
		erv=(EretriveBean)sct.getAttribute("retrbean");
	}
	@ Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException ,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		rd.include(req, res);
		pw.println("--------------X----------------");
		pw.println("<br>Employees Data");
		pw.println("<br>Employee Id:&nbsp;"+erv.getEid());
		pw.println("<br>Employee Name:&nbsp;"+erv.getEname());
		pw.println("<br>Date Of Birth:&nbsp;"+erv.getEdob());
		pw.println("<br>Gender:&nbsp;"+erv.getEgen());
		pw.println("<br>Adhar Details:&nbsp;"+erv.getAddr());
		pw.println("<br>Languages Known:&nbsp;"+erv.getElang());
	}

}
