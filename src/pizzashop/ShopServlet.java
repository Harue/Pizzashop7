package pizzashop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {
	    resp.setContentType("text/plain");
	    resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req,
	        HttpServletResponse resp)
	        throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    String pass = req.getParameter("pass");
	    if(pass.equals("12923")) {
	    resp.sendRedirect("/menu.html");
	    }
	    else {
	    	resp.sendRedirect("/try.html");
	    	
	    }
	}

	
}
