import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{

    JLabel jLabel1,religion,category,income,education,qualification,occupation,pan,aadhar,account,scitizen;
    JComboBox religion1,category1,income1,qualification1,occupation1;
    JTextField panTextField,aadharTextField;
    JButton jButton;
    String formno;
    JRadioButton jRadioButton,jRadioButton1,jRadioButton2,jRadioButton3;
    SignupTwo(String formno){
        this.formno=formno;
        setSize(850, 800);
        getContentPane().setBackground(Color.white);
        setTitle("NEW ACCOUNT APLICATION ICON.PAGE 2");
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        jLabel1=new JLabel("Page 2:Additional Details");
        jLabel1.setFont(new Font("Osward", Font.BOLD, 22));
        jLabel1.setBounds(290, 80, 400, 30);
        add(jLabel1);

        religion=new JLabel("Religion:");
        religion.setFont(new Font("Arial", Font.BOLD, 18));
        religion.setBounds(100,140, 100, 30);

        add(religion);

        String valReligion[]={"Hindu","Muslim","Shikh","Christian","Other"};
        religion1=new JComboBox(valReligion);
        religion1.setBackground(Color.WHITE);
        religion1.setBounds(300,140, 400, 30);
        religion1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(religion1);


        category=new JLabel("Category:");
        category.setFont(new Font("Arial", Font.BOLD, 18));
        category.setBounds(100,190, 200, 30);
        add(category);

        String valCategory[]={"General","OBC","SC","ST","Other"};
        category1=new JComboBox(valCategory);
        category1.setBackground(Color.WHITE);
        category1.setBounds(300,190, 400, 30);
        category1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(category1);

        income=new JLabel("Income:");
        income.setFont(new Font("Arial", Font.BOLD, 18));
        income.setBounds(100,240, 200, 30);
        add(income);

        String valIncome[]={"Null","10000-50000","50001-100000","100001-500000","More then 500000"};
        income1=new JComboBox(valIncome);
        income1.setBackground(Color.WHITE);
        income1.setBounds(300,240, 400, 30);
        income1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(income1);

        education=new JLabel("Educational");
        education.setFont(new Font("Arial", Font.BOLD, 18));
        education.setBounds(100,290, 150, 30);
        add(education);

        qualification=new JLabel("Qualificaton:");
        qualification.setFont(new Font("Arial", Font.BOLD, 18));
        qualification.setBounds(100,315, 200, 30);
        add(qualification);

        String valQualification[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Other"};
        qualification1=new JComboBox(valQualification);
        qualification1.setBackground(Color.WHITE);
        qualification1.setBounds(300,315, 400, 30);
        qualification1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(qualification1);

        occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Arial", Font.BOLD, 18));
        occupation.setBounds(100,390, 200, 30);
        add(occupation);

        String valOccupation[]={"Salaried","Self-Employed","Businessmen","Student","Other"};
        occupation1=new JComboBox(valOccupation);
        occupation1.setBackground(Color.WHITE);
        occupation1.setBounds(300,390, 400, 30);
        occupation1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(occupation1);


        pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Arial", Font.BOLD, 18));
        pan.setBounds(100,440, 150, 30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setBounds(300,440, 400, 30);
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(panTextField);

        aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Arial", Font.BOLD, 18));
        aadhar.setBounds(100,490, 150, 30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setBounds(300,490, 400, 30);
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadharTextField);

        scitizen=new JLabel("Senior Citizen:");
        scitizen.setFont(new Font("Arial", Font.BOLD, 18));
        scitizen.setBounds(100,540, 150, 30);
        add(scitizen);

        jRadioButton=new JRadioButton("Yes");
        jRadioButton.setBounds(300,540,200,30);
        jRadioButton.setBackground(Color.WHITE);
        add(jRadioButton);

        jRadioButton1=new JRadioButton("No");
        jRadioButton1.setBounds(600,540,200,30);
        jRadioButton1.setBackground(Color.WHITE);
        add(jRadioButton1);


        account=new JLabel("Existing Account:");
        account.setFont(new Font("Arial", Font.BOLD, 18));
        account.setBounds(100,590, 200, 30);
        add(account);

        jRadioButton2=new JRadioButton("Yes");
        jRadioButton2.setBounds(300,590,200,30);
        jRadioButton2.setBackground(Color.WHITE);
        add(jRadioButton2);

        jRadioButton3=new JRadioButton("No");
        jRadioButton3.setBounds(600,590,200,30);
        jRadioButton3.setBackground(Color.WHITE);
        add(jRadioButton3);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);


        jButton=new JButton("Next");
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        jButton.setFont(new Font("Raleway", Font.BOLD,14));
        jButton.setBounds(620,660,80,30);
        jButton.addActionListener(this);
        add(jButton);



        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        String religion=(String) religion1.getSelectedItem();
        String category=(String) category1.getSelectedItem();
        String income=(String) income1.getSelectedItem();
        String education=(String) qualification1.getSelectedItem();
        String occupation=(String) occupation1.getSelectedItem();
        String scitizen=null;
        if(jRadioButton.isSelected()){
            scitizen="Yes";
        }else if(jRadioButton1.isSelected()){
            scitizen="No";
        }
        String account=null;
        if(jRadioButton2.isSelected()){
            account="Yes";
        } else if(jRadioButton3.isSelected()){
            account="No";
        }
        String pan=panTextField.getText();
        String aadhar=aadharTextField.getText();

        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into shiva values('"+formno+"','"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+scitizen+"', '"+account+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        }catch(Exception ae){
            System.out.println(ae);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

