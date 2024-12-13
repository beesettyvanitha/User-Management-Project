

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String mail = request.getParameter("email");
		String passkey = request.getParameter("password");
		String rePasskey = request.getParameter("re-password");
		
		response.setContentType("text/html");
		if(name.isBlank() || !Validation.checkEmailValid(mail) ||passkey.isBlank() || rePasskey.isBlank())
		{
			response.getWriter().print("Enter valid details.");
		}
		else if(!passkey.equals(rePasskey))
		{
			response.getWriter().print("Passwords must match. Enter valid password again");
		}
		else
		{
		  UserDAO dao = new UserDAO();
		  int rows = dao.insertUser(name, mail, passkey);
		  if(rows == 1)
		  {
			  response.getWriter().print("<em><strong>Registered Successfully !</strong></em>"); 
		  }
		  else
		  {
			  response.getWriter().print("<em><strong>Registration Failed !</strong></em>"); 
		  }
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
