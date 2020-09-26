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
public class Account {
    private double balance; 
    private Alert a = new Alert(Alert.AlertType.NONE);
    public void deposit (Customer c, double amount)
    {  if (amount >= 0)
    {
       c.getAccount().setBalance(c,getBalance()+amount); 
    }
    else
    {
       a.setAlertType(Alert.AlertType.ERROR); 
       a.setContentText("Please deposit a vaild amount!"); 
       a.show();
    }
       
    } 
   
    public void withdraw(Customer c, double amount)
    {  if (c.getAccount().getBalance() -amount >=0 && amount >= 0)
    {
       c.getAccount().setBalance(c,getBalance()-amount); 
    }
    else if(amount <0)
    {
       a.setAlertType(Alert.AlertType.ERROR); 
       a.setContentText("Please withdraw a vaild amount!"); 
       a.show();
    }
    else
    {
        a.setAlertType(Alert.AlertType.ERROR); 
        a.setContentText("Declined! Withdrawal exceeded current balance!"); 
        a.show();
    }
    }
    public void setBalance(Customer c,double balance)
    {
        this.balance = balance; 
        c.getLevel().updateLevel(c);
    } 
    public String toString()
    {
        return "Account Balance: " + this.balance; 
    }
     public double getBalance()
    {
        return this.balance;  
    }
}
