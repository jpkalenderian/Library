import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserEntryForm extends JFrame{
    private JTextField userEntryTextField;
    private JButton userEntryButton;
    private JPanel userEntryForm;

    public UserEntryForm() {
        setTitle("User Login");
        setVisible(true);
        setContentPane(userEntryForm);
        setBounds(750,350, 450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}