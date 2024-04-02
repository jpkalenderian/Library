import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

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

    public LibrarianOptionsForm(JTextField librarianEntryTextField) {

        setTitle("Librarian Options");
        setVisible(true);
        setContentPane(librarianOptionsForm);
        setBounds(750, 350, 450, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addALibrarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        Librarian.getLibrarians().get(i).AddLibrarian();
                    }
                }
            }
        });
        addAUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        Librarian.getLibrarians().get(i).addUser();
                    }
                }
            }
        });
        checkInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        System.out.println(Librarian.getLibrarians().get(i).checkInformation());
                    }
                }
            }
        });
        searchBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter title: ");
                String title = scanner.nextLine();

                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        System.out.println(Librarian.getLibrarians().get(i).searchBookByTitle(title));
                    }
                }
            }
        });
        searchBookByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter author: ");
                String author = scanner.nextLine();

                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        System.out.println(Librarian.getLibrarians().get(i).searchBookByAuthor(author));
                    }
                }

            }
        });
        searchBookByGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter genre: ");
                String genre = scanner.nextLine();

                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        System.out.println(Librarian.getLibrarians().get(i).searchBookByGenre(genre));
                    }
                }
            }
        });
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter title: ");
                String title = scanner.nextLine();

                System.out.println("Enter user's library card number: ");
                int libraryCardNum = scanner.nextInt();

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == libraryCardNum) {
                        User.getUsers().get(i).borrowBook(title);
                    }
                }
            }
        });
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter title: ");
                String title = scanner.nextLine();

                System.out.println("Enter user's library card number: ");
                int libraryCardNum = scanner.nextInt();

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == libraryCardNum) {
                        User.getUsers().get(i).returnBook(title);
                    }
                }
            }
        });
        reserveBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter title: ");
                String title = scanner.nextLine();

                System.out.println("Enter user's library card number: ");
                int libraryCardNum = scanner.nextInt();

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == libraryCardNum) {
                        User.getUsers().get(i).reserveBook(title);
                    }
                }
            }
        });
    }
}