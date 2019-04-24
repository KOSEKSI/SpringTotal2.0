package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
@WebServlet("/storepp")
public class StoreProducts extends HttpServlet{
	public Connection con=null;
	public void init() throws ServletException
	{
		con=DriverConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
			
		
			
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs!=null)
		{
			String uname=(String) hs.getAttribute("aduser");
			String pass1=(String) hs.getAttribute("adpass");
				if(uname==null && pass1==null)
				{
					pw.println("please login");
					RequestDispatcher rd=req.getRequestDispatcher("admin.html");
					rd.include(req, res);
				}
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		double price=Double.parseDouble(req.getParameter("pprice"));
		int count=Integer.parseInt(req.getParameter("pcount"));
		
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into products values(?,?,?,?)");
			ps.setString(1, pcode);
			ps.setString(2, pname);
			ps.setDouble(3, price);
			ps.setInt(4,count);
			
			
			int k=ps.executeUpdate();
			if(k>=1){
				RequestDispatcher rd=req.getRequestDispatcher("success3.jsp");
				rd.forward(req, res);
				
			}
			else
			{
				pw.println("error in code");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		}
		else
		{
			pw.println("please login first");
			RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			rd.include(req, res);
		}
	}
	
}
