public interface User_Procedures {
    public void searchBookByTitle(String title);
    public void searchBookByAuthor(String name);
    public void searchBookByGenre(String genre);
    public void borrowBook(String title);
    public void returnBook(String title);
    public void reserveBook(String title);
}