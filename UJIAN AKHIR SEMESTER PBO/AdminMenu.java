import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminMenu extends JFrame {
    private Connection conn;

    public AdminMenu(Connection conn) {
        this.conn = conn;

        setTitle("Admin Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton viewConsolesButton = new JButton("View All Consoles");
        JButton addConsoleButton = new JButton("Add New Console");
        JButton logoutButton = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewConsolesButton);
        buttonPanel.add(addConsoleButton);
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);

        viewConsolesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllConsoles();
            }
        });

        addConsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewConsole();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginMenu().setVisible(true);
                dispose();
            }
        });
    }

    private void viewAllConsoles() {
        String query = "SELECT * FROM consoles";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            JFrame frame = new JFrame("Available Consoles");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 400);
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 1));

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("console_name");
                int price = rs.getInt("price_per_hour");
                boolean available = rs.getBoolean("available");

                JPanel consolePanel = new JPanel();
                consolePanel.setLayout(new BorderLayout());

                // Menambahkan ikon
                String iconPath = "icons/" + name.toLowerCase() + ".png";
                JLabel iconLabel = new JLabel(new ImageIcon(iconPath));
                consolePanel.add(iconLabel, BorderLayout.WEST);

                // Menambahkan informasi konsol
                JLabel infoLabel = new JLabel(
                        "ID: " + id + ", Name: " + name + ", Price/Hour: " + price + ", Available: " + available);
                consolePanel.add(infoLabel, BorderLayout.CENTER);

                panel.add(consolePanel);
            }

            frame.add(new JScrollPane(panel));
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addNewConsole() {
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] message = {
                "Console Name:", nameField,
                "Price per Hour:", priceField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add New Console", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());

            String query = "INSERT INTO consoles (console_name, price_per_hour) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setInt(2, price);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Console added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
