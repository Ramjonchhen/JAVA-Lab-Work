import javax.swing.*;
import java.awt.event.*;

public class Question2 extends JFrame implements ActionListener {
    JLabel inputLabel,outputLabel;
    JTextField inputTextField,outputTextField;
    JButton checkPalindromeBtn,findReverseBtn,findVowelsBtn;

   Question2() {
        inputLabel = new JLabel("Text:");
        outputLabel = new JLabel("Output:");
        inputTextField = new JTextField("Enter any string");
        outputTextField = new JTextField("The result of the string operation");
        outputTextField.setEnabled(false);

        checkPalindromeBtn = new JButton("Check Palindrome");
        findReverseBtn = new JButton("Reverse String");
        findVowelsBtn = new JButton("Find Vowels");

        checkPalindromeBtn.addActionListener(this);
        findReverseBtn.addActionListener(this);
        findVowelsBtn.addActionListener(this);
        
        add(inputLabel).setBounds(50,50,100,50);
        add(inputTextField).setBounds(110,60,150,30);
        add(outputLabel).setBounds(50,100,100,50);
        add(outputTextField).setBounds(110,110,270,30);
        
        add(checkPalindromeBtn).setBounds(50,150,150,30);
        add(findReverseBtn).setBounds(210,150,130,30);
        add(findVowelsBtn).setBounds(350,150,130,30);

        setSize(800, 1000);
        setLayout(null);
        setVisible(true);
   }

   private String findStringReverse(String input) {
     String reverse = "";

     for(int i=input.length()-1; i>=0; i--) {
          reverse = reverse + input.charAt(i);
     }

     return reverse;
   }

   private boolean checkPalindrome(String input) {
     String reverse = findStringReverse(input);

     if(input.endsWith(reverse) ) {
          return true;
     } else {
          return false;
     }
   }

   private String findVowels(String input) {
     String vowels = "";
     for(int i=0; i<=input.length()-1; i++) {
          if(input.charAt(i)== 'a' || 
          input.charAt(i)== 'e' || 
          input.charAt(i)== 'i' ||
          input.charAt(i)== 'o' ||
          input.charAt(i)== 'u') {
               vowels += input.charAt(i);
          }
     }
     return vowels;
   }

   public void actionPerformed(ActionEvent e) {
     String input = inputTextField.getText();

     switch(e.getActionCommand()) {
          case "Check Palindrome":
          if( checkPalindrome(input) ) {
               outputTextField.setText(input + " is a palindrome string");
          } else {
               outputTextField.setText(input + " is not a palindrome string");
          }
          break;

          case "Reverse String":
          outputTextField
          .setText("Reverse of the string: "+input+" is: "+findStringReverse(input));
          break;

          case "Find Vowels":
          outputTextField
          .setText("Vowels of the string: "+input+" is: "+findVowels(input));
          break;
     }
   }
   
   public static void main(String[] args) {
        new Question2();
   }
}
