package app.SubMenuItem;

import app.Course;

import java.awt.GridBagLayout;
import java.awt.Frame;
import javax.swing.*;

import java.util.*;
public class ListCourses extends JDialog {
    private static final long serialVersionUID = 7315490148533742415L;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    public ListCourses(Frame p, List<Course> course) {
        super(p, "List All Courses", true);
        panel = new JPanel(new GridBagLayout());
        displayData(p, course);
    }

    private void displayData(Frame p, List<Course> course) {
        String[] columns = {"Course Name", "Duration", "Instructor"};
        Object[][] data = new Object[course.size()][3];
        
        int i = 0;
        for (Course c: course) {
            data[i][0] = c.courseName;
            data[i][1] = c.duration;
            data[i][2] = c.instructor.getName();
            i++; 
        }
        
        table = new JTable(data, columns);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        panel.add(scrollPane);

        getContentPane().add(panel);
        pack();

        setResizable(true);
        setLocationRelativeTo(p);
    }
}