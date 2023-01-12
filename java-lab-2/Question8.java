import javax.swing.*;
import java.awt.event.*;

public class Question8 extends JFrame implements ActionListener  {
    JFrame f;
    JMenuBar menuBar;
    JTextArea textArea;
    JMenu fileItem,editItem,viewItem;

    Question8() {
        f = new JFrame();
        menuBar = new JMenuBar();
        textArea = new JTextArea("Welcome to BMC Notepad++");
        fileItem = new JMenu("File");
        editItem = new JMenu("Edit");
        viewItem = new JMenu("View");

        add(menuBar).setBounds(0,0,1000,20);;
        add(textArea).setBounds(100,100, 100, 100);
        menuBar.add(fileItem);
        menuBar.add(editItem);
        menuBar.add(viewItem);

        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setTitle("NotePad++");
    }
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        new Question8();
    }
}
