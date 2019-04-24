package shopping;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.*;
import javax.servlet.http.*;
public class RegUserServlet extends HttpServlet{
	ServletContext sct=null;
	UserBean us=null;
	public void init() throws ServletException{
		
		sct=this.getServletContext();
		us=new UserBean();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname1");
		String pass=req.getParameter("pass1");
		String fname=req.getParameter("fname1");
		String sname=req.getParameter("sname1");
		String address=req.getParameter("addr1");
		long phone=Long.parseLong(req.getParameter("phone1"));
		String mail1=req.getParameter("mail1");
		
		us.setUname(uname);
		us.setPass(pass);
		us.setFname(fname);
		us.setSname(sname);
		us.setAddr(address);
		us.setPhone(phone);
		us.setMail(mail1);
		
		sct.setAttribute("usreg", us);
		RequestDispatcher rd=req.getRequestDispatcher("subdetails.jsp");
		rd.forward(req, res);
	}
	

}
