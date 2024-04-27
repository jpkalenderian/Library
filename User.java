import javax.swing.*;
import java.util.LinkedList;
import java.util.Objects;

public class User extends Person implements User_Procedures {
    private int libraryCardNum;
    private static LinkedList<User> users = new LinkedList<>();

    public User(String name, int age, String gender, int libraryCardNum) {
        super(name, age, gender);
        this.libraryCardNum = libraryCardNum;
    }

    public User(User user) {
        super(user.getName(), user.getAge(), user.getGender());
        this.libraryCardNum = user.libraryCardNum;
    }

    public int getLibraryCardNum() {
        return libraryCardNum;
    }

    public void setLibraryCardNum(int libraryCardNum) {
        this.libraryCardNum = libraryCardNum;
    }

    public static LinkedList<User> getUsers() {
        return users;
    }

    public static void setUsers(LinkedList<User> users) {
        User.users = users;
    }

    @Override
    public String checkInformation() {
        return super.toString() + " Library Card Number: " + libraryCardNum;
    }

    @Override
    public String searchBookByTitle(String title) {
        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getTitle(), title)) {
                return Book.getBooks().get(i).toString();
            }
        }

        return "The book was not found.";
    }

    @Override
    public String searchBookByAuthor(String name) {
        boolean found = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getAuthor(), name)) {
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
    public String searchBookByGenre(String genre) {
        boolean found = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Book.getBooks().size(); i++) {
            if (Objects.equals(Book.getBooks().get(i).getGenre(), genre)) {
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
    public String borrowBook(JTextField titleTextField) {
        if (titleTextField.getText().isEmpty()) {
            return "Title cannot be empty.";
        }

        for (int i = 0; i < titleTextField.getText().length(); i++) {
            if (Character.isDigit(titleTextField.getText().charAt(i))) {
                return "Title cannot contain numbers.";
            }
        }

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(titleTextField.getText())) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(false);
                    return ("Book " + titleTextField.getText() + " borrowed successfully.");
                } else {
                    return ("Book " + titleTextField.getText() + " cannot be borrowed.");
                }
            }
        }

        return ("Book with title " + titleTextField.getText() + " was not found.");
    }

    @Override
    public String returnBook(JTextField titleTextField) {
        if (titleTextField.getText().isEmpty()) {
            return "Title cannot be empty.";
        }

        for (int i = 0; i < titleTextField.getText().length(); i++) {
            if (Character.isDigit(titleTextField.getText().charAt(i))) {
                return "Title cannot contain numbers.";
            }
        }

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(titleTextField.getText())) {
                if (!book.isAvailability() || book.isReserved()) {
                    book.setAvailability(true);
                    book.setReserved(false);
                    return ("Book " + titleTextField.getText() + " returned successfully.");
                } else {
                    return ("Book " + titleTextField.getText() + " cannot be returned.");
                }
            }
        }

        return ("Book with title " + titleTextField.getText() + " was not found.");
    }

    @Override
    public String reserveBook(JTextField titleTextField) {
        if (titleTextField.getText().isEmpty()) {
            return "Title cannot be empty.";
        }

        for (int i = 0; i < titleTextField.getText().length(); i++) {
            if (Character.isDigit(titleTextField.getText().charAt(i))) {
                return "Title cannot contain numbers.";
            }
        }

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(titleTextField.getText())) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(false);
                    book.setReserved(true);
                    return ("Book " + titleTextField.getText() + " reserved successfully.");
                } else {
                    return ("Book " + titleTextField.getText() + " cannot be reserved.");
                }
            }
        }

        return ("Book with title " + titleTextField.getText() + " was not found.");
    }
}