import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;  

public class Qno8FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieFirstServlet() { super(); }

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		
			try{  		
			    PrintWriter out = response.getWriter();  
			          
			    String n=request.getParameter("userName");  
			    System.out.println("Value of the username is: "+n);
			    out.println("<h1> Welcome "+n + "</h1>");   
			    //creating the form as output of first servlet
			    out.println("<form action='Qno8SecondServlet' method='post'>");  
			    out.println("<input type='submit' value='Go To Next Page'>");  
			    out.println("</form>");  
			    Cookie ck=new Cookie("uname",n);//creating cookie object  
			    System.out.println("value of the cookie is: "+ ck);
			    response.addCookie(ck);//adding cookie in the response      
			    out.close();  
			
			        }catch(Exception e){System.out.println(e);}  
			  }
	}

