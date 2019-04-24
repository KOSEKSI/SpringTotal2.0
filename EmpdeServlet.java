package empreg;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
public class EmpdeServlet extends GenericServlet {
public ServletContext sct;
public Connection con;
public EretriveBean erv;
public void init()throws ServletException {
	sct=this.getServletContext();
	con=DBConnection4.getCon();
	erv=new EretriveBean();
}
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String eid2=req.getParameter("id");
	try {
		PreparedStatement ps=con.prepareStatement("select * from empregis4pm where eid=?");
		ps.setString(1, eid2);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			//pw.println("show");
			erv.setEid(rs.getString(1));
			erv.setEname(rs.getString(2));
			erv.setEgen(rs.getString(3));
			erv.setElang(rs.getString(4));
			erv.setEdob(rs.getString(5));
			erv.setEaddr(rs.getString(6));
			
			sct.setAttribute("retrbean",erv);
			RequestDispatcher rd=req.getRequestDispatcher("edisp");
			rd.forward(req, res);
			
		}
		else
		{
			pw.println("Invalid Employee_Id");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, res);
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
