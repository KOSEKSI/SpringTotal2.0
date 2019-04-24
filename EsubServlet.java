package empreg;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class EsubServlet  extends GenericServlet{
public Connection con;
public EregBean erb;
public ServletContext sct;
public void init() throws ServletException
{
	con=DBConnection4.getCon();
	sct=this.getServletContext();
	erb=(EregBean)sct.getAttribute("eregbean");
}
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	try {
		PreparedStatement ps=con.prepareStatement("insert into empregis4pm values(?,?,?,?,?,?)");
		ps.setString(1, erb.getEid());
		ps.setString(2, erb.getEname());
		ps.setString(3, erb.getEgen());
		ps.setString(4, erb.getElang());
		ps.setString(5, erb.getEdob());
		ps.setString(6, erb.getAddr());
		
		int k=ps.executeUpdate();
		if(k>0){
			pw.println("Employee Registered Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
