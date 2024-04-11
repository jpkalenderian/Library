import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookByTitleUser extends JFrame {
    private JButton backButton;
    private JTextField searchBookByTitleUserTextField;
    private JButton searchButton;
    private JPanel searchBookByTitleUserForm;

    public SearchBookByTitleUser(JTextField userEntryTextField, UserOptionsForm userOptionsForm) {
        setTitle("Search Book by Title");
        setContentPane(searchBookByTitleUserForm);
        setBounds(750, 350, 450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < User.getUsers().size(); i++) {
                    if (User.getUsers().get(i).getLibraryCardNum() == Integer.parseInt(userEntryTextField.getText())) {
                        JOptionPane.showMessageDialog(null, Librarian.getLibrarians().get(i).searchBookByTitle(searchBookByTitleUserTextField));
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
