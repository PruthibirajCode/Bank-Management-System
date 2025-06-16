import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw,back;
    String pin;
    Withdrawal(String pin){
        setLayout(null);
        this.pin=pin;

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\atm (1).jpg");
        Image i1=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(210,300,600,35);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                try {


                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pin + "','" + date + "','Withdraw','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawal successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception re) {
                    System.out.println(re);
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }
}

