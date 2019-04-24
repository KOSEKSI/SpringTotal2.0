package shopping;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginAdminServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		String  User=req.getParameter("user1");
		String Pword=req.getParameter("pass1");
		if(User.toLowerCase().equals("admin") && Pword.equals("admin"))
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("aduser", User.toLowerCase());
			hs.setAttribute("adpass", Pword);
			RequestDispatcher rd=req.getRequestDispatcher("home2");
			rd.forward(req, res);
		}
		else
		{
			pw.println("Invalid UserName and PassWord");
			RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			rd.include(req, res);
		}
		
	}

}
