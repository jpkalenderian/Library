import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianEntryForm extends JFrame {
    private JTextField librarianEntryTextField;
    private JButton LibrarianEntryButton;
    private JPanel librarianEntryForm;
    private JButton backButton;

    public LibrarianEntryForm(MainForm mainForm) {
        setTitle("Librarian Login");
        setVisible(true);
        setContentPane(librarianEntryForm);
        setBounds(750,350, 450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final LibrarianEntryForm librarianEntryForm = this;

        LibrarianEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;

                if (Integer.parseInt(librarianEntryTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Employee ID number must be greater than zero.");
                    return;
                }

                try {
                    for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                        if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        found = true;
                        LibrarianOptionsForm librarianOptionsForm = new LibrarianOptionsForm(librarianEntryTextField, librarianEntryForm);
                        dispose();
                        librarianOptionsForm.setVisible(true);
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "This employee ID does not exist.");
                    }

                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid employee ID.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainForm.setVisible(true);
                dispose();
            }
        });
    }
}
