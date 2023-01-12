import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Question12 extends JFrame implements ActionListener {
    JLabel firstNameLabel, lastNameLabel, genderLabel, ageLabel, 
    facultyLabel, remarksLabel, semesterLabel;
    JTextField firstNameText,lastNameText,ageText;
    JTextArea remarksText;
    ButtonGroup btnGroup;
    JRadioButton maleRadioBtn,femaleRadioBtn;
    JComboBox facultyComboBox, semseterComboBox;
    JPanel genderRadioButtonPanel;
    JMenuBar menubar;
    JMenu reset;
    JMenuItem resetItem;
    String facultyComboArray[] = {"B.Sc.CSIT","BIT","BIM"};
    String semseterComboArray[] = {"1st","2nd","3rd","4th","5th","6th","7th","8th"};

    Question12() {
        firstNameLabel = new JLabel("Enter the Firstname:");
        firstNameText = new JTextField();
        lastNameLabel = new JLabel("Enter the Lastname:");
        lastNameText = new JTextField();
        ageLabel = new JLabel("Enter your Age:");
        ageText = new JTextField();
        remarksLabel = new JLabel("Enter your Remarks:");
        remarksText = new JTextArea();
        facultyLabel = new JLabel("Enter your Faculty:");
        facultyComboBox = new JComboBox(facultyComboArray);
        semesterLabel = new JLabel("Enter you Semester");
        semseterComboBox = new JComboBox(semseterComboArray);
        btnGroup = new ButtonGroup();
        genderLabel = new JLabel("Enter your gender");
        maleRadioBtn = new JRadioButton("Male");
        femaleRadioBtn = new JRadioButton("Female");
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        reset = new JMenu("Reset");
        resetItem = new JMenuItem("Reset To Default");
        resetItem.addActionListener(this);
        reset.add(resetItem);
        menubar.add(reset);
        btnGroup.add(maleRadioBtn);
        btnGroup.add(femaleRadioBtn);
        genderRadioButtonPanel = new JPanel();
        genderRadioButtonPanel.setLayout(new FlowLayout());
        genderRadioButtonPanel.add(maleRadioBtn);
        genderRadioButtonPanel.add(femaleRadioBtn);

        add(firstNameLabel);
        add(firstNameText);
        add(lastNameLabel);
        add(lastNameText);
        add(ageLabel);
        add(ageText);
        add(remarksLabel);
        add(remarksText);
        add(facultyLabel);
        add(facultyComboBox);
        add(semesterLabel);
        add(semseterComboBox);
        add(genderLabel);
        add(genderRadioButtonPanel);

        setSize(1000, 1000);
        setVisible(true);
        setLayout(new GridLayout(9,2));
    }

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Reset To Default":
            firstNameText.setText("");
            lastNameText.setText("");
            ageText.setText("");
            remarksText.setText("");
            facultyComboBox.setSelectedIndex(0);
            semseterComboBox.setSelectedIndex(0);
            break;
        }
    }

    public static void main(String[] args) {
        new Question12();
    }
}