import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastCase,ministatement,pinchange,balanceEnquiry,exit;
    String pin;
    Transactions(String pin){
        setLayout(null);
        this.pin=pin;

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\atm (1).jpg");
        Image i2=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i2);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(225,300,600,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposite=new JButton("Deposit");
        deposite.setBounds(170,415,150,30);
        deposite.setBackground(Color.WHITE);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw=new JButton("Cash Withdrawal");
        withdraw.setBounds(355,415,150,30);
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCase=new JButton("Fast Cash");
        fastCase.setBounds(170,450,150,30);
        fastCase.setBackground(Color.WHITE);
        fastCase.addActionListener(this);
        image.add(fastCase);

        ministatement=new JButton("Ministatement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setBackground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
        public void actionPerformed(ActionEvent aee){
            if(aee.getSource()==exit) {
                System.exit(0);
            }else if(aee.getSource()==deposite){
                setVisible(false);
                new Deposit(pin).setVisible(true);
            }else if(aee.getSource()==withdraw){
                setVisible(false);
                new Withdrawal(pin).setVisible(true);
            }else if(aee.getSource()==fastCase){
                setVisible(false);
                new FastCash(pin).setVisible(true);
            }else if(aee.getSource()==pinchange){
                setVisible(false);
                new PinChange(pin).setVisible(true);
            }else if(aee.getSource()==balanceEnquiry){
                setVisible(false);
                new CheckBalance(pin).setVisible(true);
            }else if(aee.getSource()==ministatement){
                new MiniStatement(pin).setVisible(true);
            }

        }
    public static void main(String[] args) {
        new Transactions("");
    }
}
