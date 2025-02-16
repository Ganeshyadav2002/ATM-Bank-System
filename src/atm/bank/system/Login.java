
package atm.bank.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton SignIn,SignUp ,clear;
    JTextField TF_cardNum;
    JPasswordField TF_PIN;
    Login(){
        setTitle("ATM Project by Ganesh");
        // penal color
        getContentPane().setBackground(Color.white);

        // set icon of logo on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Llogo = new JLabel(i3);
        Llogo.setBounds(100, 10, 100, 100);
        add(Llogo);

        // make heading of login frame
        JLabel heading = new JLabel("WELCOME TO ATM");
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        heading.setBounds(300,40,450,40);
        add(heading);

        // make label for card number
        JLabel cardNumLabel = new JLabel("Card No:");
        cardNumLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNumLabel.setBounds(225,150,375,30);
        add(cardNumLabel);

        // make Text field for card number
        TF_cardNum = new JTextField(15);
        TF_cardNum.setBounds(400,150,230,30);
        TF_cardNum.setFont(new Font("Arial", Font.BOLD, 14));
        add(TF_cardNum);

        // make  pin number Label
        JLabel pinNumLabel = new JLabel("PIN :");
        pinNumLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        pinNumLabel.setBounds(275,250,375,30);
        add(pinNumLabel);

        // make password field  for pin number
        TF_PIN = new JPasswordField(15);
        TF_PIN.setBounds(400,250,230,30);
        TF_PIN.setFont(new Font("Arial", Font.BOLD, 14));
        add(TF_PIN);

        // make three button

        // first make sing in button
        SignIn = new JButton("SIGN IN");
        SignIn.setFont(new Font("Arial",Font.BOLD,15));
        SignIn.setBounds(300,350,200,40);
        SignIn.setBackground(Color.BLACK);
        SignIn.setForeground(Color.white);
        add(SignIn);
        SignIn.addActionListener(this);

        // second make clear button
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Arial",Font.BOLD,15));
        clear.setBounds(550,350,200,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        add(clear);
        clear.addActionListener(this);

        // third make sing up button
        SignUp = new JButton("SIGN Up");
        SignUp.setFont(new Font("Arial",Font.BOLD,14));
        SignUp.setBounds(800,20,100,40);
        SignUp.setBackground(Color.BLUE);
        SignUp.setForeground(Color.BLACK);
        add(SignUp);
        SignUp.addActionListener(this);

        setUndecorated(true);
        setLayout(null);
        setSize(1000,500);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            if(ae.getSource()==SignIn){
                Conn c = new Conn();
                String cardNum = TF_cardNum.getText();
                String PIN = TF_PIN.getText();
                String query = "SELECT * FROM login where card_no ='"+cardNum+"' and pin ='"+PIN+"'";
                ResultSet resultSet = c.s.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Transactions(PIN);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card Number or PIN");
                }

            } else if (ae.getSource()==SignUp) {
                new SignUp1();
                setVisible(false);
            } else if (ae.getSource()==clear) {
                TF_cardNum.setText("");
                TF_PIN.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
