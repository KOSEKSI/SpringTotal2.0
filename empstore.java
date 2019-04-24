package empreg;
import java.io.*;
import java.util.StringJoiner;

import javax.servlet.*;
public class empstore extends GenericServlet {
	public EregBean erb;
	public ServletContext sct;
	public void init()throws ServletException{
		sct=this.getServletContext();
		erb=new EregBean();
	}
	@ Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String eid=req.getParameter("eid");
		String ename=req.getParameter("ename");
		String egen=req.getParameter("gender");
		StringJoiner sj2=new StringJoiner(",");
		String lang1=req.getParameter("lang1");
		sj2.add(lang1);
		String lang2=req.getParameter("lang2");
		sj2.add(lang2);
		String lang3=req.getParameter("lang3");
		sj2.add(lang3);
		String languages=sj2.toString();
		StringJoiner sj3=new StringJoiner("/");
		String days=req.getParameter("day");
		sj3.add(days);
		String month1=req.getParameter("month");
		sj3.add(month1);
		String year1=req.getParameter("year");
		sj3.add(year1);
		String dob=sj3.toString();
		String addr=req.getParameter("addr");
		
		erb.setEid(eid);
		erb.setEname(ename);
		erb.setEgen(egen);
		erb.setElang(languages);
		erb.setEdob(dob);
		erb.setEaddr(addr);
		sct.setAttribute("eregbean", erb);
		RequestDispatcher rd=req.getRequestDispatcher("stored");
		rd.forward(req, res);
		
	
	}

}
