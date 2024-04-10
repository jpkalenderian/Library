import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.LinkedList;

public class MainForm extends JFrame {
    private JPanel mainForm;
    private JButton userButton;
    private JButton librarianButton;

    public MainForm() {
        setTitle("LMS");
        setContentPane(mainForm);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                readLinkedListFromFile();
                readLibrarianLinkedListFromFile();
                readUserLinkedListFromFile();
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserEntryForm userEntryForm = new UserEntryForm();
                dispose();
                userEntryForm.setVisible(true);
            }
        });

        final MainForm mainForm = this;

        librarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianEntryForm librarianEntryForm = new LibrarianEntryForm(mainForm);
                dispose();
                librarianEntryForm.setVisible(true);
            }
        });

        setVisible(true);
    }

    protected static void readLinkedListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 6) {
                    int isbn = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    String genre = parts[3];
                    boolean availability = Boolean.parseBoolean(parts[4]);
                    boolean reserved = Boolean.parseBoolean(parts[5]);
                    Book.getBooks().add(new Book(isbn, title, author, genre, availability, reserved));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void readLibrarianLinkedListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Librarians.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String name2 = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    int employeeID = Integer.parseInt(parts[3]);
                    Librarian.getLibrarians().add(new Librarian(name2, age, gender, employeeID));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void readUserLinkedListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String name2 = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    int libCardNum = Integer.parseInt(parts[3]);
                    User.getUsers().add(new User(name2, age, gender, libCardNum));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeLinkedListToFile(LinkedList<Book> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Books.txt"))) {
            for (Book book : list) {
                writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.isAvailability() + "," + book.isReserved());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeLibrarianLinkedListToFile(LinkedList<Librarian> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Librarians.txt"))) {
            for (Librarian librarian : list) {
                writer.write(librarian.getName() + "," + librarian.getAge() + "," + librarian.getGender() + "," + librarian.getEmployeeID());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeUserLinkedListToFile(LinkedList<User> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"))) {
            for (User user : list) {
                writer.write(user.getName() + "," + user.getAge() + "," + user.getGender() + "," + user.getLibraryCardNum());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        MainForm mainForm = new MainForm();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            mainForm.writeLinkedListToFile(Book.getBooks());
            mainForm.writeLibrarianLinkedListToFile(Librarian.getLibrarians());
            mainForm.writeUserLinkedListToFile(User.getUsers());
        }));
    }
}