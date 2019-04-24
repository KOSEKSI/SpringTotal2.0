package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinalReg extends HttpServlet{
	public ServletContext sct;
	public UserBean us;
	public Connection con;
	public void init() throws ServletException{
	sct=this.getServletContext();
	us=(UserBean) sct.getAttribute("usreg");
	con=DriverConnection.getCon();

	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into userreg4pm1 values(?,?,?,?,?,?,?)");
			ps.setString(1, us.getUname());
			ps.setString(2, us.getPass());
			ps.setString(3, us.getFname());
			ps.setString(4, us.getSname());
			ps.setString(5, us.getAddr());
			ps.setLong(6, us.getPhone());
			ps.setString(7, us.getMail());
			
			int k=ps.executeUpdate();
			if(k>=1)
			{
				pw.println("Registration Sucessfully Completed Please Login");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
			else
			{
				pw.println("error in code");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
