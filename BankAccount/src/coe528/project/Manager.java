
package coe528.project;
import java.util.*; 
import java.io.*; 
import javafx.scene.control.Alert;
public class Manager  {
   private String username;
   private String password; 
   private String role;
   private double customerBalance; 
   private String customerUsername; 
   private String customerPassword; 
   private Customer ctemp;
   private String temp; 
   private File f;
   private String directoryPath;
   Alert a = new Alert(Alert.AlertType.NONE);
   private boolean x; 
   private Scanner s; 
   private FileWriter fw;
   private ArrayList <Customer> clist; 
    
   public Manager()
   {   clist = new ArrayList<Customer>(); 
       directoryPath = "ManagerFiles\\";
       f = new File(directoryPath);
        if(!(f.isDirectory())){
            f.mkdir();
        }
        for(File temp: f.listFiles()){
        clist.add(addCustomerFile(temp));//adds Existing Customers when launching Application
       
        }
       this.username= "admin";
       this.password= "admin";
       this.role= "Manager";
   }
   public Customer addCustomerFile (File temp)
   {  
   try
   {
       s = new Scanner(temp);
   }
   catch(Exception e)
   {
        System.out.println("File Error"); 
   }
   customerBalance =(double) Double.parseDouble(s.nextLine()); 
   customerUsername = s.nextLine();
   customerPassword = s.nextLine();
   s.close();
   ctemp = new Customer (customerBalance,customerUsername,customerPassword,new Account()); 
   return ctemp;
   }
   public void addCustomer(String user,String userPassword)
   {   if(!user.equals("")||!userPassword.equals("") )
   {
       clist.add(new Customer(100,user,userPassword,new Account())); 
       f = new File("ManagerFiles\\" + user + ".txt");
       try {
       fw = new FileWriter(f,true);
       fw.write("100.00\n");
       fw.write(user +"\n");
       fw.write(userPassword +"\n");
       fw.close();
       a.setAlertType(Alert.AlertType.INFORMATION);
       a.setContentText( user + " has successfully been added to the Customer List");
       a.show();
       } 
       
       catch (IOException e) {
       System.out.println("An error occurred.");
       e.printStackTrace();
 }  
   }
   else
   {
        a.setAlertType(Alert.AlertType.ERROR);
        a.setContentText("Please enter a valid username and/or password");
        a.show();
   }
   }   
  public boolean login(String username, String password)
  {   x = false; 
      if (username.equals (this.username) && password.equals (this.password) )
      {
          x = true;  
            
      }
      return x; 
  }
  public String printList()
  {   temp ="";
      for (Customer element:clist)
      {   
          if(element.getUserName()!= null)
          {
          temp += element.getUserName()+ "\n";
          }
      }
      return temp; 
  }
  public void deleteCustomer(String user) 
  {   
     f = new File("ManagerFiles\\");
     for(File temp: f.listFiles()){
         if (temp.getName().equals(user+ ".txt"))
         {
        for(Customer c:this.clist)
        {
        if (c.getUserName().equals(user))
        {
        this.clist.remove(c);
        temp.delete();
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText(user + " has successfully been removed from the Customer List");
        a.show();
        return;
        }
        }
        
        }
         
     }
       
      a.setAlertType(Alert.AlertType.ERROR); 
      a.setContentText("Cannot delete! " + user + " is not in the Customer list!"); 
      a.show();
  }
   
}
