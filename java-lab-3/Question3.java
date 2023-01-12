import java.sql.*;
import java.util.*;
public class Question3 {
    public static  Connection con;
    Question3() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = 
            DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayTable() {
        try {
            Statement pstmt = con.createStatement();
            ResultSet result = pstmt.executeQuery("select * from student_info");
            System.out.println("Id   Name   District  Age");
            while (result.next()) {
                System.out.println(result.getInt(1) +
                        " " + result.getString(2) + " " +
                        result.getString(3) + " " +
                        result.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
    public static void main(String[] args) {
        String studentName,studentDistrict;
        int studentAge,studentId;
        PreparedStatement stmt;
        try {
            new Question3();
            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            System.out.println("Demonstrating table before insertion: ");
            displayTable();
            System.out.println("Demonstrating insert operation: ");
            System.out.println("Enter the student name to add data: ");
            studentName = myObj.nextLine();
            System.out.println("Enter the student district to add data: ");
            studentDistrict = myObj.nextLine();
            System.out.println("Enter the student age to add data: ");
            studentAge = myObj.nextInt();
            stmt = con.prepareStatement("insert into student_info(name,district,age) values(?,?,?)");
            stmt.setString(1, studentName);
            stmt.setString(2, studentDistrict);
            stmt.setInt(3, studentAge);
            stmt.executeUpdate();
            System.out.println("Demonstrating table after insertion: ");
            displayTable();
            
            System.out.println("Demonstrating table before update: ");
            displayTable();
            System.out.println("Demonstrating update operation: ");
            System.out.println("Enter the student name to update data: ");
            studentName = myObj.nextLine();
            System.out.println("Enter the student district to update data: ");
            studentDistrict = myObj.nextLine();
            System.out.println("Enter the student age to update data: ");
            studentAge = myObj.nextInt();
            System.out.println("Enter the student id to update data: ");
            studentId = myObj.nextInt();
            stmt = con.prepareStatement("update student_info set name = ?, district = ?, age = ? where id = ?");
            stmt.setString(1, studentName);
            stmt.setString(2, studentDistrict);
            stmt.setInt(3, studentAge);
            stmt.setInt(4, studentId);
            stmt.executeUpdate();
            System.out.println("Demonstrating table after update is: ");
            displayTable();

            System.out.println("Demonstrating table before delete: ");
            displayTable();
            System.out.println("Enter the student id to delete data: ");
            studentId = myObj.nextInt();
            stmt = con.prepareStatement("delete from student_info where id = ?");
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
            System.out.println("Demonstrating table after delete is: ");
            displayTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
