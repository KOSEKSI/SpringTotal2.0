package shopping;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet{
	public void init() throws ServletException
	{
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs!=null){
			hs.invalidate();
			pw.println("You Are SuccessFully Logged Off");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
