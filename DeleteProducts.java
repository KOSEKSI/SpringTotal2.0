package shopping;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteProducts  extends HttpServlet{
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
			out.println("please login");
			RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			rd.include(req, res);
		}
		else
		{
		String uname=(String) hs.getAttribute("aduser");
		String pass1=(String) hs.getAttribute("adpass");
			if(uname==null && pass1==null)
			{
				out.println("please login");
				RequestDispatcher rd=req.getRequestDispatcher("admin.html");
				rd.include(req, res);
			}
			
			String[] pcodes=req.getParameterValues("products");
			for(int i=0;i<pcodes.length;i++)
			{
				int sum=0;
				String pCode=pcodes[i];
				try{
				PreparedStatement ps=con.prepareStatement("delete from products where pcode=?");
				ps.setString(1, pCode);
				int k=ps.executeUpdate();
				if(k>=1){
					
					sum=sum+1;
				}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
			
			RequestDispatcher rd3=req.getRequestDispatcher("success2.jsp");
			rd3.forward(req, res);
		}
		
	}

}

