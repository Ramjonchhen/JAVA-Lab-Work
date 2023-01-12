import javax.swing.*;
import java.awt.event.*;

public class Question extends JFrame implements ActionListener {
    JFrame f;

    JTextField num1Field, num2Field, numResultField,
            principalField, timeField, rateField, interestField;

    JLabel num1Label, num2Label, numResultLabel,
            principalLabel, timeLabel, rateLabel, interestLabel;

    JButton performAddButton, performSubtractButton,
            calculateInterestButton;

    Question() {
        f = new JFrame();
        num1Label = new JLabel("Number1:");
        num1Field = new JTextField("Enter the number 1");

        num2Label = new JLabel("Number2:");
        num2Field = new JTextField("Enter the number 2");

        numResultLabel = new JLabel("Calcuation Result:");
        numResultField = new JTextField("Result of calculation of num1 and num2");
        numResultField.setEnabled(false);

        performAddButton = new JButton("Add Numbers");
        performAddButton.addActionListener(this);
        performSubtractButton = new JButton("Subtract Numbers");
        performSubtractButton.addActionListener(this);

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

        add(num1Label).setBounds(50, 50, 100, 50);
        add(num1Field).setBounds(110, 60, 150, 30);

        add(num2Label).setBounds(50, 100, 100, 50);
        add(num2Field).setBounds(110, 110, 150, 30);

        add(numResultLabel).setBounds(50, 150, 150, 50);
        add(numResultField).setBounds(160, 160, 240, 30);

        add(performAddButton).setBounds(60, 200, 140, 30);
        add(performSubtractButton).setBounds(210, 200, 140, 30);

        add(principalLabel).setBounds(50, 240, 150, 50);
        add(principalField).setBounds(130, 250, 150, 30);
        add(timeLabel).setBounds(50, 280, 150, 50);
        add(timeField).setBounds(130, 290, 150, 30);
        add(rateLabel).setBounds(50, 320, 150, 50);
        add(rateField).setBounds(130, 330, 150, 30);
        add(interestLabel).setBounds(50, 360, 150, 50);
        add(interestField).setBounds(130, 370, 200, 30);
        add(calculateInterestButton).setBounds(100, 420, 140, 30);

        setSize(800, 1000);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question();
    }

    public void actionPerformed(ActionEvent e) {
        int num1, num2 ;
        double principal, time, rate,interest;
        switch (e.getActionCommand()) {
            case "Add Numbers":
                num1 = Integer.parseInt(num1Field.getText());
                num2 = Integer.parseInt(num2Field.getText());
                numResultField.setText("The sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
                break;

            case "Subtract Numbers":
                num1 = Integer.parseInt(num1Field.getText());
                num2 = Integer.parseInt(num2Field.getText());
                numResultField.setText("The difference of " + num1 + " and " + num2 + " is: " + (num1 - num2));
                break;

            case "Calcualte Interest":
                principal = Double.parseDouble(principalField.getText());
                time = Double.parseDouble(timeField.getText());
                rate = Double.parseDouble(rateField.getText());
                interest = ( principal * time * rate ) / 100;
                interestField.setText("The intereste we receive is: " + interest);
                break;
        }
    }
}