package app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Frame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

public class Login extends JDialog {

    private static final long serialVersionUID = -6340242614877648589L;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel panel;
    private GridBagConstraints cs;
    private Trainee person;

    public Login(Frame p, List<Trainee> traineeList) {
        super(p, "Login", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();
        person = null;

        cs.fill = GridBagConstraints.HORIZONTAL;
        
        emailLabel = new JLabel("Email: ");
        emailField =  new JTextField(20); 
        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(20);
        panel.setBorder(new LineBorder(Color.GRAY));
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        setFields(p);
    }

    private void setFields(Frame p) {
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(emailLabel, cs);

        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(emailField, cs);

        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(passwordLabel, cs);

        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(passwordField, cs);

        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }

    public void login(Frame p, List<Trainee> traineeList) {
        ErrorHandling checker = new ErrorHandling();
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                person = checker.authenticate(traineeList, getPassword(), getEmail());
                if (person == null) {
                    JOptionPane.showMessageDialog(Login.this,
                    "Invalid Username or Password",
                    "Login",
                    JOptionPane.ERROR_MESSAGE);
                    emailField.setText("");
                    passwordField.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(Login.this,
                    "Login is Succesful",
                    "Login",
                    JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public String getEmail() {
        return emailField.getText().trim();
    }
 
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public Trainee getPerson() {
        return person;
    }
}