import java.sql.*;
public class DbConnection {
	public Connection con;
	DbConnection(){
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(""
	            		+ "jdbc:mysql://localhost:3306/advancejava","root","");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}