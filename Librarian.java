import javax.swing.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class Librarian extends Person implements Librarian_Procedures {
    private int employeeID;
    private static LinkedList<Librarian> librarians = new LinkedList<>();

    public Librarian(String name, int age, String gender, int employeeID) {
        super(name, age, gender);
        this.employeeID = employeeID;
    }

    public Librarian(Librarian librarian) {
        super(librarian.getName(), librarian.getAge(), librarian.getGender());
        this.employeeID = librarian.employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public static LinkedList<Librarian> getLibrarians() {
        return librarians;
    }

    public static void setLibrarians(LinkedList<Librarian> librarians) {
        Librarian.librarians = librarians;
    }

    public void AddLibrarian(JTextField librarianNameTextField, JTextField librarianAgeTextField, JRadioButton maleRadioButton) {
        Random rand = new Random();

        String name = librarianNameTextField.getText();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new IllegalArgumentException("Name cannot contain numbers.");
            }
        }

        int age = Integer.parseInt(librarianAgeTextField.getText());
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Age should be between 18 and 100.");
        }

        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "male";
        } else {
            gender = "female";
        }

        int employeeID;
        do {
            employeeID = rand.nextInt(1000);
        } while (isEmployeeIDExists(employeeID));

        Librarian librarian = new Librarian(name, age, gender, employeeID);
        librarians.add(librarian);
    }

    private static boolean isEmployeeIDExists(int id) {
        for (Librarian librarian : librarians) {
            if (librarian.employeeID == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String searchBookByTitle(JTextField searchBookByTitleTextField) {
        if (searchBookByTitleTextField.getText().isEmpty()) {
            return "Title cannot be empty.";
        }

        for (int i = 0; i < searchBookByTitleTextField.getText().length(); i++) {
            if (Character.isDigit(searchBookByTitleTextField.getText().charAt(i))) {
                return ("Title cannot contain numbers.");
            }
        }

        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getTitle(), searchBookByTitleTextField.getText())) {
                return Book.getBooks().get(i).toString();
            }
        }

        return "The book was not found.";
    }

    @Override
    public String searchBookByAuthor(JTextField searchBookByAuthorTextField) {
        boolean found = false;
        StringBuilder result = new StringBuilder();

        if (searchBookByAuthorTextField.getText().isEmpty()) {
            return "Author cannot be empty.";
        }

        for (int i = 0; i < searchBookByAuthorTextField.getText().length(); i++) {
            if (Character.isDigit(searchBookByAuthorTextField.getText().charAt(i))) {
                return ("Author cannot contain numbers.");
            }
        }

        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getAuthor(), searchBookByAuthorTextField.getText())) {
                result.append(Book.getBooks().get(i).getTitle()).append("\n");
                found = true;
            }
        }

        if (!found) {
            return "Books by this author were not found.";
        }

        return result.toString();
    }

    @Override
    public String searchBookByGenre(JTextField searchBookByGenreTextField) {
        boolean found = false;
        StringBuilder result = new StringBuilder();

        if (searchBookByGenreTextField.getText().isEmpty()) {
            return "Genre cannot be empty.";
        }

        for (int i = 0; i < searchBookByGenreTextField.getText().length(); i++) {
            if (Character.isDigit(searchBookByGenreTextField.getText().charAt(i))) {
                return ("Genre cannot contain numbers.");
            }
        }

        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getGenre(), searchBookByGenreTextField.getText())) {
                result.append(Book.getBooks().get(i).getTitle()).append("\n");
                found = true;
            }
        }

        if (!found) {
            return "Books of this genre were not found.";
        }

        return result.toString();
    }

    @Override
    public void addUser(JTextField userNameTextField, JTextField userAgeTextField, JRadioButton maleRadioButton) {
        Random rand = new Random();

        String name = userNameTextField.getText();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new IllegalArgumentException("Name cannot contain numbers.");
            }
        }

        int age = Integer.parseInt(userAgeTextField.getText());

        if (age < 6 || age > 100) {
            throw new IllegalArgumentException("Age should be between 6 and 100.");
        }

        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "male";
        } else {
            gender = "female";
        }

        int libraryCard;

        do {
            libraryCard = rand.nextInt(1000);
        } while (isLibraryCardExists(libraryCard));

        User user = new User(name, age, gender, libraryCard);
        User.getUsers().add(user);
    }

    private static boolean isLibraryCardExists(int cardNumber) {
        for (User user : User.getUsers()) {
            if (user.getLibraryCardNum() == cardNumber) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addBooks(JTextField isbnTextField, JTextField titleTextField, JTextField authorTextField, JTextField genreTextField, JRadioButton falseRadioButton, JRadioButton trueRadioButton1) {
        int isbn = Integer.parseInt(isbnTextField.getText()) ;
        if (isbn < 0 || isbn > 999999999) {
            throw new IllegalArgumentException("ISBN should be between 0 and 9999999999.");
        }

        String title = titleTextField.getText();
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        for (int i = 0; i < title.length(); i++) {
            if (Character.isDigit(title.charAt(i))) {
                throw new IllegalArgumentException("Title cannot contain numbers.");
            }
        }

        String author = authorTextField.getText();
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }

        for (int i = 0; i < author.length(); i++) {
            if (Character.isDigit(author.charAt(i))) {
                throw new IllegalArgumentException("Author cannot contain numbers.");
            }
        }

        String genre = genreTextField.getText();
        if (genre.isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }

        for (int i = 0; i < genre.length(); i++) {
            if (Character.isDigit(genre.charAt(i))) {
                throw new IllegalArgumentException("Genre cannot contain numbers.");
            }
        }

        boolean availability = true;
        if (falseRadioButton.isSelected()) {
            availability = false;
        }

        boolean reserved = false;
        if (trueRadioButton1.isSelected()) {
            reserved = true;
        }

        Book book = new Book(isbn, title, author, genre, availability, reserved);
        Book.getBooks().add(book);
    }

    @Override
    public String checkInformation() {
        return "Name: " + getName() + " Age: " + getAge() + " Gender: " + getGender() + " Employee ID: " + getEmployeeID();
    }
}
