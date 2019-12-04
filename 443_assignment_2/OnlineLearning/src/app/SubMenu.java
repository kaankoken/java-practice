package app;

import java.awt.*;
import javax.swing.*;

public class SubMenu extends JDialog {
    
    private static final long serialVersionUID = 7120546888194081740L;

    public SubMenu(Frame p) {
        super(p, "Sub Menu", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 3;
        panel.add(new JLabel("Please choose the options type"), cs);
        
        cs.gridy = 2;
        panel.add(new JLabel(" "), cs);
        
        JButton r1 = new JButton("List All Courses");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(r1, cs);

        JButton r2 = new JButton("Add Course");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panel.add(r2, cs);

        JButton r3 = new JButton("Delete Course");
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(r3, cs);

        JButton r4 = new JButton("Get Instructor");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 2;
        panel.add(r4, cs);

        JButton r5 = new JButton("Change Account Type");
        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 2;
        panel.add(r5, cs);

        JButton r6 = new JButton("List Enrolled Courses");
        cs.gridx = 0;
        cs.gridy = 8;
        cs.gridwidth = 2;
        panel.add(r6, cs);

        JButton r7 = new JButton("Logout");
        cs.gridx = 0;
        cs.gridy = 9;
        cs.gridwidth = 2;
        panel.add(r7, cs);

        getContentPane().add(panel);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }
}
