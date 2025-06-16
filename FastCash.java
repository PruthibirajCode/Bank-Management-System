import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton deposite,withdraw,fastCase,ministatement,pinchange,balanceEnquiry,exit;
    String pin;
    FastCash(String pin){
        setLayout(null);
        this.pin=pin;

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\atm (1).jpg");
        Image i2=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i2);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select your Withdrawal amount");
        text.setBounds(225,300,600,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposite=new JButton("Rs 100");
        deposite.setBounds(170,415,150,30);
        deposite.setBackground(Color.WHITE);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw=new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCase=new JButton("Rs 1000");
        fastCase.setBounds(170,450,150,30);
        fastCase.setBackground(Color.WHITE);
        fastCase.addActionListener(this);
        image.add(fastCase);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.setBackground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry=new JButton("Rs 10000");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("BACK");
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
           setVisible(false);
           new Transactions(pin).setVisible(true);
        }else{
            String amount=((JButton)aee.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try{
                ResultSet rs=conn.s.executeQuery("select * from bank where pin= '"+pin+"'");
                int balance=0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(aee.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date=new Date();
                String query="insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
