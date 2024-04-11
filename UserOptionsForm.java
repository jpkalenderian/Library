import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class UserOptionsForm extends JFrame{
    private JButton checkInformationButton;
    private JButton searchBookByTitleButton;
    private JButton searchBookByAuthorButton;
    private JButton searchBookByGenreButton;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton reserveBookButton;
    private JPanel userOptionsForm;
    private JButton backButton;

    public UserOptionsForm(JTextField userEntryTextField, UserEntryForm userEntryForm) {

        setTitle("User Options");
        setVisible(true);
        setContentPane(userOptionsForm);
        setBounds(750, 350, 450, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final UserOptionsForm userOptionsForm = this;

        checkInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, User.getUsers().get(i).checkInformation());
                    }
                }
            }
        });

        searchBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByTitleUser searchBookByTitleUser = new SearchBookByTitleUser(userEntryTextField, userOptionsForm);
                dispose();
                searchBookByTitleUser.setVisible(true);
            }
        });

        searchBookByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByAuthorUser searchBookByAuthorUser = new SearchBookByAuthorUser(userEntryTextField, userOptionsForm);
                dispose();
                searchBookByAuthorUser.setVisible(true);
            }
        });

        searchBookByGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByGenreUser searchBookByGenreUser = new SearchBookByGenreUser(userEntryTextField, userOptionsForm);
                dispose();
                searchBookByGenreUser.setVisible(true);
            }
        });
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowBookUser borrowBookUser = new BorrowBookUser(userOptionsForm, userEntryTextField);
                dispose();
                borrowBookUser.setVisible(true);
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBookUser returnBookUser = new ReturnBookUser(userOptionsForm, userEntryTextField);
                dispose();
                returnBookUser.setVisible(true);
            }
        });

        reserveBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReserveBookUser reserveBookUser = new ReserveBookUser(userOptionsForm, userEntryTextField);
                dispose();
                reserveBookUser.setVisible(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userEntryForm.setVisible(true);
                dispose();
            }
        });
    }
}
