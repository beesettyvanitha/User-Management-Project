

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;

@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int id1;
	    try 
	    {
	        id1 = Integer.parseInt(id);
	    }
	    catch (NumberFormatException e)
	    {
	        response.getWriter().print("Id must be a valid number.");
	        return;
	    }
		
		PrintWriter out = response.getWriter();
		
		UserDAO user = new UserDAO();
	    int rows = user.deleteUser(id1);
		
		if(rows == 1)
		{
			out.print("Deleted User Successfully!");
		}
		else
		{
			out.print("User Not Found");
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("userList");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
