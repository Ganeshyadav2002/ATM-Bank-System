package atm.bank.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 930);
        add(l3);

        JLabel l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(440, 300, 700, 35);
        l3.add(l1);

        b1 = new JButton("Rs. 100");
        b1.setBounds(280, 430, 200, 30);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setBounds(680, 430, 200, 30);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setBounds(280, 465, 200, 30);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setBounds(680, 465, 200, 30);
        l3.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setBounds(280, 500, 200, 30);
        l3.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setBounds(680, 500, 200, 30);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(680, 535, 200, 30);
        l3.add(b7);

        setLayout(null);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(1550, 1080);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b7) {
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }else{
            try{

                String amount = ((JButton)ae.getSource()).getText().substring(4);
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("mode").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                } String num = "17";
                if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {

        new FastCash("").setVisible(true);
    }
}

