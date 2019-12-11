package app.SubMenuItem;

import app.Course;
import java.awt.GridBagLayout;
import java.awt.Frame;
import javax.swing.*;

import java.util.*;

public class EnrolledCourse extends JDialog{
    private static final long serialVersionUID = 6015385867310937473L;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    public EnrolledCourse(Frame p, List<Course> course) {
        super(p, "Enrolled Courses", true);
        panel = new JPanel(new GridBagLayout());
        displayData(p, course);
    }
    /**
     * Displays the enrolled courses of the person.
     * It accepts parameters as List of Course object
     * and Frame object
     * @param p
     * @param course
     */
    private void displayData(Frame p, List<Course> course) {
        String[] columns = {"Course Name", "Duration", "Instructor", "Premium Status"};
        Object[][] data = new Object[course.size()][4];

        int i = 0;
        for (Course c: course) {
            data[i][0] = c.courseName;
            data[i][1] = c.duration;
            data[i][2] = c.instructor.getName();
            data[i][3] = c.premium;
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
