import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BankManagement extends JFrame implements ActionListener{

    JButton jButton,jButton1,jButton2;
    JTextField jTextField;
    JPasswordField jTextField1;

    BankManagement(){
        setSize(800,480);
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("D:\\Siva\\Personal Documents\\java projects\\bank management system\\src\\logo (1).jpg");
        Image image=imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel jLabel=new JLabel(imageIcon1);
        jLabel.setBounds(70, 10, 100, 100);
        add(jLabel);

        JLabel jLabel1=new JLabel("Welcome To ATM");
        jLabel1.setFont(new Font("Osward", Font.BOLD, 38));
        jLabel1.setBounds(200, 40, 500, 40);
        add(jLabel1);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        jTextField=new JTextField();
        jTextField.setBounds(300,150,300,30);
        jTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(jTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);

        jTextField1=new JPasswordField();
        jTextField1.setBounds(300,220,300,30);
        jTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(jTextField1);

        jButton=new JButton("SIGN IN");
        jButton.setBounds(300, 300, 100, 30);
        jButton.addActionListener(this);
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        add(jButton);

        jButton1=new JButton("CLEAR");
        jButton1.setBounds(500, 300, 100, 30);
        jButton1.addActionListener(this);
        jButton1.setBackground(Color.BLACK);
        jButton1.setForeground(Color.WHITE);
        add(jButton1);

        jButton2=new JButton("SIGN UP");
        jButton2.setBounds(300, 350, 300, 30);
        jButton2.addActionListener(this);
        jButton2.setBackground(Color.BLACK);
        jButton2.setForeground(Color.WHITE);
        add(jButton2);



        getContentPane().setBackground(Color.white);
        setVisible(true);

        setLocation(350,250);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jButton1){
            jTextField.setText("");
            jTextField1.setText("");
        }else if(ae.getSource() == jButton){
            Conn conn=new Conn();
            String cardno=jTextField.getText();
            String pin=jTextField1.getText();
            String query="select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";
            try{
                ResultSet r=conn.s.executeQuery(query);
                if(r.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN..");
                }
            }catch(Exception e){
                System.out.println(e);
            }


        } else if(ae.getSource() == jButton2){
                setVisible(false);
                new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BankManagement();
    }
}
