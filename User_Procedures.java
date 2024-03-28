public interface User_Procedures {
    public String searchBookByTitle(String title);
    public String searchBookByAuthor(String name);
    public String searchBookByGenre(String genre);
    public void borrowBook(String title);
    public void returnBook(String title);
    public void reserveBook(String title);
}