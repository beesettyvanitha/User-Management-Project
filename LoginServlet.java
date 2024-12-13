

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("email");
		String passkey = request.getParameter("password");
		response.setContentType("text/html");
		if(!Validation.checkEmailValid(mail) ||passkey.isBlank())
		{
			response.getWriter().print("Enter valid email and password.");
		}
		else if(mail.equals("admin@um.com") && passkey.equals("Admin@123"))
		{
			response.getWriter().print("Welcome Admin!" + "<br>");
			response.getWriter().print("<a href = 'AdminHome.html'>Go to admin page</a>");
		}
		else {
			UserDAO dao = new UserDAO();
			User u = dao.getUser(mail, passkey);
			if(u != null)
			{
//				response.getWriter().print("User Found");
//				response.getWriter().print("Email: " + mail  + "<br> Password: " + passkey + "<br>");
//				response.getWriter().print("<a href='User'>Go to user page</a>");
				
				//RequestDispatcher 
				// 1. Create RequestDispatch object with the destination resource name
				HttpSession s = request.getSession();
				s.setAttribute("loginUser", u);
				RequestDispatcher rd = request.getRequestDispatcher("User");
				// 2. method of dispatch: forward and include
				rd.forward(request, response);
				
				
			}
			
			else
			{
//				response.getWriter().print("User Not Found");
				response.getWriter().print("<strong>Login failed! Try Again</strong>" + "<br><br>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				// 2. method of dispatch: forward and include
				rd.include(request, response);
			}

		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
