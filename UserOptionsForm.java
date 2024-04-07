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


    public UserOptionsForm(JTextField userEntryTextField) {

        setTitle("Librarian Options");
        setVisible(true);
        setContentPane(userOptionsForm);
        setBounds(750, 350, 450, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        checkInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        System.out.println(User.getUsers().get(i).checkInformation());
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        System.out.println(User.getUsers().get(i).searchBookByTitle(title));
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        System.out.println(User.getUsers().get(i).searchBookByAuthor(author));
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        System.out.println(User.getUsers().get(i).searchBookByGenre(genre));
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
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

                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        User.getUsers().get(i).reserveBook(title);
                    }
                }
            }
        });
    }
}
