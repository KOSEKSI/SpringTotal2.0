package shopping;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/editproducts")
public class EditProducts  extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DriverConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		if(hs==null)
		{
			out.println("please login first.....");
			RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			rd.include(req, res);
		}
		else
		{
		String uname=(String) hs.getAttribute("aduser");
		String pass1=(String) hs.getAttribute("adpass");
			if(uname==null && pass1==null)
			{
				out.println("please login first.....");
				RequestDispatcher rd=req.getRequestDispatcher("admin.html");
				rd.include(req, res);
			}
			String pCode=req.getParameter("pc");
			String pName=req.getParameter("pn");
			Long pprice=Long.parseLong(req.getParameter("pp"));
			int pquantity=Integer.parseInt(req.getParameter("pq"));
			UpdateDetails2 up2=new UpdateDetails2();
			int k=up2.updateRecord(pCode, pName, pprice, pquantity);
			if(k>=1){
			
			RequestDispatcher rd3=req.getRequestDispatcher("success4.jsp");
			rd3.forward(req, res);
			
			}
		}
		
	}

}


