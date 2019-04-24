package shopping;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
public class StoreCart extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		if(hs==null)
		{
			out.println("please login");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
		String uname=(String) hs.getAttribute("uname1");
		String pass1=(String) hs.getAttribute("pass1");
			if(uname==null && pass1==null)
			{
				out.println("please login");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);
			}
			ArrayList products=(ArrayList)hs.getAttribute("products");
			if(products==null)
			{
			products=new ArrayList();
			hs.setAttribute("products", products);
			}
			String[] pcodes=req.getParameterValues("products");
			for(int i=0;i<pcodes.length;i++)
			{
				ProductBean p=new ProductBean();
				p.pCode=pcodes[i];
				int j=products.indexOf(p);
				if(j!=-1)
				{
					p=(ProductBean)products.get(j);
					p.pQuantity+=Integer.parseInt(req.getParameter(pcodes[i]));
					
					
				}
				else
				{
					//p.pPrice=Float.parseFloat(req.getParameter(pcodes[i]+"Name"));

					p.pName=req.getParameter(pcodes[i]+"Name");
					p.pQuantity=Integer.parseInt(req.getParameter(pcodes[i]));

					p.pPrice=Float.parseFloat(req.getParameter(pcodes[i]+"Names"));
					products.add(p);
				}
				
			}
			
			RequestDispatcher rd3=req.getRequestDispatcher("success.jsp");
			rd3.forward(req, res);
		}
		
	}

}
