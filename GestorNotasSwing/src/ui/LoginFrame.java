package ui;

import service.AuthService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passField;

    public LoginFrame() {

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password"));
        passField = new JPasswordField();
        add(passField);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> register());

        setVisible(true);
    }

    private void login() {

        String email = emailField.getText();
        String pass = new String(passField.getPassword());

        if (AuthService.login(email, pass)) {
            JOptionPane.showMessageDialog(this, "LOGIN OK");

            dispose();
            new NotesFrame(email);

        } else {
            JOptionPane.showMessageDialog(this, "ERROR LOGIN");
        }
    }

    private void register() {

        String email = emailField.getText();
        String pass = new String(passField.getPassword());

        AuthService.register(email, pass);
    }
}