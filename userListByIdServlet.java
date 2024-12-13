

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;

@WebServlet("/userListById")
public class userListByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		response.setContentType("text/html");
		UserDAO user = new UserDAO();
		PrintWriter out = response.getWriter();
		User u = user.getUserById(id1);
		
		out.print("<h2 style = 'text-align: center'>User Details</h2>" +"<br>");
		out.print("Id : " + u.getId()+ "<br>");
		out.print("Name : " + u.getName()+ "<br>");
		out.print("Email : " + u.getEmail()+ "<br>");
		out.print("Password : " + u.getPassword()+ "<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
