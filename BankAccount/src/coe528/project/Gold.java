/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.scene.control.Alert;

/**
 *
 * @author shaan
 */
public class Gold extends Level {
    public Gold()
    {
        this.levelName = "Gold"; 
    }
    public void onlinePurchase(Customer c,double amount)
   {   if (amount < 50)
   {
       a.setAlertType(Alert.AlertType.ERROR); 
       a.setContentText("Declined! Your online purchase must be atleast 50 dollars!"); 
       a.show();
       return; 
   }
       if(c.getAccount().getBalance()-(amount+10) >= 0 && amount >=0)
   {
       c.getAccount().withdraw(c,amount+10);
   }
   else if(amount<0)
   {
       a.setAlertType(Alert.AlertType.ERROR); 
       a.setContentText("Declined! Please enter a valid purchase amount!"); 
       a.show();
   }
   else
   {
       a.setAlertType(Alert.AlertType.ERROR); 
       a.setContentText("Declined! Purchase exceeds balance amount!"); 
       a.show();
   }
   }
}
