import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianOptionsForm extends JFrame {
    private JButton addALibrarianButton;
    private JButton addAUserButton;
    private JButton checkInformationButton;
    private JButton searchBookByTitleButton;
    private JButton searchBookByGenreButton;
    private JButton searchBookByAuthorButton;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton reserveBookButton;
    private JPanel librarianOptionsForm;
    private JButton addBookButton;
    private JButton backButton;

    public LibrarianOptionsForm(JTextField librarianEntryTextField, LibrarianEntryForm librarianEntryForm) {
        setTitle("Librarian Options");
        setVisible(true);
        setContentPane(librarianOptionsForm);
        setBounds(750, 350, 450, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final LibrarianOptionsForm librarianOptionsForm = this;

        addALibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddLibrarianForm addLibrarianForm = new AddLibrarianForm(librarianEntryTextField, librarianOptionsForm);
                dispose();
                addLibrarianForm.setVisible(true);
            }
        });

        addAUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserForm addUserForm = new AddUserForm(librarianEntryTextField, librarianOptionsForm);
                dispose();
                addUserForm.setVisible(true);
            }
        });

        checkInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, Librarian.getLibrarians().get(i).checkInformation());
                    }
                }
            }
        });

        searchBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByTitleForm searchBookByTitleForm = new SearchBookByTitleForm(librarianEntryTextField, librarianOptionsForm);
                dispose();
                searchBookByTitleForm.setVisible(true);
            }
        });

        searchBookByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByAuthor searchBookByAuthor = new SearchBookByAuthor(librarianEntryTextField, librarianOptionsForm);
                dispose();
                searchBookByAuthor.setVisible(true);
            }
        });

        searchBookByGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchBookByGenre searchBookByGenre = new SearchBookByGenre(librarianEntryTextField, librarianOptionsForm);
                dispose();
                searchBookByGenre.setVisible(true);
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBook addBook = new AddBook(librarianEntryTextField, librarianOptionsForm);
                dispose();
                addBook.setVisible(true);
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowBookLibrarian borrowBookLibrarian = new BorrowBookLibrarian(librarianOptionsForm);
                dispose();
                borrowBookLibrarian.setVisible(true);
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBookLibrarian returnBookLibrarian = new ReturnBookLibrarian(librarianOptionsForm);
                dispose();
                returnBookLibrarian.setVisible(true);
            }
        });

        reserveBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReserveBookLibrarian reserveBookLibrarian = new ReserveBookLibrarian(librarianOptionsForm);
                dispose();
                reserveBookLibrarian.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianEntryForm.setVisible(true);
                dispose();
            }
        });
    }
}