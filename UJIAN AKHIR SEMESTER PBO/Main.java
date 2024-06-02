import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        setTitle("Rental PS");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton adminButton = new JButton("Admin Menu");
        JButton memberButton = new JButton("Member Menu");

        panel.add(new JLabel("Welcome to Rental PS", SwingConstants.CENTER));
        panel.add(adminButton);
        panel.add(memberButton);

        add(panel);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminMenu();
            }
        });

        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMemberMenu();
            }
        });
    }

    private void openAdminMenu() {
        Connection conn = Database.getConnection(); // Fungsi ini Anda harus sesuaikan dengan cara Anda membuat koneksi
                                                    // ke database
        new AdminMenu(conn).setVisible(true);
        dispose();
    }

    private void openMemberMenu() {
        Connection conn = Database.getConnection(); // Fungsi ini Anda harus sesuaikan dengan cara Anda membuat koneksi
                                                    // ke database
        new MemberMenu(conn).setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
