import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class SignupOne extends JFrame implements ActionListener{
    long random;
    JLabel jLabel,jLabel1,name,fname,dob,gender,email,marital,address,city,pin,state;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser jDateChooser;
    JButton jButton;
    JRadioButton jRadioButton,jRadioButton1,jRadioButton2,jRadioButton3,jRadioButton4;
    SignupOne(){
        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L) + 1000L);

        setSize(850, 800);
        getContentPane().setBackground(Color.white);
        setTitle("NEW ACCOUNT APLICATION ICON.PAGE 2");
        setLayout(null);

        jLabel=new JLabel("APPLICATION FORM NO. "+random);
        jLabel.setFont(new Font("Osward", Font.BOLD, 38));
        jLabel.setBounds(140, 20, 600, 40);
        add(jLabel);

        jLabel1=new JLabel("Page 1:Personal Details");
        jLabel1.setFont(new Font("Osward", Font.BOLD, 22));
        jLabel1.setBounds(290, 80, 400, 30);
        add(jLabel1);

        name=new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(100,140, 100, 30);

        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(300,140, 400, 30);
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(nameTextField);


        fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Arial", Font.BOLD, 18));
        fname.setBounds(100,190, 200, 30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setBounds(300,190, 400, 30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fnameTextField);

        dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Arial", Font.BOLD, 18));
        dob.setBounds(100,240, 200, 30);
        add(dob);

        jDateChooser=new JDateChooser();
        jDateChooser.setBounds(300,240,400,30);
        jDateChooser.setForeground(Color.BLACK);
        add(jDateChooser);

        gender=new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.BOLD, 18));
        gender.setBounds(100,290, 150, 30);
        add(gender);

        jRadioButton=new JRadioButton("Male");
        jRadioButton.setBounds(300,290,60,30);
        jRadioButton.setBackground(Color.WHITE);
        add(jRadioButton);

        jRadioButton1=new JRadioButton("Female");
        jRadioButton1.setBounds(450,290,100,30);
        jRadioButton1.setBackground(Color.WHITE);
        add(jRadioButton1);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton1);

        email=new JLabel("Email Address:");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setBounds(100,340, 200, 30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setBounds(300,340, 400, 30);
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(emailTextField);

        marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Arial", Font.BOLD, 18));
        marital.setBounds(100,390, 200, 30);
        add(marital);

        jRadioButton2=new JRadioButton("Married");
        jRadioButton2.setBounds(300,390,100,30);
        jRadioButton2.setBackground(Color.WHITE);
        add(jRadioButton2);

        jRadioButton3=new JRadioButton("Unmarried");
        jRadioButton3.setBounds(450,390,100,30);
        jRadioButton3.setBackground(Color.WHITE);
        add(jRadioButton3);

        jRadioButton4=new JRadioButton("Others");
        jRadioButton4.setBounds(600,390,100,30);
        jRadioButton4.setBackground(Color.WHITE);
        add(jRadioButton4);

        ButtonGroup buttonGroup1=new ButtonGroup();
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);

        address=new JLabel("Address:");
        address.setFont(new Font("Arial", Font.BOLD, 18));
        address.setBounds(100,440, 150, 30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setBounds(300,440, 400, 30);
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(addressTextField);

        city=new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setBounds(100,490, 150, 30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setBounds(300,490, 400, 30);
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(cityTextField);

        state=new JLabel("State:");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setBounds(100,540, 150, 30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setBounds(300,540, 400, 30);
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(stateTextField);

        pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Arial", Font.BOLD, 18));
        pin.setBounds(100,590, 150, 30);
        add(pin);

        pinTextField=new JTextField();
        pinTextField.setBounds(300,590, 400, 30);
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pinTextField);

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
        String formno="" +random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) jDateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(jRadioButton.isSelected()){
            gender="Male";
        }else if(jRadioButton1.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(jRadioButton2.isSelected()){
            marital="Married";
        } else if(jRadioButton3.isSelected()){
            marital="Unmarried";
        } else if(jRadioButton4.isSelected()){
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into shiv values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception ae){
            System.out.println(ae);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
