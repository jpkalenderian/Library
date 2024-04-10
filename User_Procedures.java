import javax.swing.*;

public interface User_Procedures {
    public String searchBookByTitle(String title);
    public String searchBookByAuthor(String name);
    public String searchBookByGenre(String genre);
    public String borrowBook(JTextField titleTextField);
    public String returnBook(JTextField titleTextField);
    public String reserveBook(JTextField titleTextField);
}