import javax.swing.*;
import java.awt.event.*;

public class Question11 extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu help;
    JMenuItem about;
    JFrame frame;
    JTextArea dialogDisplayText;

    Question11() {
        frame = new JFrame();
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        help = new JMenu("Help");
        about = new JMenuItem("About");
        about.addActionListener(this);

        dialogDisplayText = new JTextArea("App Name: Question No 8" + "\n" + "Version: 1.0" + "\n" + "B.M.C Lab");
        dialogDisplayText.setEditable(false);

        help.add(about);
        menuBar.add(help);
        frame.add(menuBar).setBounds(0, 0, 500, 20);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Question No 8");
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "About":
                JDialog d = new JDialog(frame, "Help Dialog of the application");
                d.add(dialogDisplayText);
                d.setSize(300, 100);
                d.setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        new Question11();
    }
}
