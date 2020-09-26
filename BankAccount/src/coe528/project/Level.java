package coe528.project;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Level {
   protected Alert a = new Alert(AlertType.NONE);
   protected String levelName;
   public abstract void onlinePurchase(Customer c, double amount); 
   public void updateLevel(Customer c)
    {
        if (c.getAccount().getBalance() < 10000)
       {
           c.setLevel(new Silver());
           
       } 
        if (c.getAccount().getBalance() >= 10000  && c.getAccount().getBalance() <20000)
       {
           c.setLevel(new Gold());
           
       }
        if (c.getAccount().getBalance() >= 20000)
        {
             c.setLevel(new Platinum());
             
        }
    }
   @Override
    public String toString()
    {
        return this.levelName; 
    }
}
