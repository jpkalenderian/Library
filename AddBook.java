import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame {
    private JButton backButton;
    private JTextField isbnTextField;
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JRadioButton trueRadioButton;
    private JRadioButton falseRadioButton;
    private JPanel addBook;
    private JRadioButton trueRadioButton1;
    private JRadioButton falseRadioButton1;
    private JButton addBookButton;
    private JTextField genreTextField;

    public AddBook(JTextField librarianEntryTextField, LibrarianOptionsForm librarianOptionsForm) {
        setTitle("Add Book");
        setContentPane(addBook);
        setBounds(750, 350, 450, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                        if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                            Librarian.getLibrarians().get(i).addBooks(isbnTextField, titleTextField, authorTextField, genreTextField, falseRadioButton, trueRadioButton1);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book added successfully.");
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid ISBN.");
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
