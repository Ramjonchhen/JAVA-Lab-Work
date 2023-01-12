import javax.swing.*;
import java.awt.event.*;

public class Template extends JFrame implements ActionListener  {
    Template() {
        setSize(500, 500);
        setVisible(true);
        setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Template();
    }
}