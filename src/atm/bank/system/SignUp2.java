package atm.bank.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SignUp2 extends JFrame implements ActionListener {
    JLabel heading,Religion,Category,Income,Educational,Qualification,Occupation,PAN,
            Aadhar,Senior,Existing,FormNum,FormNumRes;
    JButton Next;
    JRadioButton r1,r2,r3,r4;
    JTextField PANf,AadharF;
    JComboBox ReligionCB,CategoryCB,IncomeCB,QualificationCB,OccupationCB;
    String formno;
    SignUp2(String formno){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);


        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // make heading of second page
        heading = new JLabel("Page 2: Additonal Details");
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        heading.setBounds(280,30,600,40);
        add(heading);

        // make Label for Religion
        Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway", Font.BOLD, 18));
        Religion.setBounds(100,120,100,30);
        add(Religion);

        // make combo Box religion choice
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        ReligionCB = new JComboBox(religion);
        ReligionCB.setBackground(Color.WHITE);
        ReligionCB.setFont(new Font("Raleway", Font.BOLD, 14));
        ReligionCB.setBounds(350,120,320,30);
        add(ReligionCB);

        // make Label for Category
        Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway", Font.BOLD, 18));
        Category.setBounds(100,170,100,30);
        add(Category);

        // make combo Box Category choice
        String category[] = {"General","OBC","SC","ST","Other"};
        CategoryCB = new JComboBox(category);
        CategoryCB.setBackground(Color.WHITE);
        CategoryCB.setFont(new Font("Raleway", Font.BOLD, 14));
        CategoryCB.setBounds(350,170,320,30);
        add(CategoryCB);

        // Make Label for Income
        Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway", Font.BOLD, 18));
        Income.setBounds(100,220,100,30);
        add(Income);

        // make combo Box for Income choice
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        IncomeCB = new JComboBox(income);
        IncomeCB.setBackground(Color.WHITE);
        IncomeCB.setFont(new Font("Raleway", Font.BOLD, 14));
        IncomeCB.setBounds(350,220,320,30);
        add(IncomeCB);

        // make Label for Educational Qualification
        Educational = new JLabel("Educational");
        Educational.setFont(new Font("Raleway", Font.BOLD, 18));
        Educational.setBounds(100,270,150,30);
        add(Educational);

        Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 18));
        Qualification.setBounds(100,290,150,30);
        add(Qualification);

        // make combo Box for Educational Qualification choice
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        QualificationCB = new JComboBox(education);
        QualificationCB.setBackground(Color.WHITE);
        QualificationCB.setFont(new Font("Raleway", Font.BOLD, 14));
        QualificationCB.setBounds(350,270,320,30);
        add(QualificationCB);

        //Make Label for Occupation
        Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        Occupation.setBounds(100,340,150,30);
        add(Occupation);

        // make combo Box for Occupation choice
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        OccupationCB = new JComboBox(occupation);
        OccupationCB.setBackground(Color.WHITE);
        OccupationCB.setFont(new Font("Raleway", Font.BOLD, 14));
        OccupationCB.setBounds(350,340,320,30);
        add(OccupationCB);

        //make Lable for PAN Number
        PAN = new JLabel("PAN Number:");
        PAN.setFont(new Font("Raleway", Font.BOLD, 18));
        PAN.setBounds(100,390,150,30);
        add(PAN);

        //make text field for PAN number
        PANf = new JTextField();
        PANf.setFont(new Font("Raleway", Font.BOLD, 14));
        PANf.setBounds(350,390,320,30);
        add(PANf);


        //make Label for Aadhar number
        Aadhar = new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        Aadhar.setBounds(100,440,180,30);
        add(Aadhar);

        //make text field for Aadhar number
        AadharF = new JTextField();
        AadharF.setFont(new Font("Raleway", Font.BOLD, 14));
        AadharF.setBounds(350,440,320,30);
        add(AadharF);

        //make Label for Senior Citizen
        Senior = new JLabel("Senior Citizen:");
        Senior.setFont(new Font("Raleway", Font.BOLD, 18));
        Senior.setBounds(100,490,150,30);
        add(Senior);

        //make Radio Button for yes or No
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r1.setBounds(350,490,100,30);
        add(r1);

        r2.setBounds(460,490,100,30);
        add(r2);

        ButtonGroup ButtonGroupSenior = new ButtonGroup();
        ButtonGroupSenior.add(r1);
        ButtonGroupSenior.add(r2);

        // Make Label for Existing Account
        Existing = new JLabel("Existing Account:");
        Existing.setFont(new Font("Raleway", Font.BOLD, 18));
        Existing.setBounds(100,540,180,30);
        add(Existing);

        //make Radio Button for yes or No
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r3.setBounds(350,540,100,30);
        add(r3);

        r4.setBounds(460,540,100,30);
        add(r4);

        ButtonGroup ButtonGroupExisting = new ButtonGroup();
        ButtonGroupExisting.add(r3);
        ButtonGroupExisting.add(r4);

        // make lable for Form Number
        FormNum = new JLabel("Form No:");
        FormNum.setFont(new Font("Raleway", Font.BOLD, 13));
        FormNum.setBounds(700,10,60,30);
        add(FormNum);

        // make lable  form from number result
        FormNumRes= new JLabel( String.valueOf(formno));
        FormNumRes.setFont(new Font("Raleway", Font.BOLD, 13));
        FormNumRes.setBounds(760,10,60,30);
        add(FormNumRes);

        // make button for next
        Next = new JButton("Next");
        Next.setFont(new Font("Raleway", Font.BOLD, 14));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(570,640,100,30);
        add(Next);
        Next.addActionListener(this);

        // Frame setting

        setLayout(null);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,750);
        setLocation(500,120);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String)ReligionCB.getSelectedItem();
        String category = (String)CategoryCB.getSelectedItem();
        String income = (String)IncomeCB.getSelectedItem();
        String education = (String)QualificationCB.getSelectedItem();
        String occupation = (String)OccupationCB.getSelectedItem();

        String pan = PANf.getText();
        String aadhar = AadharF.getText();

        String scitizen = "";
        if(r1.isSelected()){
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = "No";
        }

        String eaccount = "";
        if(r3.isSelected()){
            eaccount = "Yes";
        }else if(r4.isSelected()){
            eaccount = "No";
        }

        try{
            if(AadharF.getText().equals("") || PANf.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q = "insert into signUp2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q);
                new SignUp3(formno).setVisible(true);
                setVisible(false);
            }



        }catch(Exception ex){
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new SignUp2("").setVisible(true);
    }
}
