import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Librarian extends Person implements Librarian_Procedures{
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

    public  void AddLibrarian() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter Librarian Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Librarian Age: ");
        int age = scanner.nextInt();
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Age should be between 18 and 100");
        }

        System.out.print("Enter Librarian Gender: ");
        String gender = scanner.next();

        int employeeID;
        do {
            employeeID = rand.nextInt(1000);
        } while (isEmployeeIDExists(employeeID));

        Librarian librarian = new Librarian(name, age, gender, employeeID);
        librarians.add(librarian);
        System.out.println("Librarian added successfully.");
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
    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        if (age < 6 || age > 100) {
            throw new IllegalArgumentException("Age should be between 6 and 100");
        }

        System.out.print("Enter gender: ");
        String gender = scanner.next();

        int libraryCard;

        do {
            libraryCard = rand.nextInt(1000);
        } while (isLibraryCardExists(libraryCard));

        User user = new User(name, age, gender, libraryCard);
        User.getUsers().add(user);
        System.out.println("User added successfully.");
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
    public void addBooks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Book Information:");

        System.out.print("ISBN: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Availability: ");
        boolean availability = scanner.nextBoolean();

        System.out.print("Reserved: ");
        boolean reserved = scanner.nextBoolean();

        Book book = new Book(isbn, title, author, genre, availability, reserved);
        Book.getBooks().add(book);
        System.out.println("Book added successfully.");
    }

    @Override
    public String checkInformation() {
        return "Name: " + getName() + " Age: " + getAge() + " Gender: " + getGender() + " Employee ID: " + getEmployeeID();
    }
}
