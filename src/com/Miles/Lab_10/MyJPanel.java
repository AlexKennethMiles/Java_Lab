package com.Miles.Lab_10;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{

    public MyJPanel(String name, int width, int height) {
        super.setSize(width, height);
        super.setName(name);
        super.setBorder(BorderFactory.createEtchedBorder());
    }
}