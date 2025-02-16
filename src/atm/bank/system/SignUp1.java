package atm.bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener {

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String ApplicationNumber = "" + Math.abs(first4);

    JTextField fname ,fFname,femail, faddress,fcity,fCityPin,fstate, fphoneNo;
    JRadioButton r1,r2,r3,r4,r5;
    JDateChooser dateChooser;
    SignUp1(){
        setTitle("NEW ACCOUNT APPLICATION FROM");


        // set icon of logo on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Llogo = new JLabel(i3);
        Llogo.setBounds(10, 10, 100, 100);
        add(Llogo);

        // make heading of login frame
        JLabel heading = new JLabel("APPLICATION FROM : "+ApplicationNumber);
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        heading.setBounds(140,20,600,40);
        add(heading);

        JLabel heading2 = new JLabel("Page 1: Personal Details");
        heading2.setFont(new Font("Raleway", Font.BOLD, 22));
        heading2.setBounds(290,80,600,30);
        add(heading2);


        // make Lable for NAME
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);;
        add(name);

        // make field for name
        fname = new JTextField();
        fname.setFont(new Font("Raleway", Font.BOLD, 14));
        fname.setBounds(300,140,400,30);
        add(fname);

        // make Lable for Father's NAME
        JLabel Fname = new JLabel("Father's Name:");
        Fname.setFont(new Font("Raleway", Font.BOLD, 20));
        Fname.setBounds(100,190,200,30);
        add(Fname);

        // make text field for Father's name
        fFname = new JTextField();
        fFname.setFont(new Font("Raleway", Font.BOLD, 14));
        fFname.setBounds(300,190,400,30);
        add(fFname);

        // make Lable for date of birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        //make Date of bith field using JDateChooser (calendar)
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 400, 29);
        add(dateChooser);

        // make Lable for Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        //make radio buttons for gender type
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);


        r1.setBounds(300,290,60,30);
        add(r1);

        r2.setBounds(450,290,90,30);
        add(r2);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        // make Lable for Email Address
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        // make field for Email Address
        femail = new JTextField();
        femail.setFont(new Font("Raleway", Font.BOLD, 14));
        femail.setBounds(300,340,400,30);
        add(femail);

        // make Lable for Phone Number Address
        JLabel phoneNo = new JLabel("Phone Number:");
        phoneNo.setFont(new Font("Raleway", Font.BOLD, 20));
        phoneNo.setBounds(100,390,200,30);
        add(phoneNo);

        // make field for Phone Number Address
        fphoneNo = new JTextField();
        fphoneNo.setFont(new Font("Raleway", Font.BOLD, 14));
        fphoneNo.setBounds(300,390,400,30);
        add(fphoneNo);

        // make Lable for Marital Status
        JLabel marital = new JLabel("Marital:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,440,200,30);
        add(marital);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);

        r3.setBounds(300,440,100,30);
        add(r3);

        r4.setBounds(450,440,100,30);
        add(r4);

        r5.setBounds(635,440,100,30);
        add(r5);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);

        // make Lable for Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,490,200,30);
        add(address);

        // make field for Address
        faddress = new JTextField();
        faddress.setFont(new Font("Raleway", Font.BOLD, 14));
        faddress.setBounds(300,490,400,30);
        add(faddress);

        // make Lable for City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,540,200,30);
        add(city);

        // make field for City
        fcity = new JTextField();
        fcity.setFont(new Font("Raleway", Font.BOLD, 14));
        fcity.setBounds(300,540,400,30);
        add(fcity);

        // make Lable for Pin Code City
        JLabel CityPin = new JLabel("Pin Code:");
        CityPin.setFont(new Font("Raleway", Font.BOLD, 20));
        CityPin.setBounds(100,590,200,30);
        add(CityPin);

        // make field for  Pin Code City
        fCityPin = new JTextField();
        fCityPin.setFont(new Font("Raleway", Font.BOLD, 14));
        fCityPin.setBounds(300,590,400,30);
        add(fCityPin);

        // make Lable for State :
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,640,200,30);
        add(state);

        // make field for State
        fstate = new JTextField();
        fstate.setFont(new Font("Raleway", Font.BOLD, 14));
        fstate.setBounds(300,640,400,30);
        add(fstate);

        // make Button  for Next
        JButton Next = new JButton("Next");
        Next.setFont(new Font("Arial",Font.BOLD,14));
        Next.setBounds(620,680,80,30);
        Next.setBackground(Color.black);
        Next.setForeground(Color.white);
        add(Next);
        Next.addActionListener(this);


        // penal color & SIZE
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(850,800);
        setLocation(300,20);
        setVisible(true);

    }
    public static void main(String[] args) {
        new SignUp1().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNum = ApplicationNumber;
        String name = fname.getText();
        String Fname = fFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()){
            gender = "Male" ;
        }else{
            gender = "Female";
        }

        String email = femail.getText();
        String phoneNum = fphoneNo.getText();
        String marital = null;
        if(r3.isSelected()){
            marital="Married";
        }else if(r4.isSelected()){
            marital="Unmarried";
        }else{
            marital="Other";
        }
        String address = faddress.getText();
        String city = fcity.getText();
        String pincode = fCityPin.getText();
        String State = fstate.getText();

        try{
            if(fname.getText().equals("")){
                JOptionPane.showConfirmDialog(null,"Fill all the Fields");
            }else{
                Conn conn1= new Conn();
                String Query = "insert into signUp values('"+formNum+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+phoneNum+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+State+"')";
                conn1.s.executeUpdate(Query);
                new SignUp2(formNum).setVisible(true);
                setVisible(false);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
