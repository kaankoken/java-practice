package app;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Menu {
    private JFrame frame;
    private JButton btnSign;
    private JButton btnLogin;
    private JButton btnExit;

    public Menu() {
        frame = new JFrame("Online Learning Platform");
        btnSign = new JButton("SignUp");
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
    };
    
    public void JMenu (List<Trainee> traineeList) {
        // btnSign.addActionListener(
            // new ActionListener() {
                // public void actionPerformed(ActionEvent e) {
                    // Signup signup = new Signup(frame, traineeList);
                    // signup.setVisible(true);
                // }
        // });
// 
        btnLogin.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login login = new Login(frame);
                    login.setVisible(true);
                }
        });

        // btnExit.addActionListener(
            // new ActionListener() {
                // public void actionPerformed(ActionEvent e) {
                    // System.exit(0);
                // }
        // });

        frame.getContentPane().add(btnSign, BorderLayout.CENTER);
        frame.getContentPane().add(btnLogin, BorderLayout.CENTER);
        frame.getContentPane().add(btnExit, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}