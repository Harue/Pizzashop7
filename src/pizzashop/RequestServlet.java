package pizzashop;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestServlet extends HttpServlet {
 public void doPost(HttpServletRequest req, HttpServletResponse res)
             throws ServletException, IOException {
	 HttpSession session = req.getSession();
  //(1)エンコード方式の指定
  res.setContentType("text/html; charset=UTF-8");
  //(2)パラメータのエンコード方式の指定
  req.setCharacterEncoding("UTF-8");

  //(3)PrintWriterオブジェクトの生成
  PrintWriter out = res.getWriter();
  out.println("<HTML>");
  out.println("<BODY>");
  //(4)name1パラメータの取得
 // out.println(req.getParameter("name1") + "<br>");
  //(5)vehicleパラメータの取得
  String vehicle[ ] = req.getParameterValues("example");
  String vehicle2[ ] = req.getParameterValues("text");
  String name = "";
  for (int i = 0; i < vehicle.length; i++ ) {
	  name += vehicle[i];
	  out.println(vehicle[i] + "  ");
	  out.println(vehicle2[i] + "<br>");
  }
  //session.setAttribute("name",name);
  /*RequestDispatcher rd = req.getRequestDispatcher("menu.html");
  rd.forward(req,res);*/
  //res.sendRedirect("/menu.html");

  out.println("</BODY>");
  out.println("</HTML>");
  
 }
}