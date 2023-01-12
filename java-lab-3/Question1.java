import java.sql.*;

public class Question1 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = 
            DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "");
            Statement pstmt = con.createStatement();
            ResultSet result = 
            pstmt.executeQuery("select * from student_info where district='kathmandu'");
            System.out.println("Student Living in Kathmandu");
            System.out.println("Id  Name District Age");
            while (result.next()) {
                System.out.println(result.getInt(1) + 
                " "+result.getString(2)+" "+
                result.getString(3)+" "+
                result.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
