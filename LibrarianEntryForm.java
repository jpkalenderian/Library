import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianEntryForm extends JFrame {
    private JTextField librarianEntryTextField;
    private JButton LibrarianEntryButton;
    private JPanel librarianEntryForm;

    public LibrarianEntryForm() {
        setTitle("Librarian Login");
        setVisible(true);
        setContentPane(librarianEntryForm);
        setBounds(750,350, 450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LibrarianEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                try {
                    for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                        if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        found = true;
                        LibrarianOptionsForm librarianOptionsForm = new LibrarianOptionsForm(librarianEntryTextField);
                        dispose();
                        librarianOptionsForm.setVisible(true);
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
    }
}
