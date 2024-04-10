import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookByAuthor extends JFrame{
    private JButton backButton;
    private JTextField searchBookByAuthorTextField;
    private JButton searchButton;
    private JPanel searchBookByAuthor;

    public SearchBookByAuthor(JTextField librarianEntryTextField, LibrarianOptionsForm librarianOptionsForm) {
        setTitle("Search Book by Author");
        setContentPane(searchBookByAuthor);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Librarian.getLibrarians().size(); i++) {
                    if (Librarian.getLibrarians().get(i).getEmployeeID() == Integer.parseInt(librarianEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, Librarian.getLibrarians().get(i).searchBookByAuthor(searchBookByAuthorTextField));
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarianOptionsForm.setVisible(true);
                dispose();
            }
        });
    }
}