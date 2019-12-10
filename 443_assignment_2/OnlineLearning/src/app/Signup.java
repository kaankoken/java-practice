package app;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JDialog {

    private static final long serialVersionUID = 4832794303362638586L;
    private JTextField nameField;
    private JComboBox ageComboBox;
    private JComboBox genderComboBox;
    private JComboBox typeComboBox;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel typeLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JButton btnSignup;
    private JButton btnCancel;

    private JPanel panel;
    private GridBagConstraints cs;

    public Signup(Frame p) {
        super(p, "Signup", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;
        
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(30);
        ageLabel = new JLabel("Age: ");
        genderLabel = new JLabel("Gender: ");
        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");
        emailField = new JTextField(30);
        passwordField = new JPasswordField(20);
        btnSignup = new JButton("Signup");
        btnCancel = new JButton("Cancel");
        typeLabel = new JLabel("Account Type: ");
        
        setFields(p);
    }

    private void setFields(Frame p) {
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(nameLabel, cs);

        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(nameField, cs);

        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(ageLabel, cs);

        ArrayList<String> tempAgeList = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            tempAgeList.add(Integer.toString(i));

        ageComboBox = new JComboBox<>(tempAgeList.toArray());
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(ageComboBox, cs);

        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(genderLabel, cs);
        
        String[] genderList =  {"Female", "Male"};
        
        genderComboBox = new JComboBox<>(genderList);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(genderComboBox, cs);

        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(typeLabel, cs);

        String[] accountType = {"Student", "Non-Student"};
        typeComboBox = new JComboBox<>(accountType);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(typeComboBox, cs);

        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        panel.add(emailLabel, cs);

        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(emailField, cs);

        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        panel.add(passwordLabel, cs);
        
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 1;
        panel.add(passwordField, cs);

        panel.setBorder(new LineBorder(Color.GRAY));

        JPanel bp = new JPanel();
        bp.add(btnSignup);
        bp.add(btnCancel);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }
    
    public JButton getBtnSignup() {
        return btnSignup;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public String getName() {
        return nameField.getText().trim();
    }
    
    public String getAge() {
        return ageComboBox.getSelectedItem().toString();
    }

    public String getGender() {
        return genderComboBox.getSelectedItem().toString();
    }

    public String getAccountType() {
        return typeComboBox.getSelectedItem().toString();
    }

    public String getEmail() {
        return emailField.getText().trim();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setName() {
        nameField.setText("");
    }

    public void setAge() {
        ageComboBox.setSelectedIndex(0);
    }

    public void setGender() {
        genderComboBox.setSelectedIndex(0);
    }

    public void setAccountType() {
        typeComboBox.setSelectedIndex(0);
    }

    public void setEmail() {
        emailField.setText("");
    }

    public void setPassword() {
        passwordField.setText("");
    }

    public void closePanel() {
        dispose();
    }
}