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
    /**
     * Accepts Frame Object as a parameter, and 
     * sets the location of buttons and labels, 
     * adds to the panels. Lastly, adds to the main frame
     * @param p
     */
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
    /**
     * Returns the signup button
     * @return JButton
     */
    public JButton getBtnSignup() {
        return btnSignup;
    }
    /**
     * Returns the cancel button
     * @return JButton
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
    /**
     * Returns the value of written value of name field
     * @return String
     */
    public String getName() {
        return nameField.getText().trim();
    }
    /**
     * Returns the value of selected value of age field
     * @return String
     */
    public String getAge() {
        return ageComboBox.getSelectedItem().toString();
    }
    /**
     * Returns the value of selected value of gender field
     * @return String
     */
    public String getGender() {
        return genderComboBox.getSelectedItem().toString();
    }
    /**
     * Returns the value of selected value of account type field
     * @return String
     */
    public String getAccountType() {
        return typeComboBox.getSelectedItem().toString();
    }
    /**
     * Returns the value of written value of email field
     * @return String
     */
    public String getEmail() {
        return emailField.getText().trim();
    }
    /**
     * Returns the value of written value of password field
     * @return String
     */
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    /**
     * Set the name field with empty string
     * @return void
     */
    public void setName() {
        nameField.setText("");
    }
    /**
     * Set the age field with first option
     * @return void
     */
    public void setAge() {
        ageComboBox.setSelectedIndex(0);
    }
    /**
     * Set the gender field with first option
     * @return void
     */
    public void setGender() {
        genderComboBox.setSelectedIndex(0);
    }
    /**
     * Set the account type field with first option
     * @return void
     */
    public void setAccountType() {
        typeComboBox.setSelectedIndex(0);
    }
    /**
     * Set the email field with empty string
     * @return void
     */
    public void setEmail() {
        emailField.setText("");
    }
    /**
     * Set the password field with empty string
     * @return void
     */
    public void setPassword() {
        passwordField.setText("");
    }
    /**Closes the panel */
    public void closePanel() {
        dispose();
    }
}