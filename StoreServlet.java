package userreg1;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class StoreServlet extends GenericServlet {
public Connection con;
public RegisterBean rb;
public ServletContext sct;
public void init() throws ServletException {
	con=DBConnection13.getCon();
	sct=this.getServletContext();
	rb=(RegisterBean)sct.getAttribute("rgbean");
}
public void service(ServletRequest req,ServletResponse res)throws ServletException ,IOException 
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	try{
	PreparedStatement ps=con.prepareStatement("insert into userreg4pm values(?,?,?,?,?,?,?)");
	ps.setString(1,rb.getUName());
	ps.setString(2, rb.getPWord());
	ps.setString(3, rb.getFName());
	ps.setString(4, rb.getLName());
	ps.setString(5, rb.getADdr());
	ps.setLong(6, rb.getPHone());
	ps.setString(7, rb.getEMailid());
	int k=ps.executeUpdate();
	if(k>0)
	{
		pw.println("user registered successfully");
		RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
		rd.include(req, res);
		
	}
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
