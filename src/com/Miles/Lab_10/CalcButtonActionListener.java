package com.Miles.Lab_10;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class CalcButtonActionListener implements ActionListener {

    private MyJTextField jtxtValue1;
    private MyJTextField jtxtValue2;
    private MyJTextField jtxtResult;

    public CalcButtonActionListener(MyJTextField jtxtChislo1, MyJTextField jtxtChislo2, MyJTextField jtxtResult) {
        this.jtxtValue1 = jtxtChislo1;
        this.jtxtValue2 = jtxtChislo2;
        this.jtxtResult = jtxtResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }

        JButton btn = (JButton) e.getSource();

        final double a = Float.parseFloat(jtxtValue1.getText());
        final double b = Float.parseFloat(jtxtValue2.getText());

        if (btn.getActionCommand().equals("Сложение")) {
            jtxtResult.setText(String.format("%.4f", a + b));
        } else if (btn.getActionCommand().equals("Вычитание")) {
            jtxtResult.setText(String.format("%.4f",a - b));
        } else if (btn.getActionCommand().equals("Деление")) {
            jtxtResult.setText(String.format("%.4f",a / b));
        } else if (btn.getActionCommand().equals("Умножение")) {
            jtxtResult.setText(String.format("%.4f",a * b));
        }
    }
}