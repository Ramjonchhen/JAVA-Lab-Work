import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Question6 extends JFrame implements ActionListener  {
    JFrame f;
    JTextField principalField, timeField, rateField, interestField;
    JLabel principalLabel, timeLabel, rateLabel, interestLabel;
    JButton calculateInterestButton;
    Question6() {
        f = new JFrame();
        principalLabel = new JLabel("Principal:");
        principalField = new JTextField("Enter the Princial Amount");
        timeLabel = new JLabel("Time:");
        timeField = new JTextField("Enter the Time period");
        rateLabel = new JLabel("Rate:");
        rateField = new JTextField("Enter the Rate of interest");
        interestLabel = new JLabel("Interest: ");
        interestField = new JTextField("The interest we get is: ");
        interestField.setEnabled(false);
        calculateInterestButton = new JButton("Calcualte Interest");
        calculateInterestButton.addActionListener(this);
        add(principalLabel);
        add(principalField);
        add(timeLabel);
        add(timeField);
        add(rateLabel);
        add(rateField);
        add(interestLabel);
        add(interestField);
        add(calculateInterestButton);
        setSize(800, 1000);
        setLayout(new GridLayout(5,2));
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Calcualte Interest":
            
            break;
        }
    }
    public static void main(String[] args) {
        new Question6();
    }
}