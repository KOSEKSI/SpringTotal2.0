package shopping;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class logoutAdmin extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		if(hs!=null){
			hs.invalidate();
			pw.println("you are successfully logged off");
			RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			rd.include(req, res);
		}
	}
}
