import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setSize(850,820);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setBounds(280,40,400,40);
        l1.setFont(new Font("Osward", Font.BOLD,22));
        add(l1);

        JLabel type=new JLabel("Account Type:");
        type.setBounds(100,140,200,30);
        type.setFont(new Font("Raleway", Font.BOLD,22));
        add(type);

        r1=new JRadioButton("Saving Account ");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        JLabel card=new JLabel("Card Number");
        card.setBounds(100,300,200,30);
        card.setFont(new Font("Raleway", Font.BOLD,22));
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setBounds(330,300,300,30);
        number.setFont(new Font("Raleway", Font.BOLD,22));
        add(number);

        JLabel cardDetail=new JLabel("Your 16 digit Card Number");
        cardDetail.setBounds(100,330,300,20);
        cardDetail.setFont(new Font("Raleway", Font.BOLD,12));
        add(cardDetail);

        JLabel pin=new JLabel("PIN:");
        pin.setBounds(100,370,200,30);
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        add(pin);

        JLabel number1=new JLabel("XXXX");
        number1.setBounds(330,370,300,30);
        number1.setFont(new Font("Raleway", Font.BOLD,22));
        add(number1);

        JLabel pinDetail=new JLabel("Your 4 digit PIN");
        pinDetail.setBounds(100,400,300,20);
        pinDetail.setFont(new Font("Raleway", Font.BOLD,12));
        add(pinDetail);

        JLabel service=new JLabel("Services Required:");
        service.setBounds(100,450,250,30);
        service.setFont(new Font("Raleway", Font.BOLD,22));
        add(service);

        c1=new JCheckBox("ATM Card");
        c1.setBounds(100,500,200,30);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(350,500,200,30);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,550,200,30);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        add(c3);

        c4=new JCheckBox("EMAIL & SMS Alerts");
        c4.setBounds(350,550,200,30);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,600,200,30);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(350,600,200,30);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        add(c6);

        c7=new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,680,600,30);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
        setLocation(350,0);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String type=null;
            if(r1.isSelected()){
                type="Saving Account";
            }else if(r2.isSelected()){
                type="Fixed Deposit Account";
            }else if(r3.isSelected()){
                type="Current Account";
            }else if(r4.isSelected()){
                type="Recurring Deposit Account";
            }
            Random random=new Random();
            String card=""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pin=""+ Math.abs((random.nextLong() % 9000L) + 1000L);

            String service="";
            if(c1.isSelected()){
                service=service+" ATM Card";
            }else if(c2.isSelected()){
                service=service+" Internet Banking";
            }else if(c3.isSelected()){
                service=service+" Mobile Banking";
            } else if(c4.isSelected()){
                service=service+" EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                service=service+" Cheque Book";
            }else if(c6.isSelected()){
                service=service+" E-Statement";
            }
            try{
                if(service.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                else{
                    Conn con=new Conn();
                    String query1="insert into formthree values('"+formno+"','"+type+"','"+card+"','"+pin+"','"+service+"')";
                    String query2="insert into login values('"+formno+"','"+card+"','"+pin+"')";
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " + card + "\n Pin: " + pin);

                    setVisible(false);
                    new Deposit(pin).setVisible(false);

                }
            }catch(Exception re){
                System.out.println(re);
            }
        }else if(e.getSource()==cancel){
                setVisible(false);
                new BankManagement().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
