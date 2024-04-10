import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarianForm extends JFrame {
    private JTextField librarianNameTextField;
    private JTextField librarianAgeTextField;
    private JTextField librarianGenderTextField;
    private JButton addLibrarianButton;
    private JPanel addLibrarianForm;
    private JButton backButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    public AddLibrarianForm(JTextField librarianEntryTextField, LibrarianOptionsForm librarianOptionsForm) {
        setTitle("Add a Librarian");
        setContentPane(addLibrarianForm);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addLibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                        if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                            Librarian.getLibrarians().get(i).AddLibrarian(librarianNameTextField, librarianAgeTextField, maleRadioButton);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Librarian added successfully.");
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