import javax.swing.*;
import java.awt.event.*;

public class CustRegisterGUI
{
    public static void main(String args[])
    {
        CustGUI myCustGUI = new CustGUI();
    }
}

class CustGUI extends JFrame implements ActionListener
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel heading, usernameStatus, overallStatus;
    public static JLabel usernameLabel, fullnameLabel, passwordLabel, dobLabel, addressLabel, phoneLabel, emailLabel, paymentprefLabel;
    public static JButton signupBtn,resetBtn,closeWindowBtn;
    public static JTextField usernameText, fullnameText, dobText, addressText, phoneText, emailText, paymentprefText;
    public static JPasswordField passwordText;
    
    public CustGUI()
    {
        frame = new JFrame("Customer Register | ShopOnline - E-Commerce Platform");
        panel = new JPanel();
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        closeWindowBtn = new JButton("Close");
        closeWindowBtn.setBounds(400,20,70,25);
        closeWindowBtn.addActionListener(this);
        panel.add(closeWindowBtn);

        heading = new JLabel("Customer Registration");
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
        passwordText.setBounds(170,120,180,25);
        panel.add(passwordText);


        fullnameLabel = new JLabel("Full Name (use '-' to seperate words): ");
        fullnameLabel.setBounds(100,150,250,25);
        panel.add(fullnameLabel);

        fullnameText = new JTextField(20);
        fullnameText.setBounds(320,150,180,25);
        panel.add(fullnameText);


        dobLabel = new JLabel("DOB (dd/mm/yyyy format): ");
        dobLabel.setBounds(100,180,180,25);
        panel.add(dobLabel);

        dobText = new JTextField(20);
        dobText.setBounds(250,180,180,25);
        panel.add(dobText);


        addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(100,210,180,25);
        panel.add(addressLabel);

        addressText = new JTextField(20);
        addressText.setBounds(170,210,180,25);
        panel.add(addressText);


        phoneLabel = new JLabel("Phone Number (10 digits): ");
        phoneLabel.setBounds(100,240,180,25);
        panel.add(phoneLabel);

        phoneText = new JTextField(20);
        phoneText.setBounds(250,240,180,25);
        panel.add(phoneText);        

        emailLabel = new JLabel("Email Address: ");
        emailLabel.setBounds(100,270,180,25);
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(200,270,180,25);
        panel.add(emailText);  


        paymentprefLabel = new JLabel("Payment Preference (COD/UPI/Card): ");
        paymentprefLabel.setBounds(100,300,220,25);
        panel.add(paymentprefLabel);

        paymentprefText = new JTextField(20);
        paymentprefText.setBounds(320,300,180,25);
        panel.add(paymentprefText); 

        overallStatus = new JLabel("Status: ");
        overallStatus.setBounds(200,360,400,25);
        panel.add(overallStatus);

        signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(170,390,100,25);
        signupBtn.addActionListener(this);
        panel.add(signupBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(300,390,100,25);
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
            addressText.setText("");
            fullnameText.setText("");
            phoneText.setText("");
            emailText.setText("");
            paymentprefText.setText("");
            dobText.setText("");
            usernameStatus.setText("Username Availability: ");
            overallStatus.setText("Status: ");
       }
       else if(e.getSource()==signupBtn)
       {
           System.out.println("SIGN UP PRESSED");
           usernameStatus.setText("Username Availability: ");
           if(Customer.checkUsername(usernameText.getText())==1)
           {
                usernameStatus.setText("Username Availability: "+"Username Taken");
                overallStatus.setText("Status: "+"Username Taken.");
                System.out.println("Username Taken");
           }
           else
           {
                if(!usernameText.getText().equals(""))
                    usernameStatus.setText("Username Availability: "+"Available");
                else
                    usernameStatus.setText("Username Availability: "+"Invalid Username");
                try
                {
                        Customer custObj = new Customer("customer");
                        custObj.setUsername(usernameText.getText());
                        custObj.setPassword(passwordText.getText());
                        custObj.setAddress(addressText.getText());
                        custObj.setFullname(fullnameText.getText());
                        custObj.setPhone(Long.parseLong(phoneText.getText()));
                        custObj.setEmail(emailText.getText());
                        custObj.setPaymentPreference(paymentprefText.getText());
                        custObj.setDOB(dobText.getText());

                        custObj.writeToFile();

                        overallStatus.setText("Status: "+"Successfully Registered");
                        usernameStatus.setText("Username Availability: "+"Successfully Registered");

                }
                catch(Exception err)
                {
                    overallStatus.setText("Status: "+"Error Found. Check values entered...");
                    System.out.println("Error Encountered");
                }
                
            }
        }
        else if(e.getSource()==closeWindowBtn)
        {
            frame.dispose();
        }
    }
    }