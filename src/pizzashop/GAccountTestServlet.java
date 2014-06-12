package pizzashop;

import java.io.IOException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GAccountTestServlet extends HttpServlet {
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	        UserService service = UserServiceFactory.getUserService();

	        PrintWriter out = resp.getWriter();
	        String thisURL = req.getRequestURI();
	        if (req.getUserPrincipal() != null) {
	            User user = service.getCurrentUser();
	            out.println("<p>Google App Engine : " + req.getUserPrincipal().getName()
	                    + " <a href=\"" + service.createLogoutURL(thisURL) + "\">logout</a></p>");
	            out.println("isAdmin:" + service.isUserAdmin() + "<br />");
	            out.println("domain:" + user.getAuthDomain() + "<br />");
	            out.println("mail:" + user.getEmail() + "<br />");
	            out.println("nickname:" + user.getNickname() + "<br />");
	            out.println("<p><a href=\"http://1-dot-g12923kh.appspot.com/index.html\"> menu</a></p>");
	        } else {
	            out.println("<p><a href=\"" + service.createLoginURL(thisURL) + "\">login</a></p>");
	        }
	        
	    }

}

