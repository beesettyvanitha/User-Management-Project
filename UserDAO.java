import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import java.sql.Statement;
import java.util.ArrayList;

import entities.User;

public class UserDAO {
	public static void main(String[] args)
	{
		UserDAO dao = new UserDAO();
		dao.updateUser("vanitha", "vanitha@gmail.com", "123", 101);
	}
	
	public int updateUser(String name,String email,String password, int id )
	{
		String query = "UPDATE user set name = ? , email = ? , password = ?  WHERE id =?";
		Connection con = null;
   	    PreparedStatement psmt = null;
   	    int rows = 0;
   	    try
	    {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
	       psmt = con.prepareStatement(query);
	       System.out.println(psmt);
	       psmt.setString(1, name);
	       psmt.setString(2, email);
	       psmt.setString(3, password);
	       psmt.setInt(4,id);
	       System.out.println(psmt);
	    
	      rows = psmt.executeUpdate(); 
	    }
   	    catch(ClassNotFoundException ex)
		{
			   System.out.println("JDBC Driver not found");
		} 
		catch(SQLException ex)
		{
			 System.out.println("Error in Sql code .Check for any mistakes.");
		}
	 return rows;	
	}
	
    public int insertUser(String name , String email, String password)
    {
    	 String query = "INSERT INTO user (Name , Email, Password) VALUES (? , ? , ?)";
    	 Connection con = null;
    	 PreparedStatement psmt = null;
    	 int rows = 0;
		 try
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
		    psmt = con.prepareStatement(query);
		    System.out.println(psmt);
		    psmt.setString(1, name);
		    psmt.setString(2, email);
		    psmt.setString(3, password);
		    System.out.println(psmt);
		    
		    rows = psmt.executeUpdate(); 
		 }
		 catch(ClassNotFoundException ex)
		 {
			   System.out.println("JDBC Driver not found");
		 } 
		 catch(SQLException ex)
		 {
			 System.out.println("Error in Sql code .Check for any mistakes.");
		 }
      return rows;
    }
    
    
	public User getUser(String email,String password)
	{
		 String query = "Select * FROM user WHERE email = ? AND password = ?";
		 User user = null;
		 try
		  {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
		    PreparedStatement psmt = con.prepareStatement(query);
		    System.out.println(psmt);
		    psmt.setString(1, email);
		    psmt.setString(2, password);
		    System.out.println(psmt);
		    
		    ResultSet rs = psmt.executeQuery();
		    if(rs.next())
		    { 
		      user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"), rs.getString("password"));
		    }  

		  }
		 catch(ClassNotFoundException ex) {
			 System.out.println("JDBC Driver not found");
		 }
		  catch(SQLException ex)
		  {
			  System.out.println("Error in Sql code .Check for any mistakes.");
		  }
		return user;
	}
	
	 
	public ArrayList<User> getAllUser()
	{
		 String query = "Select * FROM user";
		 User user = null;
		 Connection con = null;
	     Statement statement = null;
		 ResultSet rs = null;
		 ArrayList<User> array = new ArrayList<User>();
		 try
		  {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
		    statement = con.createStatement();
		    System.out.println(statement);
	
		    rs = statement.executeQuery(query);
		   
		    while(rs.next())
		    { 
		      user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"), rs.getString("password"));
		      array.add(user);   
		    }  
		  }
		 catch(ClassNotFoundException ex)
		 {
			 System.out.println("JDBC Driver not found");
		 }
		 catch(SQLException ex)
		 {
			 System.out.println("Error in Sql code .Check for any mistakes.");
		 }
		 finally
		 {
			// close connection - close in reverse
			try
			{
				rs.close();
				statement.close();
				con.close();
			}
			catch(SQLException ex)
			{
				System.out.println("Exception whole closing connections.");
			}
		  }
		return array;
	}
	
	public User getUserById(int id)
	{
		 String query = "Select * FROM user WHERE id = ? "  ;
		 User user = null;
		 Connection con = null;
	     PreparedStatement statement = null;
		 ResultSet rs = null;
		 try
		  {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
		    statement = con.prepareStatement(query);
		    statement.setInt(1, id);
		    System.out.println(statement);
		    rs = statement.executeQuery();
		   
		    if(rs.next())
		    { 
		      user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"), rs.getString("password")); 
		    }  
		  }
		 catch(ClassNotFoundException ex)
		 {
			 System.out.println("JDBC Driver not found");
		 }
		 catch(SQLException ex)
		 {
			 System.out.println("Error in Sql code .Check for any mistakes.");
		 }
		 finally
		 {
			try
			{
				rs.close();
				statement.close();
				con.close();
			}
			catch(SQLException ex)
			{
				System.out.println("Exception whole closing connections.");
			}
		  }
		return user;
	}

	public int deleteUser(int id)
    {
    	 String query = "DELETE from user WHERE id = ?";
    	 Connection con = null;
    	 PreparedStatement psmt = null;
    	 int rows = 0;
		 try
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userMgmt", "root", "2410");
		    psmt = con.prepareStatement(query);
		    System.out.println(psmt);
		    psmt.setInt(1, id);
		    System.out.println(psmt);
		    
		    rows = psmt.executeUpdate(); 
		 }
		 catch(ClassNotFoundException ex)
		 {
			   System.out.println("JDBC Driver not found");
		 } 
		 catch(SQLException ex)
		 {
			 System.out.println("Error in Sql code .Check for any mistakes.");
		 }
      return rows;
    }
    
	
	
}
