import javax.swing.*;

public interface Librarian_Procedures {
    public String searchBookByTitle(JTextField searchBookByTitleTextField);
    public String searchBookByAuthor(JTextField searchBookByAuthorTextField);
    public String searchBookByGenre(JTextField searchBookByGenreTextField);
    public void addUser(JTextField userNameTextField, JTextField userAgeTextField, JRadioButton maleRadioButton);
    public void addBooks(JTextField isbnTextField, JTextField titleTextField, JTextField authorTextField, JTextField genreTextField, JRadioButton falseRadioButton, JRadioButton trueRadioButton1);
}