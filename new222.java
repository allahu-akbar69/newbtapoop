import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.channels.FileChannel.open;

public class new222 {
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
        p0.add(new JLabel("New user register"));

        // Panel 1: Username and Password Fields
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 4, 5, 5)); // Reduced horizontal and vertical gaps
        p1.add(new JLabel("Firstname:"));
        JTextField firstnameField = new JTextField();
        firstnameField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(firstnameField);

        p1.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(usernameField);

        p1.add(new JLabel("Lastname:"));
        JTextField lastnameField = new JTextField();
        lastnameField .setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(lastnameField );

        p1.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(passwordField);

        p1.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(emailField);

        p1.add(new JLabel("number:"));
        JTextField numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(150, 25)); // Set preferred size
        p1.add(numberField);
        // Panel 2: Buttons (Login, Reset, Register)
        // Panel 2: Buttons (Reset on the left, Login on the right)
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS)); // Horizontal arrangement using BoxLayout

        // Create and add the register button (left-aligned)
        JButton registerButton = new JButton("register Pass");
        p2.add(registerButton);

        // Add horizontal glue to push components apart
        p2.add(Box.createHorizontalGlue());

        // Create and add the Login button (right-aligned)
        JButton loginButton = new JButton("Login");
        p2.add(loginButton);
//        JButton registerButton = new JButton("register");
//        p2.add(registerButton);

        // Add panels to the main panel
        mainPanel.add(p0);
        mainPanel.add(p1);
        mainPanel.add(p2);

        // Add main panel to the frame
        frame.add(mainPanel);
        frame.setSize(400, 200); // Smaller size to match reduced spacing
        frame.setVisible(true);

        // Implement ActionListener for the login button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = firstnameField.getText();
                String username = usernameField.getText();
                String lastname = lastnameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                String number = numberField.getText();

                // Simple message dialog for demonstration
                //JOptionPane.showMessageDialog(frame, "Username: " + username + "\nPassword: " + password);
                try {
                    Scanner ip = new Scanner(new File("C:\\Users\\admin2\\IdeaProjects\\oop btl\\src\\x"));
                    ArrayList<String> a = new ArrayList<>();
                    while(ip.hasNextLine()){
                        a.add(ip.nextLine());
                    }
                    for(String x : a){
                        System.out.print(x);
                    }
                    if (a.contains(username)){
                        System.out.print("có rồi chọn tên khác đi");
                    }
                    else{
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\admin2\\IdeaProjects\\oop btl\\src\\x", true))) {
                            writer.write(firstname);
                            writer.newLine();
                            writer.write(username);
                            writer.newLine();
                            writer.write(lastname);
                            writer.newLine();
                            writer.write(password);
                            writer.newLine();
                            writer.write(email);
                            writer.newLine();
                            writer.write(number);
                            writer.newLine();
                            JOptionPane.showMessageDialog(frame, "Data saved successfully!");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Error writing to file: " + ex.getMessage());
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

}
