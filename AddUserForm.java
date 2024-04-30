import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserForm extends JFrame {
    private JTextField userNameTextField;
    private JTextField userAgeTextField;
    private JTextField userGenderTextField;
    private JButton addUserButton;
    private JButton backButton;
    private JPanel addUserForm;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    public AddUserForm(JTextField librarianEntryTextField, LibrarianOptionsForm librarianOptionsForm) {
        setTitle("Add a User");
        setContentPane(addUserForm);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                        if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                            Librarian.getLibrarians().get(i).addUser(userNameTextField, userAgeTextField, maleRadioButton);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "User added successfully. " + "\nLibrary Card Number: " + User.getUsers().getLast().getLibraryCardNum());
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid age.");
                } catch (IllegalArgumentException e3) {
                    JOptionPane.showMessageDialog(null, e3.getMessage());
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianOptionsForm.setVisible(true);
                dispose();
            }
        });
    }
}
