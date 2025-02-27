package atm.bank.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    Withdrawal(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 930);
        add(l3);


        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.1,00,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(410,300,700,50);
        l3.add(l1);

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(445,370,400,30);
        l3.add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 16));
        t1.setBounds(410,400,330,30);
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        l3.add(t1);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(680,500,200,30);
        b1.setBackground(new Color(68,128,128));
        b1.setForeground(Color.WHITE);
        l3.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("BACK");
        b2.setBounds(680,535,200,30);
        b2.setBackground(new Color(68,128,128));
        b2.setForeground(Color.WHITE);
        l3.add(b2);
        b2.addActionListener(this);

        setLayout(null);


        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

@Override
   public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();

                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("mode").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }

    }



    public static void main(String[] args){

        new Withdrawal("").setVisible(true);
    }
}

