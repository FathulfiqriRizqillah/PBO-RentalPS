import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MemberMenu extends JFrame {
    private Connection conn;
    private int userId;

    public MemberMenu(Connection conn, int userId) {
        this.conn = conn;
        this.userId = userId;

        setTitle("Member Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton rentConsoleButton = new JButton("Rent a Console");
        JButton logoutButton = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rentConsoleButton);
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);

        rentConsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentConsole();
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

    private void rentConsole() {
        JTextField consoleIdField = new JTextField();
        JTextField hoursField = new JTextField();

        Object[] message = {
                "Console ID:", consoleIdField,
                "Hours to Rent:", hoursField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Rent a Console", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int consoleId = Integer.parseInt(consoleIdField.getText());
            int hours = Integer.parseInt(hoursField.getText());

            String query = "SELECT price_per_hour FROM consoles WHERE id = ? AND available = TRUE";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, consoleId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int pricePerHour = rs.getInt("price_per_hour");
                    int totalPrice = pricePerHour * hours;

                    String rentalQuery = "INSERT INTO rentals (user_id, console_id, hours_rented, total_price) VALUES (?, ?, ?, ?)";
                    String updateConsoleQuery = "UPDATE consoles SET available = FALSE WHERE id = ?";
                    try (PreparedStatement rentalStmt = conn.prepareStatement(rentalQuery);
                            PreparedStatement updateConsoleStmt = conn.prepareStatement(updateConsoleQuery)) {
                        rentalStmt.setInt(1, userId);
                        rentalStmt.setInt(2, consoleId);
                        rentalStmt.setInt(3, hours);
                        rentalStmt.setInt(4, totalPrice);
                        rentalStmt.executeUpdate();

                        updateConsoleStmt.setInt(1, consoleId);
                        updateConsoleStmt.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Console rented successfully. Total price: " + totalPrice);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Console is not available or does not exist.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
