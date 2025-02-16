package atm.bank.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 930);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(430,300,400,35);
        l3.add(l1);

        t1 = new JTextField();
        t1.setBackground(new Color(65,126,128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(430,340,320,25);
        l3.add(t1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(730,500,150,30);
        b1.setBackground(new Color(65,126,128));
        b1.setForeground(Color.WHITE);
        l3.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("BACK");
        b2.setBounds(730,535,150,30);
        b2.setBackground(new Color(65,126,128));
        b2.setForeground(Color.WHITE);
        l3.add(b2);
        b2.addActionListener(this);

        setLayout(null);

        setSize(1550,1080);
        setUndecorated(true);
        setLocation(0,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        new Deposit("").setVisible(true);
    }
}
