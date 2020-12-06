import java.io.*;
import java.util.*;


class DateClass
{
    private int dd;   
    private int mm;
    private int yyyy;

    public DateClass()
    { }

    public void setDate(String date)
    {

        String[] dateArr = date.split("/",0);

        dd = Integer.parseInt(dateArr[0]);
        mm = Integer.parseInt(dateArr[1]);
        yyyy = Integer.parseInt(dateArr[2]);
    }
    
    public String getDate()
    {
        return dd+"/"+mm+"/"+yyyy;
    }
}

class Person
{


    public static void main(String args[])
    {
        //EMPTY
    }


    public Person()
    { }

    public String username; 
    private String fullName;
    public String accessLevel; 
    protected String password; 
    private DateClass dob = new DateClass();
    private long phone;
    private String email;



    public String getAccessLevel()
    {
        return accessLevel;
    }

    public void setUsername(String s)
    {
        this.username = s;
    }
    public String getUsername()
    {
        return username;
    }
    
    public void setFullname(String s)
    {
        this.fullName = s;
    }
    public String getFullname()
    {
        return fullName;
    }

    public void setDOB(String s)
    {
        this.dob.setDate(s);
    }
    public String getDOB()
    {
        return dob.getDate();
    }
    
    public void setPhone(long ph)
    {
        this.phone = ph;
    }
    public long getPhone()
    {
        return phone;
    }

    public void setEmail(String s)
    {
        this.email = s;
    }
    public String getEmail()
    {
        return email;
    }

    public void setPassword(String s)
    {
        password = s;
    }
    public String getPassword()
    {
        return password;
    }
    
}   

interface objFileHandler {
    void readFromFile(String user);
    void writeToFile();
}

final class Customer extends Person implements objFileHandler
{
    public Customer(String accessLvl)
    {
        this.accessLevel = accessLvl;
    }

    public Customer()
    {
        System.out.println("Constructing Customer Object");
    }

    private String paymentPreference;
    private String address;

    public void setPaymentPreference(String s)
    {
        paymentPreference = s;
    }
    public String getPaymentPreference()
    {
        return paymentPreference;
    }

    public void setAddress(String s)
    {
        address = s;
    }
    public String getAddress()
    {
        return address;
    }

    


    public static int changePassword(String user, String oldPass, String newPass)
    {
        try
        {
            File myFile = new File("E:\\ShopOnlineFiles\\Person\\Customer\\"+user+".txt");
            Scanner scan = new Scanner(myFile);
            String username="", password="", fullname="", accesslevel="", dob="", addr="", phone="", email="", paymentpreference="";
            String str="";
            while(scan.hasNext())
            {
                str = scan.next();
                if(str.equals("Username:"))
                {
                    username = scan.next();
                }
                else if(str.equals("Password:"))
                {
                    password = scan.next();
                }
                else if(str.equals("Full_Name:"))
                {
                    fullname = scan.next();
                }
                else if(str.equals("Access_Level:"))
                {
                    accesslevel = scan.next();
                }
                else if(str.equals("DOB:"))
                {
                    dob = scan.next();
                }
                else if(str.equals("Address:"))
                {
                    addr = scan.next();
                }
                else if(str.equals("Phone:"))
                {
                    phone = scan.next();
                }
                else if(str.equals("Email:"))
                {
                    email = scan.next();
                }
                else if(str.equals("Payment_Preference:"))
                {
                    paymentpreference = scan.next();
                }
            }

            if(password.equals(oldPass))
                {
                    password = newPass;
                    try
                    {
                        FileWriter fileWrite = new FileWriter("E:\\ShopOnlineFiles\\Person\\Customer\\"+username+".txt");
                        fileWrite.write("Username: "+username);
                        fileWrite.write("\nPassword: "+password);
                        fileWrite.write("\nFull_Name: "+fullname);
                        fileWrite.write("\nAccess_Level: "+accesslevel);
                        fileWrite.write("\nDOB: "+dob);
                        fileWrite.write("\nAddress: "+addr);
                        fileWrite.write("\nPhone: "+phone);
                        fileWrite.write("\nEmail: "+email);
                        fileWrite.write("\nPayment_Preference: "+paymentpreference);
                        System.out.println("Customer Password Changed Successfully...");
                        fileWrite.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error writing to file.");
                        e.printStackTrace();
                        return 2;
                    }
                }
                else
                {
                    System.out.println("Old Password Incorrect !!");
                    return 1;
                }
            
            

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading from file.");
            e.printStackTrace();
            return 2;
        }
        return 0;
    }

    public static int checkUsername(String user)
    {
        String checkFileName = "E:\\ShopOnlineFiles\\Person\\Customer\\"+user+".txt";
        File myFile = new File(checkFileName);
        if(myFile.exists())
        {
            return 1;
        }
        else{
            return 0;
        }
    }

    public void writeToFile()
    {
        try
        {
            FileWriter fileWrite = new FileWriter("E:\\ShopOnlineFiles\\Person\\Customer\\"+getUsername()+".txt");
            fileWrite.write("Username: "+getUsername());
            fileWrite.write("\nPassword: "+password);
            fileWrite.write("\nFull_Name: "+getFullname());
            fileWrite.write("\nAccess_Level: "+accessLevel);
            fileWrite.write("\nDOB: "+getDOB());
            fileWrite.write("\nAddress: "+address);
            fileWrite.write("\nPhone: "+getPhone());
            fileWrite.write("\nEmail: "+getEmail());
            fileWrite.write("\nPayment_Preference: "+paymentPreference);
            fileWrite.close();
            System.out.println("Customer details written to file "+getUsername()+".txt successfully.");
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public void readFromFile(String user)
    {
        try
        {
            File myFile = new File("E:\\ShopOnlineFiles\\Person\\Customer\\"+user+".txt");
            Scanner scan = new Scanner(myFile);
            String username="", pwd="", fullname="", accesslevel="", dob="", addr="", phone="", email="", paymentpreference="";
            String str="";
            while(scan.hasNext())
            {
                str = scan.next();
                if(str.equals("Username:"))
                {
                    username = scan.next();
                    setUsername(username);
                }
                else if(str.equals("Password:"))
                {
                    pwd = scan.next();
                    password = pwd;
                }
                else if(str.equals("Full_Name:"))
                {
                    fullname = scan.next();
                    setFullname(fullname);
                }
                else if(str.equals("Access_Level:"))
                {
                    accesslevel = scan.next();
                }
                else if(str.equals("DOB:"))
                {
                    dob = scan.next();
                    setDOB(dob);
                }
                else if(str.equals("Address:"))
                {
                    addr = scan.next();
                    address = addr;
                }
                else if(str.equals("Phone:"))
                {
                    phone = scan.next();
                    long myPhone = Long.parseLong(phone);
                    setPhone(myPhone);
                }
                else if(str.equals("Email:"))
                {
                    email = scan.next();
                    setEmail(email);
                }
                else if(str.equals("Payment_Preference:"))
                {
                    paymentpreference = scan.next();
                    paymentPreference = paymentpreference;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
    }

}

final class Admin extends Person implements objFileHandler
{
    public Admin(String accessLvl)
    {
        this.accessLevel = accessLvl;
    }

    public Admin()
    {
        System.out.println("Constructing Admin Object");
    }

    private float salary;

    public void setSalary(float s)
    {
        salary = s;
    }
    public float getSalary()
    {
        return salary;
    }

   
    public static int changePassword(String user, String oldPass, String newPass)
    {
        try
        {
            File myFile = new File("E:\\ShopOnlineFiles\\Person\\Admin\\"+user+".txt");
            Scanner scan = new Scanner(myFile);
            String username="", password="", fullname="", accesslevel="", dob="", phone="", email="", salary="";
            String str="";
            while(scan.hasNext())
            {
                str = scan.next();
                if(str.equals("Username:"))
                {
                    username = scan.next();
                }
                else if(str.equals("Password:"))
                {
                    password = scan.next();
                }
                else if(str.equals("Full_Name:"))
                {
                    fullname = scan.next();
                }
                else if(str.equals("Access_Level:"))
                {
                    accesslevel = scan.next();
                }
                else if(str.equals("DOB:"))
                {
                    dob = scan.next();
                }
                else if(str.equals("Phone:"))
                {
                    phone = scan.next();
                }
                else if(str.equals("Email:"))
                {
                    email = scan.next();
                }
                else if(str.equals("Salary:"))
                {
                    salary = scan.next();
                }
            }

            if(password.equals(oldPass))
                {
                    password = newPass;

                    try
                    {
                        FileWriter fileWrite = new FileWriter("E:\\ShopOnlineFiles\\Person\\Admin\\"+username+".txt");
                        fileWrite.write("Username: "+username);
                        fileWrite.write("\nPassword: "+password);
                        fileWrite.write("\nFull_Name: "+fullname);
                        fileWrite.write("\nAccess_Level: "+accesslevel);
                        fileWrite.write("\nDOB: "+dob);
                        fileWrite.write("\nPhone: "+phone);
                        fileWrite.write("\nEmail: "+email);
                        fileWrite.write("\nSalary: "+salary);
                        System.out.println("Admin Password Changed Successfully...");
                        fileWrite.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println("Error writing to file.");
                        e.printStackTrace();
                        return 2;
                    }
                }
                else
                {
                    System.out.println("Old Password Incorrect !!");
                    return 1;
                }
            
            

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading from file.");
            e.printStackTrace();
            return 2;
        }
        return 0;
    }

    public static int checkUsername(String user)
    {
        String checkFileName = "E:\\ShopOnlineFiles\\Person\\Admin\\"+user+".txt";
        File myFile = new File(checkFileName);
        if(myFile.exists())
        {
            return 1;
        }
        else{
            return 0;
        }
    }

    public void writeToFile()
    {
        try
        {
            FileWriter fileWrite = new FileWriter("E:\\ShopOnlineFiles\\Person\\Admin\\"+getUsername()+".txt");
            fileWrite.write("Username: "+getUsername());
            fileWrite.write("\nPassword: "+password);
            fileWrite.write("\nFull_Name: "+getFullname());
            fileWrite.write("\nAccess_Level: "+accessLevel);
            fileWrite.write("\nDOB: "+getDOB());
            fileWrite.write("\nPhone: "+getPhone());
            fileWrite.write("\nEmail: "+getEmail());
            fileWrite.write("\nSalary: "+salary);
            fileWrite.close();
            System.out.println("Admin details written to file "+getUsername()+".txt successfully.");
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }

    }

    public void readFromFile(String user)
    {
        try
        {
            File myFile = new File("E:\\ShopOnlineFiles\\Person\\Admin\\"+user+".txt");
            Scanner scan = new Scanner(myFile);
            String username="", pwd="", fullname="", accesslevel="", dob="", phone="", email="", sal="";
            String str="";
            while(scan.hasNext())
            {
                str = scan.next();
                if(str.equals("Username:"))
                {
                    username = scan.next();
                    setUsername(username);
                }
                else if(str.equals("Password:"))
                {
                    pwd = scan.next();
                    password = pwd;
                }
                else if(str.equals("Full_Name:"))
                {
                    fullname = scan.next();
                    setFullname(fullname);
                }
                else if(str.equals("Access_Level:"))
                {
                    accesslevel = scan.next();
                }
                else if(str.equals("DOB:"))
                {
                    dob = scan.next();
                    setDOB(dob);
                }
                else if(str.equals("Phone:"))
                {
                    phone = scan.next();
                    long myPhone = Long.parseLong(phone);
                    setPhone(myPhone);
                }
                else if(str.equals("Email:"))
                {
                    email = scan.next();
                    setEmail(email);
                }
                else if(str.equals("Salary:"))
                {
                    sal = scan.next();
                    float mySal = Float.parseFloat(sal);
                    salary = mySal;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
    }
}

