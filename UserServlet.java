
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession();
		User u = (User) s.getAttribute("loginUser");
//		out.print("<strong>Welcome " + u.getName() + "</strong><br><br>");

		out.print("<strong><h2 style = 'text-align: center'>Welcome to User Home</h2></strong>");
//		String name = request.getParameter(u.getName());
//		String mail = request.getParameter("email");
//		String passkey = request.getParameter("password");
		
		out.print("<strong>Check your details and update, as you see fit</strong>");
		out.print("<form action = 'updateUser'>");
		out.print("<input type = 'hidden' name = 'id' value = '"+u.getId()+"' >");
		out.print("<label>Name</label>" + "<br>");
		out.print("<input type = 'text' name = 'name' value = '"+u.getName()+"'>" + "<br><br>");
		out.print("<label>Email</label>" + "<br>");
		out.print("<input type = 'text' name = 'email' value = '"+u.getEmail()+"'>" + "<br><br>");
		out.print("<label>Password</label>" + "<br>");
		out.print("<input type = 'text' name = 'password' value = '"+u.getPassword()+"'>" + "<br><br>");
	    out.print("<button>Update Details</button>");
	    out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
