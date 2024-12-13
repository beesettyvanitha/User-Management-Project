

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/updateUser")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO u = new UserDAO();
		int rows = u.updateUser(name, email, password, id1);
		if(rows == 1)
		{
			  response.getWriter().print("<em><strong>Update Successfull !</strong></em>"); 
			  User updateUser = u.getUser(email, password);
			  HttpSession s = request.getSession();
			  s.setAttribute("loginUser", updateUser);      
		}
		else
	    {
			  response.getWriter().print("<em><strong>Failed !</strong></em>"); 
		}
		RequestDispatcher rd = request.getRequestDispatcher("User");
		rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
