package app.email.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.util.*;

public class Window extends JPanel {

    private JFrame frame;

    public Window() {
    }


    public void createWin(String name,int width, int height) {
        this.setBackground(Color.darkGray);
        this.setLayout(null);
        frame = new JFrame(name);
        frame.add(this);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}