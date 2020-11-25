import javax.swing.*;
import java.awt.event.*;

public class HomeGUI extends JFrame implements ActionListener
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel label;
    public static JButton button1,button2,button3,button4,custLoginBtn,adminLoginBtn,closeWindowBtn;

    public static void main(String args[])
    {
        frame = new JFrame("ShopOnline - E-Commerce Platform");
        panel = new JPanel();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        closeWindowBtn = new JButton("Close");
        closeWindowBtn.setBounds(400,20,70,25);
        closeWindowBtn.addActionListener(new HomeGUI());
        panel.add(closeWindowBtn);

        label = new JLabel("ShopOnline");
        label.setBounds(200,20,80,25);
        panel.add(label);

        button1 = new JButton("Customer Registration");
        button1.setBounds(100,60,250,25);
        button1.addActionListener(new HomeGUI());
        panel.add(button1);

        button2 = new JButton("Administrator Registration");
        button2.setBounds(100,100,250,25);
        button2.addActionListener(new HomeGUI());
        panel.add(button2);

        button3 = new JButton("Customer Password Change");
        button3.setBounds(100,160,250,25);
        button3.addActionListener(new HomeGUI());
        panel.add(button3);

        button4 = new JButton("Administrator Password Change");
        button4.setBounds(100,200,250,25);
        button4.addActionListener(new HomeGUI());
        panel.add(button4);

        custLoginBtn = new JButton("Customer Login");
        custLoginBtn.setBounds(120,260,210,25);
        custLoginBtn.addActionListener(new HomeGUI());
        panel.add(custLoginBtn);

        adminLoginBtn = new JButton("Administrator Login");
        adminLoginBtn.setBounds(120,300,210,25);
        adminLoginBtn.addActionListener(new HomeGUI());
        panel.add(adminLoginBtn);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button1)
        {
            System.out.println("Button1 Pressed...Opening Customer Registration");
            new CustGUI();
        }
        else if(e.getSource()==button2)
        {
            System.out.println("Button2 Pressed...Opening Admin Registration");
            new AdminGUI();
        }
        else if(e.getSource()==button3)
        {
            System.out.println("Button3 Pressed...Opening Customer Password Change");
            new CustomerPasswordChange();
        }
        else if(e.getSource()==button4)
        {
            System.out.println("Button4 Pressed...Opening Admin Password Change");
            new AdminPasswordChange();
        }
        else if(e.getSource()==custLoginBtn)
        {
            System.out.println("custLoginBtn Pressed...Opening Customer Login");
            new CustLogin();
        }
        else if(e.getSource()==adminLoginBtn)
        {
            System.out.println("adminLoginBtn Pressed...Opening Admin Login");
            new AdminLogin();
        }
        else if(e.getSource()==closeWindowBtn)
        {
            frame.dispose();
        }
    }
}


