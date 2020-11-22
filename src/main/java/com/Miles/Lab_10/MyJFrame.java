package com.Miles.Lab_10;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

public class MyJFrame extends JFrame {

    public MyJFrame(String title, int width, int height) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());;
    }

    public MyJFrame(String title, int width, int height, LayoutManager layout) {
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(layout);;
    }
}
