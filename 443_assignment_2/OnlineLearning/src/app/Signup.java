package app;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
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

    private JPanel panel;
    private GridBagConstraints cs;

    public Signup(Frame p, List<Trainee> traineeList) {
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
        
        setFields(p, traineeList);
    }

    private void setFields(Frame p, List<Trainee> traineeList) {
        ErrorHandling checker = new ErrorHandling();

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
        panel.add(emailLabel, cs);

        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(emailField, cs);

        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(passwordLabel, cs);
        
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(passwordField, cs);

        panel.setBorder(new LineBorder(Color.GRAY));

        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Trainee temp =  new Trainee(getName(),
                getGender().charAt(0), Integer.parseInt(getAge()),
                getEmail(), getPassword());

                if (!checker.isEmpty(temp)) {
                    JOptionPane.showMessageDialog(Signup.this,
                    "At least have problem on the fields",
                    "Sign Up",
                    JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (checker.isExist(getEmail(), traineeList)) {
                        JOptionPane.showMessageDialog(Signup.this,
                        "E-mail exists in the system",
                        "Sign Up",
                        JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(Signup.this,
                        "Account succesfully created",
                        "Sign Up",
                        JOptionPane.INFORMATION_MESSAGE);
                        traineeList.add(temp);
                        dispose();
                    }
                }
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                ageComboBox.setSelectedIndex(0);
                genderComboBox.setSelectedIndex(0);
            }
        });

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
    
    public String getName() {
        return nameField.getText().trim();
    }
    
    public String getAge() {
        return ageComboBox.getSelectedItem().toString();
    }

    public String getGender() {
        return genderComboBox.getSelectedItem().toString();
    }

    public String getEmail() {
        return emailField.getText().trim();
    }

    public String getPassword() {
        return passwordField.getPassword().toString();
    }
}