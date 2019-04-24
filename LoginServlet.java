package shopping;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet{
	public UserDao ud;
public void init() throws ServletException{
	ud=new UserDao();
}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	PrintWriter pw =res.getWriter();
	res.setContentType("text/html");
	String uname=req.getParameter("Uname");
	String pass=req.getParameter("Pword");
	if(ud.validate(uname,pass))
	{
		HttpSession hs=req.getSession();
		hs.setAttribute("uname1", uname);
		hs.setAttribute("pass1", pass);
		RequestDispatcher rd2=req.getRequestDispatcher("home.jsp");
		rd2.forward(req, res);
		
	}
	else
	{
		pw.println("Invalid UserName and PassWord");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, res);
	}
}
 
}
