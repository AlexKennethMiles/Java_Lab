package com.Miles.Lab_10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class TestGUI {

    private MyJButton btnAdd;
    private MyJButton btnSubtract;
    private MyJButton btnDivide;
    private MyJButton btnMultiply;

    private JLabel labelValue1;
    private JLabel labelValue2;
    private JLabel labelResult;

    private MyJTextField jtxtValue1;
    private MyJTextField jtxtValue2;
    private MyJTextField jtxtResult;

    private MyJPanel panel1;
    private MyJPanel panel2;
    private MyJPanel panel3;

    private MyJFrame frame;

    public static void main(String[] args) {

        TestGUI testGUI = new TestGUI();

        testGUI.createLabels();
        testGUI.createTextFields();
        testGUI.createButtons();
        testGUI.createPanels();
        testGUI.createFrame();

    }

    private void createLabels() {
        labelValue1 = new JLabel("Число 1");
        labelValue2 = new JLabel("Число 2");
        labelResult = new JLabel("Результат");
    }

    private void createTextFields() {
        jtxtValue1 = new MyJTextField(10);
        jtxtValue2 = new MyJTextField(10);
        jtxtResult = new MyJTextField(15);
        jtxtResult.setEditable(false);
        jtxtResult.setFocusable(false);
    }

    private void createButtons() {
        btnAdd = new MyJButton("Сложение");
        btnSubtract = new MyJButton("Вычитание");
        btnDivide = new MyJButton("Деление");
        btnMultiply = new MyJButton("Умножение");

        addButtonListeners();
    }

    private void createPanels() {
        panel1 = new MyJPanel("panel1", 100, 100);
        panel1.setPreferredSize(new Dimension(200, 50));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new MyJPanel("panel2", 100, 100);
        panel2.setPreferredSize(new Dimension(200, 50));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new MyJPanel("panel3", 100, 100);
        panel3.setPreferredSize(new Dimension(200, 50));
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel1.add(labelValue1);
        panel1.add(jtxtValue1);
        panel1.add(labelValue2);
        panel1.add(jtxtValue2);

        panel2.add(btnAdd);
        panel2.add(btnSubtract);
        panel2.add(btnMultiply);
        panel2.add(btnDivide);

        panel3.add(labelResult);
        panel3.add(jtxtResult);

    }

    private void createFrame() {
        frame = new MyJFrame("Calculator", 430, 200, new BorderLayout(2, 2));
        frame.setMinimumSize(new Dimension(430, 200));

        frame.setResizable(false);

        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.getContentPane().add(panel3, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private void addButtonListeners() {
        CalcButtonActionListener bl = new CalcButtonActionListener(jtxtValue1, jtxtValue2, jtxtResult);

        btnAdd.addActionListener(bl);
        btnSubtract.addActionListener(bl);
        btnMultiply.addActionListener(bl);
        btnDivide.addActionListener(bl);
    }
}