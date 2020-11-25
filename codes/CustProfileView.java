import javax.swing.*;
import java.awt.event.*;

public class CustProfileView
{
    CustProfileView(String uName)
    {
            CustomerProfile myCustomer = new CustomerProfile(uName);
    }
    public static void main(String args[])
    {
        
    }
}

class CustomerProfile extends JFrame implements ActionListener
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel heading, usernameStatus, overallStatus;
    public static JLabel usernameLabel,fullnameLabel,accesslevelLabel,dobLabel,addressLabel,phoneLabel,emailLabel,paymentPrefLabel;
    public static JButton closeWindowBtn;
    
    public CustomerProfile(String custUsername)
    {

        Customer myCust = new Customer("customer");
        myCust.readFromFile(custUsername);

        frame = new JFrame("Customer Profile View | ShopOnline - E-Commerce Platform");
        panel = new JPanel();
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        closeWindowBtn = new JButton("Close");
        closeWindowBtn.setBounds(400,20,70,25);
        closeWindowBtn.addActionListener(this);
        panel.add(closeWindowBtn);

        heading = new JLabel("Customer Profile");
        heading.setBounds(200,20,180,25);
        panel.add(heading);

        usernameLabel = new JLabel("Username: "+myCust.getUsername());
        usernameLabel.setBounds(100,50,180,25);
        panel.add(usernameLabel);

        fullnameLabel = new JLabel("Full Name: "+myCust.getFullname());
        fullnameLabel.setBounds(100,90,180,25);
        panel.add(fullnameLabel);

        accesslevelLabel = new JLabel("Access Level: "+myCust.getAccessLevel());
        accesslevelLabel.setBounds(100,130,180,25);
        panel.add(accesslevelLabel);

        dobLabel = new JLabel("Date of Birth: "+myCust.getDOB());
        dobLabel.setBounds(100,170,180,25);
        panel.add(dobLabel);

        addressLabel = new JLabel("Address: "+myCust.getAddress());
        addressLabel.setBounds(100,210,180,25);
        panel.add(addressLabel);

        phoneLabel = new JLabel("Phone: "+myCust.getPhone());
        phoneLabel.setBounds(100,250,180,25);
        panel.add(phoneLabel);

        emailLabel = new JLabel("Email: "+myCust.getEmail());
        emailLabel.setBounds(100,290,180,25);
        panel.add(emailLabel);

        paymentPrefLabel = new JLabel("Payment Preference: "+myCust.getPaymentPreference());
        paymentPrefLabel.setBounds(100,330,180,25);
        panel.add(paymentPrefLabel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==closeWindowBtn)
        {
            frame.dispose();
        }
    }
    }