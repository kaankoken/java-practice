package app.SubMenuItem;
import app.Instructor;

import java.awt.GridBagLayout;
import java.awt.Frame;
import javax.swing.*;
import java.util.*;

public class ListInstructors extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    public ListInstructors(Frame p, List<Instructor> instructors) {
        super(p, "List of Instructors", true);
        panel = new JPanel(new GridBagLayout());
        displayData(p, instructors);
    }
    /**
     * Accepts parameters as Frame and List of
     * Instructions declared as global on main class
     * @param p
     * @param instructors
     */
    private void displayData(Frame p, List<Instructor> instructors) {
        String[] columns = {"ID", "Name"};
        Object[][] data = new Object[instructors.size()][2];
        
        int i = 0;
        for (Instructor c: instructors) {
            data[i][0] = c.ID;
            data[i][1] = c.getName();
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