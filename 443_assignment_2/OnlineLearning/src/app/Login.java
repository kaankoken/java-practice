package app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Frame;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;
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
    /**
     * Constructor, accepts Frame objecs as parameter
     * @param p
     */
    public Login(Frame p) {
        super(p, "Login", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();

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
    /**
     * Gets the value of written text into email field
     * @return String
     */
    public String getEmail() {
        return emailField.getText().trim();
    }
    /**
     * Gets the value of written text into password field
     * @return String
     */
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    /**
     * Returns the login button
     * @return JButton
     */
    public JButton getBtnLogin() {
        return btnLogin;
    }
    /**
     * Returns the cancel button
     * @return JButton
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
    /**
     * close the panel
     */
    public void closePanel() {
        dispose();
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
}