import javax.swing.*;
import java.awt.event.*;

public class AdminPasswordChangeGUI
{
    public static void main(String args[])
    {
        AdminPasswordChange myAdmin = new AdminPasswordChange();
    }
}

class AdminPasswordChange extends JFrame implements ActionListener
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel heading, usernameStatus, overallStatus;
    public static JLabel usernameLabel, oldPasswordLabel, newPasswordLabel;
    public static JButton confirmBtn,resetBtn,closeWindowBtn;
    public static JTextField usernameText;
    public static JPasswordField oldPasswordText,newPasswordText;
    
    public AdminPasswordChange()
    {
        frame = new JFrame("Change Admin Password | ShopOnline - E-Commerce Platform");
        panel = new JPanel();
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        closeWindowBtn = new JButton("Close");
        closeWindowBtn.setBounds(400,20,70,25);
        closeWindowBtn.addActionListener(this);
        panel.add(closeWindowBtn);

        heading = new JLabel("Change Admin Password");
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

        oldPasswordLabel = new JLabel("Old Password: ");
        oldPasswordLabel.setBounds(100,120,180,25);
        panel.add(oldPasswordLabel);

        oldPasswordText = new JPasswordField();
        oldPasswordText.setBounds(190,120,180,25);
        panel.add(oldPasswordText);

        newPasswordLabel = new JLabel("New Password: ");
        newPasswordLabel.setBounds(100,150,180,25);
        panel.add(newPasswordLabel);

        newPasswordText = new JPasswordField();
        newPasswordText.setBounds(190,150,180,25);
        panel.add(newPasswordText);

        overallStatus = new JLabel("Status: ");
        overallStatus.setBounds(200,360,400,25);
        panel.add(overallStatus);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(170,390,100,25);
        confirmBtn.addActionListener(this);
        panel.add(confirmBtn);

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
            oldPasswordText.setText("");
            newPasswordText.setText("");
            usernameStatus.setText("Username Availability: ");
            overallStatus.setText("Status: ");
       }
       else if(e.getSource()==confirmBtn)
       {
           System.out.println("CONFIRM PRESSED");
           usernameStatus.setText("Username Availability: ");
           if(Admin.checkUsername(usernameText.getText())==1)
           {
                usernameStatus.setText("Username Availability: "+"Admin Found");
                overallStatus.setText("Status: "+"Username Valid.");
                int result = Admin.changePassword(usernameText.getText(),oldPasswordText.getText(),newPasswordText.getText());
                if(result==0)
                {
                    overallStatus.setText("Status: "+"Changed Password Successfully");
                }
                else if(result==1)
                {
                    overallStatus.setText("Status: "+"Incorrect Old Password");
                    oldPasswordText.setText("");
                    newPasswordText.setText("");
                }
                else if(result==2)
                {
                    usernameStatus.setText("Username Availability: ");
                    overallStatus.setText("Status: "+"Error occurred in password change");
                }
           }
           else
           {
                usernameStatus.setText("Username Availability: "+"Username not found");
                overallStatus.setText("Status: "+"Admin Not Found.");
           }
        }
        else if(e.getSource()==closeWindowBtn)
        {
            frame.dispose();
        }
    }
    }