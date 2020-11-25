import javax.swing.*;
import java.awt.event.*;

public class CustomerLoginGUI
{
    public static void main(String args[])
    {
        CustLogin myCustomer = new CustLogin();
    }
}

class CustLogin extends JFrame implements ActionListener
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel heading, usernameStatus, overallStatus;
    public static JLabel usernameLabel, passwordLabel;
    public static JButton loginBtn,resetBtn,closeWindowBtn;
    public static JTextField usernameText;
    public static JPasswordField passwordText;
    
    public CustLogin()
    {
        frame = new JFrame("Customer Login | ShopOnline - E-Commerce Platform");
        panel = new JPanel();
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        closeWindowBtn = new JButton("Close");
        closeWindowBtn.setBounds(400,20,70,25);
        closeWindowBtn.addActionListener(this);
        panel.add(closeWindowBtn);

        heading = new JLabel("Customer Login");
        heading.setBounds(200,20,180,25);
        panel.add(heading);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(100,50,180,25);
        panel.add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(170,50,180,25);
        panel.add(usernameText);

        usernameStatus = new JLabel("Username Availability: ");
        usernameStatus.setBounds(140,80,400,25);
        panel.add(usernameStatus);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(100,120,180,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(190,120,180,25);
        panel.add(passwordText);

        overallStatus = new JLabel("Status: ");
        overallStatus.setBounds(200,170,400,25);
        panel.add(overallStatus);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(170,200,100,25);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(300,200,100,25);
        resetBtn.addActionListener(this);
        panel.add(resetBtn);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==resetBtn)
       {
            System.out.println("RESET PRESSED");
            usernameText.setText("");
            passwordText.setText("");
            usernameStatus.setText("Username Availability: ");
            overallStatus.setText("Status: ");
       }
       else if(e.getSource()==loginBtn)
       {
           System.out.println("LOGIN PRESSED");
           usernameStatus.setText("Username Availability: ");
           if(usernameText.getText().equals(""))
           {
                usernameStatus.setText("Username Availability: "+"Username Invalid");
                overallStatus.setText("Status: "+"Username Invalid.");
           }
           else if(Customer.checkUsername(usernameText.getText())==1)
           {
                usernameStatus.setText("Username Availability: "+"Customer Found");
                overallStatus.setText("Status: "+"Username Valid.");

                Customer returningCustomer = new Customer("customer");

                returningCustomer.readFromFile(usernameText.getText().trim());

                if(passwordText.getText().trim().equals(returningCustomer.getPassword()))
                {
                    overallStatus.setText("Status: "+"Login Successful.");
                    // new CustProfileView(returningCustomer.getUsername());
                    CustomerArea tabObj =   new CustomerArea(returningCustomer.getUsername()); 
                    tabObj.productTable();
                    tabObj.createCartTable();
                }
                else
                {
                    overallStatus.setText("Status: "+"Password Incorrect.");
                }
           }
           else
           {
                usernameStatus.setText("Username Availability: "+"Username not found");
                overallStatus.setText("Status: "+"Customer Not Found.");
           }
        }
        else if(e.getSource()==closeWindowBtn)
        {
            frame.dispose();
        }
    }
    }