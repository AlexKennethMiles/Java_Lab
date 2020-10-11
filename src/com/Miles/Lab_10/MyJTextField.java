package com.Miles.Lab_10;

import javax.swing.JTextField;

public class MyJTextField extends JTextField {

    public MyJTextField(String text, int columns) {
        this(columns);
        super.setText(text);
    }

    public MyJTextField(int columns) {
        super.setColumns(columns);
    }
}