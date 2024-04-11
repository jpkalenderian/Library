import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookByGenreUser extends JFrame{
    private JButton backButton;
    private JTextField searchBookByGenreUserTextField;
    private JButton searchButton;
    private JPanel searchBookByGenreUser;

    public SearchBookByGenreUser(JTextField userEntryTextField, UserOptionsForm userOptionsForm) {
        setTitle("Search Book by Genre");
        setContentPane(searchBookByGenreUser);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, Librarian.getLibrarians().get(i).searchBookByGenre(searchBookByGenreUserTextField));
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userOptionsForm.setVisible(true);
                dispose();
            }
        });
    }
}
