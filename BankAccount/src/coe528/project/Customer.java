package coe528.project;
 /**
 * Overview: The Customer class is a mutable class that is emulating 
 * the behavior of a Bank Customer. This class is used to show  
 * unique characteristics of an object of type Customer such as Level(State Design)
 * and Account. 
 *
 *
 * The abstraction function is: 
 * AF(c) =  a Customer  p, containing objects of type Level and Account, such that
 * p.username = "x";
 * p.password = "y";
 * where "x" and "y" are Arbitrary Strings
 * p.role = "Customer";
 * p.a.getBalance() = An arbitrary double value that is greater or equal to zero. 
 * p.a.toString() = "Account Balance: " + p.a.getBalance()  
 * p.type.toString() = "Silver" or "Gold" or "Platinum"
 * 
 * The rep invariant is: 
 * RI(c) = true if c.a.getBalance() Greater than or equal to 0 and c.username NOT= null AND c.password NOT=null AND c.role.equals("Customer") AND
 * c.a.toString().equals("Account Balance: " + c.a.getBalance())AND(c.type.toString().equals("Silver") OR c.type.toString().equals("Gold")OR c.type.toString().equals("Platinum"))
 *  Otherwise, RI(c) = false.  
 */
public class Customer {
   
   private Level type; 
   private String username;
   private String password; 
   private String role;
   private Account a;
   /**
   *Requires:None.
   *MODIFIES: The balance of object of type Account.        
   *EFFECTS:Instantiates this to be be an object of type Customer
   */
   public Customer(double balance,String username,String password, Account a)
   {   this.a = a; 
       this.role= "Customer";
       this.username= username; 
       this.password = password;
       if (balance < 10000)
       {
       this.type = new Silver(); 
       }
       if (balance>= 10000 && balance < 20000 )
       {
           this.type = new Gold(); 
       }
       if (balance >= 20000)
       {
           this.type = new Platinum(); 
       }
       a.setBalance(this,balance); 
       
   }
   /**
   *Requires:None.
   *MODIFIES:None.        
   *EFFECTS:Returns the password of the customer.
   */
   public String getPass()
   {
       return this.password; 
   }
   /**
   *Requires:None.
   *MODIFIES:None.        
   *EFFECTS:Returns the username of the customer
   */
   public String getUserName()
   {
       return this.username; 
   }
   /**
   *Requires:An object of type Silver,Gold,or Platinum 
   *MODIFIES:this        
   *EFFECTS:Changes the Level of the Customer
   */
   public void setLevel(Level type)
   {
       this.type = type;  
   } 
   /**
   *Requires:None.
   *MODIFIES:None.        
   *EFFECTS:Returns the Level object of the Customer
   */
   public Level getLevel()
   {
       return this.type; 
   } 
   /**
   *Requires:None.
   *MODIFIES:None.        
   *EFFECTS:Returns the String representation of the Level Object of the Customer
   */
   public String getLevelString()
   {
      return this.type.toString(); 
   }
   /**
   *Requires:None.
   *MODIFIES:None.        
   *EFFECTS:Returns the Account Object of the Customer
   */ 
  public Account getAccount()
  {
      return this.a;
  }
  /**
  *EFFECTS: Returns a string that contains a description of
  *a Customer. Implements the abstraction function.
  */    
 public String toString()
 {
     return  "Role: " + this.role + ", Customer's Username: " + this.username + ", Customer's Password: " + this.password + ", Customer Level: " + this.type.toString() + ", " + this.a.toString();
 }
 /**
 * EFFECTS: Returns true if the rep invariant holds for this
 * object of type Customer; otherwise returns false
 */ 
 public boolean repOK()
 {  
     if(this.a.getBalance() >= 0 && this.username != null && this.password !=null && this.role.equals("Customer") && 
        this.a.toString().equals("Account Balance: " + this.a.getBalance())&&(this.type.toString().equals("Silver") ||this.type.toString().equals("Gold")||this.type.toString().equals("Platinum")) )
     {
         return true;
     }
     return false; 
 }
}
