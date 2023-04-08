import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException; import java.io.PrintWriter;

public class Qno7LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() { super(); }

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response
			) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		if(username.equals("admin") && password.equals("admin")) {
			pw.println("<h1> Succesfully Logged IN</h1>");			
		} else {
			pw.println("<h1> Wrong Credentials</h1>");
		}
		pw.close();
	}
}
