import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveBookUser extends JFrame{
    private JButton backButton;
    private JTextField titleTextField;
    private JButton reserveBookButton;
    private JPanel reserveBookUser;

    public ReserveBookUser(UserOptionsForm userOptionsForm, JTextField userEntryTextField) {
        setTitle("Reserve Book");
        setContentPane(reserveBookUser);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        reserveBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean found = false;

                    for (int i = 0; i < User.getUsers().size(); i++) {
                        if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                            found = true;
                            JOptionPane.showMessageDialog(null, User.getUsers().get(i).reserveBook(titleTextField));
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "This Library Card Number does not exist.");
                    }
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid Library Card Number.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userOptionsForm.setVisible(true);
                dispose();
            }
        });
    }
}
