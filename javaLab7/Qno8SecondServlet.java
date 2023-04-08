import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;  

public class Qno8SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieSecondServlet() {
        super();
    }

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		
			try{  		  
				response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			    Cookie ck[]=request.getCookies();  
			    System.out.println("cookie is: "+ck);
			    out.println(
			    		"<h1> Welcome Back "+ck[0].getValue()+ "</h1>"
			    		);  
			  
			    out.close();  
			  
			        }catch(Exception e){System.out.println(e);}  
			  }
	}

