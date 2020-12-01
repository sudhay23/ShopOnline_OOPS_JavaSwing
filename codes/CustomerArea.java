import javax.swing.*;
import javax.swing.table.*;

import java.util.*;
 import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class CustomerArea implements ActionListener {  
JFrame f;  
JTable jt = new JTable();
DefaultTableModel model = (DefaultTableModel) jt.getModel();
JScrollPane jsp= new JScrollPane(jt);
JTableHeader tableHeader = jt.getTableHeader();



JTabbedPane tp=new JTabbedPane();


JLabel productIDCustomerLabel;
JTextField productIDCustomerText;
  
JLabel productQuantityCustomerLabel;
JTextField productQuantityCustomerText;

JLabel heading,usernameLabel,fullnameLabel,accesslevelLabel,dobLabel,addressLabel,phoneLabel,emailLabel,paymentPrefLabel;

JButton addToCartBtn;

JLabel totalCostLabel;



JTable jt1 = new JTable();
DefaultTableModel model1 = (DefaultTableModel) jt1.getModel();
JScrollPane jsp1= new JScrollPane(jt1);
JTableHeader tableHeader1 = jt1.getTableHeader();





JPanel p1;
JPanel  p2;
JPanel p3;


int totalCost=0;

JButton clearCartBtn;
JButton placeOrderBtn;

public void productTable(){
    tableHeader.setBackground(Color.decode("#ADD8E6"));
    tableHeader.setForeground(Color.black);



  jsp.setBounds(30,50,700,400);

jt.setBounds(30,50,700,400);



 model.addColumn("Product ID");
        model.addColumn("Product Name");
            model.addColumn("Product Price");
    model.addColumn("Stock");
    model.addColumn("Product Description");


    


  p1.add(jsp);

  getFromFile();



    




  }

public  void getFromFile(){
//  File directoryPath = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo");
     File directoryPath = new File("E:\\ShopOnlineFiles\\productInfo");      //List of all files and directories
      String contents[] = directoryPath.list();
      for(int i=0; i<contents.length; i++) {
        
        String currentFile=contents[i];
        System.out.println(currentFile);

        try{
  //  File myObj = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+currentFile);
       File myObj = new File("E:\\ShopOnlineFiles\\productInfo\\"+currentFile);
        Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
        String productIDdata = myReader.nextLine().split(":")[1];
        String productNameData =myReader.nextLine().split(":")[1];
        String productPriceData =myReader.nextLine().split(":")[1]; 
        String productStockData =myReader.nextLine().split(":")[1]; 
        String productDescriptionData =myReader.nextLine().split(":")[1]; 

        System.out.println(productIDdata+" "+productNameData+" "+ productPriceData+" "+ productStockData+" "+ productDescriptionData); 
        //System.out.println(data);

        model.insertRow(model.getRowCount(), new Object[] { productIDdata, productNameData, productPriceData, productStockData, productDescriptionData });




      }



        myReader.close();
        }
         catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   }

  }

public CustomerArea(String custUsername) { 
    f=new JFrame("Welcome to shopOnline-Customer");  
    f.setSize(800,600);
    
     p1=new JPanel();  
      
     p2=new JPanel();  
     p3=new JPanel();  
       
    tp.setBounds(0,0,600,600);  

    tp.add("Browse Products",p1);  
    tp.add("Your Cart",p2);  
    tp.add("Your Profile",p3); 
    p1.setLayout(null); 
    p2.setLayout(null);
    p3.setLayout(null);











    f.add(tp);  
//    f.setLayout(null);  
    f.setVisible(true);  

    productIDCustomerLabel= new JLabel("Product ID : ");
  productIDCustomerLabel.setBounds(40,480,80,25);
  p1.add(productIDCustomerLabel);

  productIDCustomerText = new JTextField(20);
  productIDCustomerText.setBounds(120, 480, 160 , 25);
  p1.add(productIDCustomerText);

  productQuantityCustomerLabel= new JLabel("Quantity : ");
  productQuantityCustomerLabel.setBounds(300,480,80,25);
  p1.add(productQuantityCustomerLabel);

  productQuantityCustomerText = new JTextField(20);
  productQuantityCustomerText.setBounds(375, 480, 160 , 25);
  p1.add(productQuantityCustomerText);

  addToCartBtn= new JButton("Add to Cart");
  addToCartBtn.setBounds(565,480,160,25);
  addToCartBtn.addActionListener(this);
  p1.add(addToCartBtn);   

  totalCostLabel=new JLabel("");
  totalCostLabel.setBounds(630,480,160,25);
  p2.add(totalCostLabel); 


  clearCartBtn=new JButton("Clear Cart");
  clearCartBtn.setBounds(30,480,150,25);
  clearCartBtn.addActionListener(this);
  p2.add(clearCartBtn);

  placeOrderBtn=new JButton("Place Order");
  placeOrderBtn.setBounds(320,480,150,25);
  placeOrderBtn.addActionListener(this);
  p2.add(placeOrderBtn);

 // Your Profile
  Customer myCust = new Customer("customer");
  myCust.readFromFile(custUsername);

  heading = new JLabel("Customer Profile");
  heading.setBounds(200,20,180,25);
  p3.add(heading);

  usernameLabel = new JLabel("Username: "+myCust.getUsername());
  usernameLabel.setBounds(100,50,180,25);
  p3.add(usernameLabel);

  fullnameLabel = new JLabel("Full Name: "+myCust.getFullname());
  fullnameLabel.setBounds(100,90,180,25);
  p3.add(fullnameLabel);

  accesslevelLabel = new JLabel("Access Level: "+myCust.getAccessLevel());
  accesslevelLabel.setBounds(100,130,180,25);
  p3.add(accesslevelLabel);

  dobLabel = new JLabel("Date of Birth: "+myCust.getDOB());
  dobLabel.setBounds(100,170,180,25);
  p3.add(dobLabel);

  addressLabel = new JLabel("Address: "+myCust.getAddress());
  addressLabel.setBounds(100,210,180,25);
  p3.add(addressLabel);

  phoneLabel = new JLabel("Phone: "+myCust.getPhone());
  phoneLabel.setBounds(100,250,180,25);
  p3.add(phoneLabel);

  emailLabel = new JLabel("Email: "+myCust.getEmail());
  emailLabel.setBounds(100,290,180,25);
  p3.add(emailLabel);

  paymentPrefLabel = new JLabel("Payment Preference: "+myCust.getPaymentPreference());
  paymentPrefLabel.setBounds(100,330,180,25);
  p3.add(paymentPrefLabel);


    
}  

public void cartTabFileHandling(String productID , String productQuantity){

  try{
        // File myObj = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
               File myObj = new File("E:\\ShopOnlineFiles\\productInfo\\"+productID+".txt");


        Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
        String productIDdata = myReader.nextLine().split(":")[1];
        String productNameData =myReader.nextLine().split(":")[1];
        String productPriceData =myReader.nextLine().split(":")[1]; 

        String productStockData =myReader.nextLine().split(":")[1]; 
        String productDescriptionData =myReader.nextLine().split(":")[1]; 

             

        int cost=Integer.parseInt(productPriceData.trim())*Integer.parseInt(productQuantity.trim());
        totalCost+=cost;

        totalCostLabel.setText("Total Cost = "+totalCost);

        

       // System.out.println(cost);

        //System.out.println(productIDdata+" "+productNameData+" "+ productPriceData+" "+ productStockData+" "+ productDescriptionData); 
        //System.out.println(data);


        model1.insertRow(model1.getRowCount(), new Object[] { productIDdata, productNameData, productPriceData, productQuantity, Integer.toString(cost) });




      }



        myReader.close();
        }
         catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   }






public void createCartTable(){
  tableHeader1.setBackground(Color.decode("#ADD8E6"));
    tableHeader1.setForeground(Color.black);



    jsp1.setBounds(30,50,700,400);

jt1.setBounds(30,50,700,400);



 model1.addColumn("Product ID");
        model1.addColumn("Product Name");
            model1.addColumn("Product Price");
    model1.addColumn("Quantity");
    model1.addColumn("Cost");


    


  p2.add(jsp1);


}


public  void createFile(String productID, String productName, String productPrice, String stock, String productDescription){

     try {
      
      
              // FileWriter myWriter = new FileWriter("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
                  FileWriter myWriter = new FileWriter("E:\\ShopOnlineFiles\\productInfo\\"+productID+".txt");

              myWriter.write("ProductID:"+productID+"\n");
              
              myWriter.write("ProductName:"+productName+"\n");
              myWriter.write("productPrice:"+productPrice+"\n");

              myWriter.write("ProductStock:"+stock+"\n");
              myWriter.write("productDescription:"+productDescription+"\n");



            myWriter.close();

          

      }


   /*   if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }*/
     catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }



  }



public boolean refreshProductsTable(String productID,String quantity,boolean addBackToStock){
   String productIDdata;
   String productNameData;
   String productPriceData;
   String productStockData;
   String productDescriptionData;
   int updatedStock=0;

try{
  //  File checkFile = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
                    File checkFile = new File("E:\\ShopOnlineFiles\\productInfo\\"+productID+".txt");


      if(checkFile.exists()){

        
        

      
        // File myObj = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
        File myObj = new File("E:\\ShopOnlineFiles\\productInfo\\"+productID+".txt");

        Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
         productIDdata = myReader.nextLine().split(":")[1];
         productNameData =myReader.nextLine().split(":")[1];
         productPriceData =myReader.nextLine().split(":")[1]; 
         productStockData =myReader.nextLine().split(":")[1]; 
         productDescriptionData =myReader.nextLine().split(":")[1]; 



        //System.out.println(data);
         if(addBackToStock){
               updatedStock=Integer.parseInt(productStockData.trim())+Integer.parseInt(quantity.trim());

         }
         else{
               updatedStock=Integer.parseInt(productStockData.trim())-Integer.parseInt(quantity.trim());

         }

          if(updatedStock>=0){
          createFile(productIDdata,productNameData,productPriceData,Integer.toString(updatedStock),productDescriptionData);
         // myReader.close();
      }
      else{
                myReader.close();
                return false;


      }

    }



        myReader.close();




        


        

            return true;

        }
        else{
          return false;
        }
}
         catch (FileNotFoundException e) {
        
      System.out.println("An error occurred.");
      e.printStackTrace();
      return false;
    }
   




}






   










public static void main(String[] args) {  
  
CustomerArea tabObj =   new CustomerArea("Hello"); 
tabObj.productTable();
tabObj.createCartTable();


}

@Override
public void actionPerformed(ActionEvent e){

  if(e.getSource()==addToCartBtn){
    System.out.println(model.getRowCount());

  

  /*System.out.println(productIDCustomerText.getText());
  System.out.println(productQuantityCustomerText.getText());*/

String productIdCustomer=productIDCustomerText.getText();
String productQuantity=productQuantityCustomerText.getText();

System.out.println(productIdCustomer);
System.out.println(productQuantity);


if(productIdCustomer.trim().length()==0 || productQuantity.trim().length()==0){
JOptionPane.showMessageDialog(p1, "Fill all fields",
"Warning", JOptionPane.WARNING_MESSAGE);


}

else{



  boolean fileExistStatus= refreshProductsTable(productIdCustomer.trim(),productQuantity.trim(),false);

  if(fileExistStatus){

  model.setRowCount(0);//reseting the table
  getFromFile();//reading the refreshed file


  cartTabFileHandling(productIdCustomer.trim(),productQuantity.trim());
  }
  else{
    JOptionPane.showMessageDialog(p1, "Product is out of stock or does not exist",
"Warning", JOptionPane.WARNING_MESSAGE);

  }

  
  

}

 




}

else if(e.getSource()==clearCartBtn){

   int a=JOptionPane.showConfirmDialog(p2,"Are you sure?");  
if(a==JOptionPane.YES_OPTION){
for(int i=0;i<model1.getRowCount();++i){
Object productID = jt1.getModel().getValueAt(i, 0);
Object quantity = jt1.getModel().getValueAt(i, 3);

  boolean fileExistStatus= refreshProductsTable(String.valueOf(productID),String.valueOf(quantity),true);
  try{
  Thread.sleep(500);}
  catch(Exception abc){
    System.out.println("error from sleep");
  }
} 

  model.setRowCount(0);
  getFromFile();


    model1.setRowCount(0);
  totalCostLabel.setText(""); 
  totalCost=0; 

}  



  
}

else if(e.getSource()==placeOrderBtn){
  if(model1.getRowCount()==0){
    JOptionPane.showMessageDialog(p2, "Your cart is empty, add products to your cart",
"Warning", JOptionPane.WARNING_MESSAGE);

  }
  else{
    JOptionPane.showMessageDialog(p2, "Thank You, Order placed successfully",
"Warning", JOptionPane.WARNING_MESSAGE);
    model1.setRowCount(0);
    totalCostLabel.setText("");
    totalCost=0;

  }
}


}  }