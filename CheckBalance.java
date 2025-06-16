import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckBalance extends JFrame implements ActionListener {
    JButton back;
    String pin;
    CheckBalance(String pin) {
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Dell\\Downloads\\atm (1).jpg");
        Image i1 = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel image = new JLabel(imageIcon1);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin= '" + pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }

            JLabel text = new JLabel("Your current account balance is Rs " + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170, 300, 400, 30);
            image.add(text);

            setSize(900, 900);
            setLocation(300, 0);
            setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

            setVisible(false);
            new Transactions(pin).setVisible(true);

    }
    public static void main(String[] args) {
        new CheckBalance("");
    }
}
