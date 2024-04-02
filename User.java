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
    public void borrowBook(String title) {
        boolean found = false;

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setAvailability(false);
                    System.out.println("Book " + title + " borrowed successfully.");
                } else {
                    System.out.println("Book " + title + " cannot be borrowed.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book with title " + title + " was not found.");
        }
    }

    @Override
    public void returnBook(String title) {
        boolean found = false;

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(title)) {
                if (!book.isReserved()) {
                    book.setAvailability(true);
                    System.out.println("Book " + title + " returned successfully.");
                } else {
                    System.out.println("Book " + title + " cannot be returned.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book with title " + title + " was not found.");
        }
    }

    @Override
    public void reserveBook(String Title) {
        boolean found = false;

        for (Book book : Book.getBooks()) {
            if (book.getTitle().equals(Title)) {
                if (book.isAvailability() && !book.isReserved()) {
                    book.setReserved(true);
                    System.out.println("Book " + Title + " reserved successfully.");
                } else {
                    System.out.println("Book " + Title + " cannot be reserved.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book with title " + Title + " was not found.");
        }
    }
}