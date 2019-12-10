package app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Frame;
import javax.swing.*;
public class SubMenu extends JDialog {
    
    private static final long serialVersionUID = 7120546888194081740L;
    private JPanel panel;
    private GridBagConstraints cs;
    private JButton btnListAllCourses;
    private JButton btnAddCourse;
    private JButton btnDeleteCourse;
    private JButton btnGetInstructors;
    private JButton btnChangeAccountType;
    private JButton btnEnrolledCourses;
    private JButton btnLogout;

    public SubMenu(Frame p, Trainee person) {
        super(p, "Sub Menu", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 3;
        panel.add(new JLabel("Please choose the options type"), cs);
        
        cs.gridy = 2;
        panel.add(new JLabel(" "), cs);
        
        btnListAllCourses = new JButton("List All Courses");
        btnAddCourse = new JButton("Add Course");
        btnDeleteCourse = new JButton("Delete Course");
        btnGetInstructors = new JButton("Get Instructor");
        btnChangeAccountType = new JButton("Change Account Type");
        btnEnrolledCourses = new JButton("List Enrolled Courses");
        btnLogout = new JButton("Logout");

        setFields(p);
    }

    private void setFields(Frame p) {
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(btnListAllCourses, cs);

        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panel.add(btnAddCourse, cs);

        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(btnDeleteCourse, cs);

        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 2;
        panel.add(btnGetInstructors, cs);

        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 2;
        panel.add(btnChangeAccountType, cs);


        cs.gridx = 0;
        cs.gridy = 8;
        cs.gridwidth = 2;
        panel.add(btnEnrolledCourses, cs);
       
        cs.gridx = 0;
        cs.gridy = 9;
        cs.gridwidth = 2;
        panel.add(btnLogout, cs);

        getContentPane().add(panel);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }

    public JButton listAllCourses() {
        return btnListAllCourses;
    }

    public JButton addCourse() {
        return btnAddCourse;
    }

    public JButton deleteCourse() {
        return btnDeleteCourse;
    }

    public JButton listInstructors() {
        return btnGetInstructors;
    }

    public JButton changePremiumStatus() {
        return btnChangeAccountType;
    }

    public JButton enrolledCourses() {
       return btnEnrolledCourses;
    }

    public JButton logout() {
        return btnLogout;
    }

    public void closePanel() {
        dispose();
    }
}
