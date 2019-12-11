package app.SubMenuItem;
import app.Instructor;

import java.awt.GridBagLayout;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.*;

public class ListInstDetails extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnInstructor;
    private JButton btnCancel;
    private JTextField instField;
    private JLabel instLabel;
    private JPanel bp = new JPanel();

    public ListInstDetails(Frame p) {
        super(p, "Instructors Details", true);
        panel = new JPanel(new GridBagLayout());
        btnInstructor = new JButton("Get Instructor");
        btnCancel = new JButton("Cancel");
        instLabel = new JLabel("Instructor ID: ");
        instField = new JTextField(20);
        bp = new JPanel();

        panel.add(instLabel);
        panel.add(instField);

        
        bp.add(btnInstructor);
        bp.add(btnCancel);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }
    /**
     * Accepts parameter as Frame and Instructor object
     * Displays the details of the instructor.
     * @param p
     * @param inst
     */
    public void displayData(Frame p, Instructor inst) {
       
        String[] columns = {"ID", "Name", "Gender", "Age"};
        Object[][] data = new Object[1][4];

        data[0][0] = inst.ID;
        data[0][1] = inst.getName();
        data[0][2] = inst.getGender();
        data[0][3] = inst.getAge();

        table = new JTable(data, columns);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.remove(instField);
        panel.remove(instLabel);
        panel.remove(btnInstructor);
        panel.remove(btnCancel);
        panel.add(scrollPane);

        getContentPane().add(panel);
        pack();

        setResizable(true);
        setLocationRelativeTo(p);
    }
    /**
     * Returns the Instruction button
     * @return JButton
     */
    public JButton getInstButton() {
        return btnInstructor;
    }
    /**
     * Returns the cancel button
     * @return JButton
     */
    public JButton getCancelButton() {
        return btnCancel;
    }
    /**
     * Returns the id of instructor from the
     * instructor field
     * @return int
     */
    public int getInstructorID() {
        return Integer.parseInt(instField.getText().trim());
    }
    /**Closes the opened panel */
    public void closePanel() {
        dispose();
    }
    /**
     * Removes the panels to added frame
     */
    public void setVisibility() {
        getContentPane().remove(panel);
        getContentPane().remove(bp);
    }
}