package booksdata;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class StoreBook extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException ,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		float bprice=Float.parseFloat(req.getParameter("bprice"));
		int bquantity=Integer.parseInt(req.getParameter("bquantity"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
			PreparedStatement ps=con.prepareStatement("insert into book1 values(?,?,?,?,?)");
			ps.setString(1, bcode);
			ps.setString(2, bname);
			ps.setString(3, bauthor);
			ps.setFloat(4, bprice);
			ps.setInt(5, bquantity);
			
			int k=ps.executeUpdate();
			if(k>0)
			{
				pw.println("record inserted successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
