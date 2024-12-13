

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;

@WebServlet("/userList")
public class userListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO user = new UserDAO();
		ArrayList<User> allUsers  = user.getAllUser();
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.print("<h2 style = 'text-align: center'>Users List</h2>");
		out.print("<table style='margin-left: 570px;' border = '1'>");
		out.print("<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Delete User</th></tr>");
		
		
		for(int i = 0; i < allUsers.size(); i++)
		{
			User u = allUsers.get(i);
			out.print("<tr><td>" + u.getId() + "</td>");
			out.print("<td>" + u.getName() + "</td>");
			out.print("<td>" + u.getEmail() + "</td>");
			out.print("<td>" + u.getPassword() + "</td>");
			out.print("<td><form action = 'deleteUser?id="+u.getId()+"'  method = 'post' >");
			out.print("<input style ='margin-top: 12px;margin-left:10px;'type = 'submit' value = 'Delete'>");
			
			out.print("</form>");
			out.print("</td></tr>");
			
		}
		out.print("</table>");
//		out.print("<br><a href= 'Delete.html'><button style='margin-left: 715px;padding: 5px;' action = 'deleteUser' method='post'>Delete User</button></a?");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
