package atm.bank.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 1550, 930);
        add(l2);


        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 25));
        l1.setBounds(410,300,700,50);
        l2.add(l1);


        b1 = new JButton("DEPOSIT");
        b1.setBounds(280,430,200,30);
        l2.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(680,430,200,30);
        l2.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("FAST CASH");
        b3.setBounds(280,465,200,30);
        l2.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(680,465,200,30);
        l2.add(b4);
        b4.addActionListener(this);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(280,500,200,30);
        l2.add(b5);
        b5.addActionListener(this);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(680,500,200,30);
        l2.add(b6);
        b6.addActionListener(this);

        b7 = new JButton("EXIT");
        b7.setBounds(680,535,200,30);
        l2.add(b7);
        b7.addActionListener(this);

        setLayout(null);




        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pin);
        }else if(ae.getSource()==b2){
            setVisible(false);
            new Withdrawal(pin);
        }else if(ae.getSource()==b3){
            setVisible(false);
            new FastCash(pin);
        }else if(ae.getSource()==b4){
            new MiniStatement(pin);
        }else if(ae.getSource()==b5){
            setVisible(false);
            new Pin(pin);
        }else if(ae.getSource()==b6){
            this.setVisible(false);
            new BalanceEnquiry(pin);
        }else if(ae.getSource()==b7){
            System.exit(0);
        }
    }

    public static void main(String[] args){

        new Transactions("").setVisible(true);
    }
}
