import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBookLibrarian extends JFrame{
    private JButton backButton;
    private JTextField titleTextField;
    private JTextField userLCNTextField;
    private JButton borrowBookButton;
    private JPanel borrowBookLibrarian;

    public BorrowBookLibrarian(LibrarianOptionsForm librarianOptionsForm) {
        setTitle("Borrow Book");
        setContentPane(borrowBookLibrarian);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean found = false;

                    for (int i = 0; i < User.getUsers().size(); i++) {
                        if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userLCNTextField.getText())) {
                            found = true;
                            JOptionPane.showMessageDialog(null, User.getUsers().get(i).borrowBook(titleTextField));
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "This library card number does not exist.");
                    }
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid Library Card Number.");
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
