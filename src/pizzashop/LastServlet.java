package pizzashop;

import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LastServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<Last> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Last.class.getName();
            try {
                list = (List<Last>) manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Last data = (Last)manager.getObjectById(Last.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Last data:list){
                res += "{id:" + data.getId() + ",count:'" + data.getCount() + "',title:'" +
                    data.getTitle() + "',date:'" + data.getDatetime() +
                     "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}
