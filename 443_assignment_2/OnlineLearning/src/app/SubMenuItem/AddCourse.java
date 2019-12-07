package app.SubMenuItem;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;

public class AddCourse extends JDialog{
    private static final long serialVersionUID = 794879465730460799L;
    private JPanel panel;
    private GridBagConstraints cs;
    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel courseLabel;
    private JTextField courseField;
    private JLabel headingLabel;

    public AddCourse(Frame p) {
        super(p, "Add Course", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;

        btnAdd = new JButton("Add Course");
        btnCancel = new JButton("Cancel");
        courseField = new JTextField(30);
        courseLabel = new JLabel("Course Name: ");
        headingLabel = new JLabel("Enter Course Name");
        
        setFields(p);
    }

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
        bp.add(btnAdd);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }

    public String getCourseField() {
        return courseField.getText().trim();
    }

    public void setCourseField() {
        courseField.setText("");
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void closePanel() {
        dispose();
    }
}