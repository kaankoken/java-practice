package app;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JDialog {

    private static final long serialVersionUID = 4832794303362638586L;
    private JTextField nameField;
    private JComboBox ageComboBox;
    private JComboBox genderComboBox;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton btnSignup;
    private JButton btnCancel;

    public Signup(Frame p) {
        super(p, "Signup", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        nameLabel = new JLabel("Name: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(nameLabel, cs);

        nameField = new JTextField(30);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(nameField, cs);

        ageLabel = new JLabel("Age: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(ageLabel, cs);

        ArrayList<String> tempAgeList = new ArrayList<>();
        for (int i = 0; i <= 100; i++)
            tempAgeList.add(Integer.toString(i));

        ageComboBox = new JComboBox<>(tempAgeList.toArray());
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(ageComboBox, cs);

        genderLabel = new JLabel("Gender: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(genderLabel, cs);
        
        String[] genderList =  {"Female", "Male"};
        
        genderComboBox =  new JComboBox<>(genderList);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(genderComboBox, cs);

        emailLabel = new JLabel("Email: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(emailLabel, cs);

        emailField = new JTextField(30);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(emailField, cs);

        passwordLabel = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(passwordLabel, cs);
        
        passwordField = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(passwordField, cs);

        panel.setBorder(new LineBorder(Color.GRAY));

        btnSignup = new JButton("Signup");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // add to traniee list
                dispose();
            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel bp = new JPanel();
        bp.add(btnSignup);
        bp.add(btnCancel);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }
}