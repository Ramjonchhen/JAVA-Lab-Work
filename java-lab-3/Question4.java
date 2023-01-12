import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;

public class Question4 extends JFrame implements ActionListener {
    public static Connection con;
    JLabel studentNameLabel, studentAgeLabel, studentAddressLabel, studentDistrictLabel, studentIdLabel;
    JTextField studentNameText, studentAgeText, studentAddressText, studentDistrictText, studentIdText;
    JButton addButton, editButton, deleteButton;
    static DefaultTableModel tableModel;
    JPanel buttonPanel;
    public static JTable table;
    public static String[] columnNames = { "Id", "Name", "District", "Age" };

    Question4() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        table = new JTable();
        tableModel = new DefaultTableModel(0, 0);
        tableModel.setColumnIdentifiers(columnNames);
        setTableData();
        table.setModel(tableModel);
        studentNameLabel = new JLabel("Student Name");
        studentNameText = new JTextField();
        studentAgeLabel = new JLabel("Student Age");
        studentAgeText = new JTextField();
        studentAddressLabel = new JLabel("Student Address");
        studentAddressText = new JTextField();
        studentIdLabel = new JLabel("Student Id For Db opration:");
        studentIdText = new JTextField();
        addButton = new JButton("Add Student To DB");
        addButton.addActionListener(this);
        editButton = new JButton("Edit Student To DB");
        editButton.addActionListener(this);
        deleteButton = new JButton("Delete Student To DB");
        deleteButton.addActionListener(this);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(studentNameLabel);
        add(studentNameText);
        add(studentAgeLabel);
        add(studentAgeText);
        add(studentAddressLabel);
        add(studentAddressText);
        add(studentIdLabel);
        add(studentIdText);
        add(buttonPanel);
        add(table);
        setSize(1000, 1000);
        setVisible(true);
        setLayout(new GridLayout(5, 2));
    }

    public static void setTableData() {
        try {
            Statement pstmt = con.createStatement();
            ResultSet result = pstmt.executeQuery("select * from student_info");
            tableModel.setRowCount(0);
            String[] tableHeading = new String[]{"Id","Name","Address","Age"};
            tableModel.addRow(tableHeading);
            while (result.next()) {
                ArrayList<String> rowArray = new ArrayList<>();
                rowArray.add("" + result.getInt(1));
                rowArray.add(result.getString(2));
                rowArray.add(result.getString(3));
                rowArray.add(result.getString(4));

                String[] rowStrArray = new String[rowArray.size()];

                for (int i = 0; i < rowArray.size(); i++) {
                    rowStrArray[i] = rowArray.get(i);
                }
                tableModel.addRow(rowStrArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        int studentId, studentAge;
        String studentName, studentDistrict;
        PreparedStatement stmt;
        try {
            switch (e.getActionCommand()) {
                case "Add Student To DB":
                    studentAge = Integer.parseInt(studentAgeText.getText());
                    studentName = studentNameText.getText();
                    studentDistrict = studentAddressText.getText();
                    stmt = con.prepareStatement("insert into student_info(name,district,age) values(?,?,?)");
                    stmt.setString(1, studentName);
                    stmt.setString(2, studentDistrict);
                    stmt.setInt(3, studentAge);
                    stmt.executeUpdate();
                    setTableData();
                    add(table);
                    break;

                case "Edit Student To DB":
                    studentId = Integer.parseInt(studentIdText.getText());
                    studentAge = Integer.parseInt(studentAgeText.getText());
                    studentName = studentNameText.getText();
                    studentDistrict = studentAddressText.getText();
                    stmt = con.prepareStatement("update student_info set name = ?, district = ?, age = ? where id = ?");
                    stmt.setString(1, studentName);
                    stmt.setString(2, studentDistrict);
                    stmt.setInt(3, studentAge);
                    stmt.setInt(4, studentId);
                    stmt.executeUpdate();
                    setTableData();
                    add(table);
                    break;

                case "Delete Student To DB":
                    studentId = Integer.parseInt(studentIdText.getText());
                    stmt = con.prepareStatement("delete from student_info where id = ?");
                    stmt.setInt(1, studentId);
                    stmt.executeUpdate();
                    setTableData();
                    add(table);
                    break;
            }
        } catch (Exception err) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        try {
            new Question4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
