package app.SubMenuItem;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.*;

public class ChangePremium extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JButton btnYes;
    private JButton btnNo;
    private JLabel headingLabel;
    private GridBagConstraints cs;

    public ChangePremium(Frame p) {
        super(p, "Premium", true);
        panel = new JPanel(new GridBagLayout());
        cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        btnYes = new JButton("Yes");
        btnNo = new JButton("No");
        headingLabel = new JLabel("Would you like to change your account to premium?");

        panel.add(headingLabel);
        panel.add(btnYes);
        panel.add(btnNo);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setResizable(true);
        setLocationRelativeTo(p);
    }

    public JButton getBtnYes() {
        return btnYes;
    }

    public JButton getBtnNo() {
        return btnNo;
    }

    public void closePanel() {
        dispose();
    }
}