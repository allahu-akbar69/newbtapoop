package new1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 {
    private JTextField loginTextField;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JPasswordField passwordField1;



    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adding padding around main panel

        // Panel 0: Title
        JPanel p0 = new JPanel();
        p0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Reduced spacing
        p0.add(new JLabel("LOG IN"));

        // Panel 1: Username and Password Fields
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 5, 5)); // Reduced horizontal and vertical gaps
        p1.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(usernameField);

        p1.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(passwordField);

        // Panel 2: Buttons (Login, Reset, Register)
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Reduced spacing
        JButton loginButton = new JButton("Login");
        p2.add(loginButton);
        JButton resetButton = new JButton("Reset");
        p2.add(resetButton);
        JButton registerButton = new JButton("Register");
        p2.add(registerButton);

        // Add panels to the main panel
        mainPanel.add(p0);
        mainPanel.add(p1);
        mainPanel.add(p2);

        // Add main panel to the frame
        frame.add(mainPanel);
        frame.setSize(400, 200); // Smaller size to match reduced spacing
        frame.setVisible(true);

        // Implement ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Simple message dialog for demonstration
                JOptionPane.showMessageDialog(frame, "Username: " + username + "\nPassword: " + password);
            }
        });
    }

}
