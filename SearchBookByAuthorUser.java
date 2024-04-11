import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookByAuthorUser extends JFrame {
    private JButton backButton;
    private JTextField searchBookByAuthorUserTextField;
    private JButton searchButton;
    private JPanel searchBookByAuthorUser;

    public SearchBookByAuthorUser(JTextField userEntryTextField, UserOptionsForm userOptionsForm) {
        setTitle("Search Book by Author");
        setContentPane(searchBookByAuthorUser);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, Librarian.getLibrarians().get(i).searchBookByAuthor(searchBookByAuthorUserTextField));
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
