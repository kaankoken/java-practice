package app.SubMenuItem;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.*;

public class DeleteCourse extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private GridBagConstraints cs;

    private JLabel headingLabel;
    private JLabel courseLabel;
    private JTextField courseField;
    private JButton btnDelete;
    private JButton btnCancel;
    /**
     * Accepts Frame Object as a parameter, and
     * initially creates the objects inside this classs
     * @param p
     */
    public DeleteCourse(Frame p) {
        super(p, "Delete Course", true);

        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;

        btnDelete = new JButton("Delete Course");
        btnCancel = new JButton("Cancel");
        courseField = new JTextField(30);
        courseLabel = new JLabel("Course Name: ");
        headingLabel = new JLabel("Enter Course Name");
        
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
        panel.add(headingLabel, cs);

        cs.gridx = 0;
        cs.gridy = 1;
        panel.add(courseLabel, cs);

        cs.gridx = 1;
        cs.gridy = 1;
        panel.add(courseField, cs);

        JPanel bp = new JPanel();
        bp.add(btnDelete);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }
    /**
     * Gets the value of written text into coursefield
     * @return String
     */
    public String getCourseField() {
        return courseField.getText().trim();
    }
    /**
     * Set the course field with empty string
     * @return void
     */
    public void setCourseField() {
        courseField.setText("");
    }
    /**
     * Returns the delete button
     * @return JButton
     */
    public JButton getBtnDelete() {
        return btnDelete;
    }
    /**
     * Returns the cancel button
     * @return JButton
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }
    /**Close the panel */
    public void closePanel() {
        dispose();
    }
}