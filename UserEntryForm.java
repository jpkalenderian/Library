import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserEntryForm extends JFrame {
    private JTextField userEntryTextField;
    private JButton userEntryButton;
    private JPanel userEntryForm;
    private JButton backButton;


    public UserEntryForm() {
        setTitle("User Login");
        setVisible(true);
        setContentPane(userEntryForm);
        setBounds(750,350, 450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final UserEntryForm userEntryForm = this;

        userEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;

                if (Integer.parseInt(userEntryTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Employee ID number must be greater than zero.");
                    return;
                }

                try {
                    for (int i = 0; i < User.getUsers().size(); i++) {
                        if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                            found = true;
                            UserOptionsForm userOptionsForm = new UserOptionsForm(userEntryTextField, userEntryForm);
                            dispose();
                            userOptionsForm.setVisible(true);
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Wrong input! Try again");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong input! Try again");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}