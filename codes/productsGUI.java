import javax.swing.*;
import javax.swing.table.*;

import java.util.*;
 import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class productsGUI implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton button;
	JLabel headingLabel;
	JTable jt = new JTable();
		JTableHeader tableHeader = jt.getTableHeader();


	  


	JLabel productIDLabel;
	JTextField productIDText;
	
	JLabel productNameLabel;
	JTextField productNameText;

	JLabel productPriceLabel;
	JTextField productPriceText;
	

	JLabel stockLabel;
	JTextField stockText;



	JLabel productDescriptionLabel;
	JTextArea productDescriptionText;

	    DefaultTableModel model = (DefaultTableModel) jt.getModel();
   



    JScrollPane jsp= new JScrollPane(jt);
    JButton btn;



   static  int exist=0;



	//Jlabel registrationStatus;

	int i=0;
	public String data[][]=new String[100][5];

	public  void getFromFile(){
		//  File directoryPath = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo");
		 File directoryPath = new File("E:\\ShopOnlineFiles\\productInfo\\");
      //List of all files and directories
      String contents[] = directoryPath.list();
      for(int i=0; i<contents.length; i++) {
        
        String currentFile=contents[i];
        System.out.println(currentFile);

        try{
        // File myObj = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+currentFile);
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

	public productsGUI() {
	
	frame = new JFrame("shopOnline - ADMIN");
	frame.setSize(800,600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);

	panel = new JPanel();

	frame.add(panel);

	panel.setLayout(null);

	headingLabel= new JLabel("Inventory management");
	headingLabel.setBounds(340,5,180,50);
	panel.add(headingLabel);


	productIDLabel = new JLabel("Product ID : ");
	productIDLabel.setBounds(40,45,80,25);
	panel.add(productIDLabel);

	productIDText = new JTextField(20);
	productIDText.setBounds(150, 45, 160 , 25);
	panel.add(productIDText);



	productNameLabel = new JLabel("Product name : ");
	productNameLabel.setBounds(40,75,100,25);
	panel.add(productNameLabel);

	productNameText = new JTextField(20);
	productNameText.setBounds(150, 75, 160 , 25);
	panel.add(productNameText);


	productPriceLabel = new JLabel("Price : ");
	productPriceLabel.setBounds(40,105,80,25);
	panel.add(productPriceLabel);

	productPriceText = new JTextField(20);
	productPriceText.setBounds(150, 105, 160 , 25);
	panel.add(productPriceText);

	stockLabel = new JLabel("Stock : ");
	stockLabel.setBounds(40,135,80,25);
	panel.add(stockLabel);

	stockText = new JTextField(20);
	stockText.setBounds(150, 135, 160 , 25);
	panel.add(stockText);

	productDescriptionLabel = new JLabel("Description : ");
	productDescriptionLabel.setBounds(40, 165, 100 , 25);
	panel.add(productDescriptionLabel);

	productDescriptionText = new JTextArea();
	productDescriptionText.setBounds(150, 165, 160 , 25);
	panel.add(productDescriptionText);




	

	button= new JButton("Add to Inventory");
	button.setBounds(130,205,160,25);
	button.addActionListener(this);
	panel.add(button);


	
	


	}

	public void productTable(){
		 tableHeader.setBackground(Color.decode("#ADD8E6"));
    tableHeader.setForeground(Color.black);


		 jt.setBounds(0,40,650,300);

 model.addColumn("Product ID");
        model.addColumn("Product Name");
            model.addColumn("Product Price");
    model.addColumn("Stock");
    model.addColumn("Product Description");


    

jsp.setBounds(40,340,650,300);
	panel.add(jsp);

	getFromFile();

		




	}



public static void createFile(String productID, String productName, String productPrice, String stock, String productDescription){

		 try {
    //   File checkFile = new File("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
      File checkFile = new File("E:\\ShopOnlineFiles\\productInfo\\"+productID+".txt");

      if(checkFile.exists()){
      	exist=1;

      }
      else{
      	    //   FileWriter myWriter = new FileWriter("C:\\Users\\USER\\Desktop\\java\\oop sem peoject\\gui\\productInfo\\"+productID+".txt");
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
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }



	}



	public static void main(String args[]){
	productsGUI obj=new productsGUI();  
	obj.productTable();
	


	}
	@Override
	public void actionPerformed(ActionEvent e){
		/*++i;
		data[i][0]=productIDText.getText();
		data[i][1]=productNameText.getText();
		data[i][2]=productPriceText.getText();
		data[i][3]=stockText.getText();
		data[i][4]=productDescriptionText.getText();
		productTable();*/


	String productID=productIDText.getText();
	String productName=productNameText.getText();
		String productPrice=productPriceText.getText();
		String stock=stockText.getText();
		String productDescription=productDescriptionText.getText();

		if(productID.trim().length()==0 || productName.trim().length()==0 || productPrice.trim().length()==0 || stock.trim().length()==0 ||productDescription.trim().length()==0 ) 
		{
			JOptionPane.showMessageDialog(frame, "Fill all fields",
               "Warning", JOptionPane.WARNING_MESSAGE);

			


		}
		else{
					createFile(productID, productName, productPrice, stock, productDescription);

		




		

if (exist==0 && productID.trim().length()!=0) {
	model.insertRow(model.getRowCount(), new Object[] { productID, productName, productPrice, stock, productDescription });

	
}
else{
	exist=0;

	 JOptionPane.showMessageDialog(frame, "Product already exists!",
               "Warning", JOptionPane.WARNING_MESSAGE);

}


    // clear the entries.
}

}
}










