package taindata;
import java.sql.*;
import javax.servlet.*;
import java.io.*;
public class StoreTrainDetails extends GenericServlet {

	public void service (ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int trainno=Integer.parseInt(req.getParameter("trainno"));
		String trainname=req.getParameter("trainname");
		String begi=req.getParameter("city1");
		String dest=req.getParameter("city2");
		int avail=Integer.parseInt(req.getParameter("avail"));
		pw.println(trainno);
		pw.println(trainname);
		pw.println(begi);
		pw.println(dest);
		pw.println(avail);
		try{
			Connection con=DBCon.getCon();
			PreparedStatement ps=con.prepareStatement("insert into traindetails values(?,?,?,?,?)");
			ps.setInt(1, trainno);
			ps.setString(2, trainname);
			ps.setString(3, begi);
			ps.setString(4, dest);
			ps.setInt(5, avail);
			int k=ps.executeUpdate();
			if(k>0){
				pw.println("record inserted");
			}
			else
			{
				pw.println("record insertion fail");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
