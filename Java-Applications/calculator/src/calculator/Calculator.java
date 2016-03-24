package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField jtx;
    double temp, temp1, result, a;
    static double m1, m2;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;
    JButton one, two, three, four, five, six, seven, eight, nine, zero, clr, pow2, pow3, exp;
    JButton plus, min, div, lg, rec, mul, eq, plmi, poin, mr, mc, mp, mm, sqrt, sin, cos, tan;
    JMenuBar bar;
    JMenu view;
    JMenuItem exit;
    JRadioButtonMenuItem standard, scientific;
    JSeparator jp;
    ButtonGroup bg;
    Container cont;
    JPanel textPanel, syntpanel, buttonpanel;

    Calculator() {
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel textpanel = new JPanel();
        Font font = new Font("Arial", Font.PLAIN, 18);
        jtx = new JTextField(25);
        jtx.setFont(font);
        jtx.setHorizontalAlignment(SwingConstants.RIGHT);
        jtx.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent keyevent) {
                char c = keyevent.getKeyChar();
                if (c >= '0' && c <= '9') {
                } else {
                    keyevent.consume();
                }
            }
        });
        textpanel.add(jtx);
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(5, 4, 2, 2));
        boolean t = true;
        syntpanel = new JPanel();
        syntpanel.setLayout(new GridLayout(5, 1));
        bar = new JMenuBar();
        view = new JMenu("View");

        standard = new JRadioButtonMenuItem("Standard", true);
        standard.setMnemonic('S');
        standard.addItemListener(new radiohandler());
        scientific = new JRadioButtonMenuItem("Sceintific");
        standard.setMnemonic('c');
        scientific.addItemListener(new radiohandler());
        jp = new JSeparator();
        exit = new JMenuItem("Exit");
        standard.setMnemonic('E');
        exit.addActionListener(this);
        bg = new ButtonGroup();
        bg.add(standard);
        bg.add(scientific);
        view.add(standard);
        view.add(scientific);
        view.add(jp);
        view.add(exit);
        bar.add(view);
        setJMenuBar(bar);

        mr = new JButton("MR");
        buttonpanel.add(mr);
        mr.addActionListener(this);
        seven = new JButton("7");
        buttonpanel.add(seven);
        seven.addActionListener(this);
        eight = new JButton("8");
        buttonpanel.add(eight);
        eight.addActionListener(this);
        nine = new JButton("9");
        buttonpanel.add(nine);
        nine.addActionListener(this);
        clr = new JButton("AC");
        buttonpanel.add(clr);
        clr.addActionListener(this);

        mc = new JButton("MC");
        buttonpanel.add(mc);
        mc.addActionListener(this);
        four = new JButton("4");
        buttonpanel.add(four);
        four.addActionListener(this);
        five = new JButton("5");
        buttonpanel.add(five);
        five.addActionListener(this);
        six = new JButton("6");
        buttonpanel.add(six);
        six.addActionListener(this);
        mul = new JButton("*");
        buttonpanel.add(mul);
        mul.addActionListener(this);

        mp = new JButton("M+");
        buttonpanel.add(mp);
        mp.addActionListener(this);
        one = new JButton("1");
        buttonpanel.add(one);
        one.addActionListener(this);
        two = new JButton("2");
        buttonpanel.add(two);
        two.addActionListener(this);
        three = new JButton("3");
        buttonpanel.add(three);
        three.addActionListener(this);
        min = new JButton("-");
        buttonpanel.add(min);
        min.addActionListener(this);

        mm = new JButton("M-");
        buttonpanel.add(mm);
        mm.addActionListener(this);
        zero = new JButton("0");
        buttonpanel.add(zero);
        zero.addActionListener(this);
        plmi = new JButton("+/-");
        buttonpanel.add(plmi);
        plmi.addActionListener(this);
        poin = new JButton(".");
        buttonpanel.add(poin);
        poin.addActionListener(this);
        plus = new JButton("+");
        buttonpanel.add(plus);
        plus.addActionListener(this);

        rec = new JButton("1/x");
        buttonpanel.add(rec);
        rec.addActionListener(this);
        sqrt = new JButton("Sqrt");
        buttonpanel.add(sqrt);
        sqrt.addActionListener(this);
        lg = new JButton("log");
        buttonpanel.add(lg);
        lg.addActionListener(this);
        div = new JButton("/");
        div.addActionListener(this);
        buttonpanel.add(div);
        eq = new JButton("=");
        buttonpanel.add(eq);
        eq.addActionListener(this);

        sin = new JButton("SIN");
        syntpanel.add(sin);
        sin.addActionListener(this);
        cos = new JButton("COS");
        syntpanel.add(cos);
        cos.addActionListener(this);
        tan = new JButton("TAN");
        syntpanel.add(tan);
        tan.addActionListener(this);
        pow2 = new JButton("x^2");
        syntpanel.add(pow2);
        pow2.addActionListener(this);
        pow3 = new JButton("x^3");
        syntpanel.add(pow3);
        pow3.addActionListener(this);
        exp = new JButton("Exp");
        exp.addActionListener(this);

        cont.add("Center", buttonpanel);
        cont.add("North", textpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class radiohandler implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            AbstractButton button = (AbstractButton) ie.getItem();
            String label = button.getText();
            {
                if (label.equals("Standard")) {
                    cont.remove(syntpanel);
                    validate();
                }
                if (label.equals("Sceintific")) {
                    cont.add("West", syntpanel);
                    validate();
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Exit")) {
            System.exit(0);
        }
        if (s.equals("1")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "1");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "1");
                z = 0;
            }
        }
        if (s.equals("2")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "2");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "2");
                z = 0;
            }
        }
        if (s.equals("3")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "3");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "3");
                z = 0;
            }
        }
        if (s.equals("4")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "4");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "4");
                z = 0;
            }
        }
        if (s.equals("5")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "5");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "5");
                z = 0;
            }
        }
        if (s.equals("6")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "6");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "6");
                z = 0;
            }
        }
        if (s.equals("7")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "7");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "7");
                z = 0;
            }
        }
        if (s.equals("8")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "8");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "8");
                z = 0;
            }
        }
        if (s.equals("9")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "9");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "9");
                z = 0;
            }
        }
        if (s.equals("0")) {
            if (z == 0) {
                jtx.setText(jtx.getText() + "0");
            } else {
                jtx.setText("");
                jtx.setText(jtx.getText() + "0");
                z = 0;
            }
        }
        if (s.equals("AC")) {
            jtx.setText("");
            x = 0;
            y = 0;
            z = 0;
        }
        if (s.equals("log")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.log(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("1/x")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = 1 / Double.parseDouble(jtx.getText());
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("Exp")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.exp(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("x^2")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.pow(Double.parseDouble(jtx.getText()), 2);
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("x^3")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.pow(Double.parseDouble(jtx.getText()), 3);
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("+/-")) {
            if (x == 0) {
                jtx.setText("-" + jtx.getText());
                x = 1;
            } else {
                jtx.setText(jtx.getText());
            }
        }
        if (s.equals(".")) {
            if (y == 0) {
                jtx.setText(jtx.getText() + ".");
                y = 1;
            } else {
                jtx.setText(jtx.getText());
            }
        }
        if (s.equals("+")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
                temp = 0;
                ch = '+';
            } else {
                temp = Double.parseDouble(jtx.getText());
                jtx.setText("");
                ch = '+';
                y = 0;
                x = 0;
            }
            jtx.requestFocus();
        }
        if (s.equals("-")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
                temp = 0;
                ch = '-';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(jtx.getText());
                jtx.setText("");
                ch = '-';
            }
            jtx.requestFocus();
        }
        if (s.equals("/")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
                temp = 1;
                ch = '/';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(jtx.getText());
                ch = '/';
                jtx.setText("");
            }
            jtx.requestFocus();
        }
        if (s.equals("*")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
                temp = 1;
                ch = '*';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(jtx.getText());
                ch = '*';
                jtx.setText("");
            }
            jtx.requestFocus();
        }
        if (s.equals("MC")) {
            m1 = 0;
            jtx.setText("");
        }
        if (s.equals("MR")) {
            jtx.setText("");
            jtx.setText(jtx.getText() + m1);
        }
        if (s.equals("M+")) {
            if (k == 1) {
                m1 = Double.parseDouble(jtx.getText());
                k++;
            } else {
                m1 += Double.parseDouble(jtx.getText());
                jtx.setText("" + m1);
            }
        }
        if (s.equals("M-")) {
            if (k == 1) {
                m1 = Double.parseDouble(jtx.getText());
                k++;
            } else {
                m1 -= Double.parseDouble(jtx.getText());
                jtx.setText("" + m1);
            }
        }
        if (s.equals("Sqrt")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.sqrt(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("SIN")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.sin(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("COS")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.cos(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("TAN")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                a = Math.tan(Double.parseDouble(jtx.getText()));
                jtx.setText("");
                jtx.setText(jtx.getText() + a);
            }
        }
        if (s.equals("=")) {
            if (jtx.getText().equals("")) {
                jtx.setText("");
            } else {
                temp1 = Double.parseDouble(jtx.getText());
                switch (ch) {
                    case '+':
                        result = temp + temp1;
                        break;
                    case '-':
                        result = temp - temp1;
                        break;
                    case '/':
                        result = temp / temp1;
                        break;
                    case '*':
                        result = temp * temp1;
                        break;
                }
                jtx.setText("");
                jtx.setText(jtx.getText() + result);
                z = 1;
            }
        }
        jtx.requestFocus();
    }

    public static void main(String args[]) {
        Calculator n = new Calculator();
        n.setTitle("CALCULATOR");
        n.setSize(370, 250);
        n.setResizable(false);
        n.setVisible(true);
    }
}
