package atm.bank.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{

    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 1550, 930);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(500,300,800,45);
        l4.add(l1);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(400,370,150,35);
        l4.add(l2);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(400,420,200,35);
        l4.add(l3);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(550,370,180,25);
        l4.add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(550,420,180,25);
        l4.add(t2);

        b1 = new JButton("CHANGE");
        b1.setBounds(730,500,150,30);
        l4.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("BACK");
        b2.setBounds(730,535,150,30);
        l4.add(b2);
        b2.addActionListener(this);

        setLayout(null);
        setSize(1580,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

    }


    public static void main(String[] args){

        new Pin("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = t1.getText();
            String pin2 = t2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }

            if(e.getSource()==b1){
               if(t1.getText().equals("")) {
                   JOptionPane.showMessageDialog(null,"Enter New PIN");
                   return;
               }else if( t2.getText().equals("")) {
                   JOptionPane.showMessageDialog(null,"Enter Re-Enter New PIN");
                   return;
               }

               Conn c = new Conn();
               String q1 = "UPDATE bank SET pin ='"+pin1+"' WHERE pin ='"+pin+"'";
               String q2 = "UPDATE login SET pin ='"+pin1+"' WHERE pin ='"+pin+"'";
               String q3 = "UPDATE signUp3 SET pin ='"+pin1+"' WHERE pin ='"+pin+"'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(pin1);

            } else if (e.getSource()==b2) {
                setVisible(false);
                new Transactions(pin);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
