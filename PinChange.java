import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField jpin,repin;
    JButton change,back;
    String pin;
    PinChange(String pin){
        this.pin=pin;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\atm (1).jpg");
        Image i1=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel jLabel=new JLabel("Change your PIN");
        jLabel.setFont(new Font("Raleway",Font.BOLD,16));
        jLabel.setBounds(250,280,600,35);
        jLabel.setForeground(Color.WHITE);
        image.add(jLabel);

        JLabel pinText=new JLabel("New PIN");
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setBounds(165,320,180,25);
        pinText.setForeground(Color.WHITE);
        image.add(pinText);

        jpin=new JPasswordField();
        jpin.setFont(new Font("Raleway",Font.BOLD,25));
        jpin.setBounds(330,320,180,25);
        jpin.addActionListener(this);
        image.add(jpin);

        JLabel repinText=new JLabel("Re-Enter New PIN");
        repinText.setFont(new Font("Raleway",Font.BOLD,16));
        repinText.setBounds(165,360,180,25);
        repinText.setForeground(Color.WHITE);
        image.add(repinText);

        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        repin.addActionListener(this);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("CANCEL");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==change) {

            try {
                String npin = jpin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter PIN");
                }

                Conn conn=new Conn();
                String query1="update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query2="update login set pin = '"+rpin+"' where pin = '"+pin+"'";
                String query3="update formthree set pin = '"+rpin+"' where pin = '"+pin+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);


            } catch (Exception ve) {
                System.out.println(ve);
            }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
