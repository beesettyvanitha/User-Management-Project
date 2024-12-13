
public class Validation {
	public static void main(String[] args) {
		String var = "vanitha@gmail.com";
		System.out.println(checkEmailValid(var));
		
	}

	public static boolean checkEmailValid(String mail)
	{
//		if(!mail.isBlank())
//		{	
//		   int count = 0;
//		   for(int i = 0 ; i < mail.length() ; i++)
//		   {
//		  	  char m = mail.charAt(i);
//		  	  if(m == '@')
//		   	  {
//		        count++;
//		  	  }
//		    }
//		    System.out.println(count);
//		
//		    if(count == 1)
//		    {
//		      return true;
//		    }
//		  }
//		 return false;
        if(!mail.isBlank())
        {
		  int count = 0;
	      char[] array = mail.toCharArray();
	      for(int i = 0 ; i <= array.length - 1; i++)
	      {
		    if(array[i] == '@')
		    {
			  count++;
		    }
	      }
	      System.out.println(count);
	      
	      if(count == 1)
	      {
	    	  return true;
	      }
        }
        return false;
	}
 
}

