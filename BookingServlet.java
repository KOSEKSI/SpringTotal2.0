package shopping;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/book")
public class BookingServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			pw.println("please login");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else{
		String uname=(String)hs.getAttribute("uname1");	
			Collection products=(Collection) hs.getAttribute("products");
			if(products==null)
			{
				pw.println("<br>no products are available");
			}
			else
			{
				Iterator i=products.iterator();
				float sum=0;
				while(i.hasNext())
				{
					ProductBean pb=(ProductBean)i.next();
					//pw.println("product code"+pb.getPCode()+"product name"+pb.getPName()+"product pprice"+pb.getPprice()+"product Quantity"+pb.getPQuantity()+"<br>");
					float price=pb.getPprice()*pb.pQuantity;
					sum=sum+price;
					
					UpdateDetails up=new UpdateDetails();
					int k=up.updateRecord(pb.getPQuantity(), pb.getPCode());
					//pw.println("<tr><td>"+pb.getPCode()+"</td><td>"+pb.getPName()+"</td><td>"+pb.getPprice()+"</td><td>"+pb.getPQuantity()+"</td><td>"+price+"</td></tr>");
					/*try
					{
						Connection con=DriverConnection.getCon();
						PreparedStatement ps=con.prepareStatement("update products set pquantity=pquantity-? where pcode=?");
						ps.setInt(1, pb.getPQuantity());
						ps.setString(2, pb.getPCode());
						int k=ps.executeUpdate();
						if(k>=1){
						pw.println("records updated successfully");
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					*/
					
				}
				RequestDispatcher rd=req.getRequestDispatcher("bookingsuccess.jsp");
				rd.forward(req, res);
			}
		}
	}

}