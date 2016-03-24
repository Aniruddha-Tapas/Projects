package bank.account.simulation;

/**
 * ********************************************************
 *
 * Program to create GUI for Bank Account Simulation. *
 *
 **********************************************************
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GuiAccTest extends Frame implements ActionListener {

    Label lab = new Label(" ");
    Label lab1 = new Label(" ");
    TextField t[] = new TextField[4];
    Label l[] = new Label[4];
    Button but = new Button("Create Account");
    Button but1 = new Button("Test Account");
    BankAccount b;

    GuiAccTest() {
        addWindowListener(new NewWindowAdapter());
        setLayout(new GridLayout(2, 0));
        Panel p = new Panel();
        Panel p1 = new Panel();
        but.addActionListener(this);
        but1.addActionListener(this);
        p.setLayout(new GridLayout(5, 2));
        p1.add(lab1);
        p1.add(lab);
        l[0] = new Label("Account Number");
        l[1] = new Label("Initial Balance");
        l[2] = new Label("Deposit Amount");
        l[3] = new Label("Withdraw Amount");
        for (int i = 0; i < 4; i++) {
            t[i] = new TextField(10);
            p.add(l[i]);
            p.add(t[i]);
        }
        p.add(but);
        p.add(but1);
        but1.setVisible(false);
        l[2].setVisible(false);
        l[3].setVisible(false);
        t[2].setVisible(false);
        t[3].setVisible(false);
        add(p);
        add(p1);
    }

    String testAccount(int d_amt, int w_amt) {
        String msg;
        b.deposit(d_amt);
        msg = "Transaction Succesful";
        try {
            b.withdraw(w_amt);
        } catch (FundsInsufficientException fe) {
            fe = new FundsInsufficientException(b.amount, w_amt);
            msg = String.valueOf(fe);
        }
        return msg;
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Create Account")) {
            b = new BankAccount(Integer.parseInt(t[0].getText()),
                    Integer.parseInt(t[1].getText()));
            but1.setVisible(true);
            l[2].setVisible(true);
            l[3].setVisible(true);
            t[2].setVisible(true);
            t[3].setVisible(true);
            but.setVisible(false);
            l[0].setVisible(false);
            l[1].setVisible(false);
            t[0].setVisible(false);
            t[1].setVisible(false);
            lab1.setText("Account : " + b.accnum + ", Current Balance: "+b.amount);
                        return;
        } else {

            lab.setText(testAccount(Integer.parseInt(t[2].getText()),
                    Integer.parseInt(t[3].getText())));
            lab1.setText("Account : " + b.accnum + ", Current Balance: "+b.amount);
                }
        }
        public static void main(String arg[]) {
        GuiAccTest at = new GuiAccTest();
        at.setTitle("Bank Account Tester");
        at.setSize(600, 200);
        at.setVisible(true);
    }
}

class NewWindowAdapter extends WindowAdapter {

    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

class BankAccount {

    int accnum;
    int amount;

    BankAccount(int num, int amt) {
        accnum = num;
        amount = amt;
    }

    public void deposit(int amt) {
        amount = amount + amt;
    }

    public void withdraw(int amt) throws FundsInsufficientException {
        if (amt > amount) {
            throw new FundsInsufficientException(amount, amt);
        } else {
            amount = amount - amt;
        }
    }
}

class FundsInsufficientException extends Exception {

    int balance;
    int withdraw_amount;

    FundsInsufficientException(int bal, int w_amt) {
        balance = bal;
        withdraw_amount = w_amt;
    }

    public String toString() {
        return "Your withdraw amount (" + withdraw_amount + ") is less than the balance ("+balance+"). No withdrawal was recorded.";
        }
}


