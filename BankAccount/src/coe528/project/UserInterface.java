
package coe528.project;
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.text.*; 
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
/**
 *
 * @author shaan
 */
public class UserInterface extends Application {
    private Customer ctemp;
    private FileWriter fw;
    private Alert a = new Alert(AlertType.NONE);
    private String stemp; 
    private Manager m; 
    public void colour(Label x)
    {
        if (x.getText().equals("Silver"))
        {
            x.setTextFill(Color.web("#C0C0C0"));
        }
         if (x.getText().equals("Gold"))
        {
            x.setTextFill(Color.web("#FFD700"));
        }
          if (x.getText().equals("Platinum"))
        {
            x.setTextFill(Color.web("#6B8E23"));
        }
        
    }
    public void accountNotification(Customer c, String temp)
    {    if (c.getLevelString().equals(temp) )
    {
        return; 
    }
    else if (c.getLevelString().equals("Silver"))
    {
           a.setAlertType(Alert.AlertType.INFORMATION); 
           a.setContentText("Hello " + c.getUserName() + ", your account \nhas been changed to a Silver Account. This means\n"
                   + "that for every online transaction, you will be charged\nan additional $20 for your purchase.");
           a.show();
    }
    else if (c.getLevelString().equals("Gold"))
    {
           a.setAlertType(Alert.AlertType.INFORMATION); 
           a.setContentText("Hello " + c.getUserName() + ", your account \nhas been changed to a Gold Account. This means\n"
                   + "that for every online transaction, you will be charged\nan additional $10 for your purchase."); 
           a.show();
    }
    else if (c.getLevelString().equals("Platinum"))
    {
             a.setAlertType(Alert.AlertType.INFORMATION); 
             a.setContentText("Hello " + c.getUserName() + ", your account \nhas been changed to a Platinum Account. This means\n"
                   + "that for every online transaction, you will not have\nto pay any additional fee.");  
             a.show();
    }
    
    }
    @Override
    public void start(Stage primaryStage) {
        m = new Manager(); 
        File f = new File("ManagerFiles\\"); 
        Button btn = new Button();
        Button exit = new Button();
        Label title = new Label("Bank Account Application\n");
        Label user =  new Label("Username:");
        Label pass =  new Label("Password:");
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1000, 500);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        TextField username = new TextField();
        TextField password = new PasswordField();
        btn.setPrefSize(100,20);
        exit.setPrefSize(100,20);
        exit.setText("Exit"); 
        btn.setText("Login");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
            }
        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 
                 
                if ((username.getText() !=null && password.getText() != null) && m.login(username.getText(),password.getText()) == true)
                {   ManagerStage(primaryStage,m);
                    return; 
                    
                }
                for (File temp:f.listFiles())
                {    
                    ctemp = m.addCustomerFile(temp); 
                    if (ctemp.getUserName().equals(username.getText()) && ctemp.getPass().equals(password.getText()))
                    {   
                        CustomerStage(primaryStage,m,ctemp,temp);
                        return; 
                    }
                }
                    a.setAlertType(AlertType.ERROR); 
                    a.setContentText("Invalid Login Parameters!\nPlease try Again!"); 
                    a.show();
               
                
            }
        });
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        GridPane.setHalignment(title, HPos.CENTER);
        title.setFont(new Font("Times New Roman", 48));
        user.setFont(new Font("Times New Roman", 24));
        pass.setFont(new Font("Times New Roman", 24));
        gridpane.add(title,15 ,5);
        gridpane.add(user,10 ,10); 
        gridpane.add(username,15 ,10); 
        gridpane.add(pass,10 ,20); 
        gridpane.add(password,15 ,20); 
        gridpane.add(btn,20,30);
        gridpane.add(exit,10,30);
        root.getChildren().add(gridpane);
        primaryStage.setTitle("Banking Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public void  ManagerStage (Stage primaryStage,Manager m)
 {   
     StackPane root = new StackPane();
     Label user =  new Label("Username:");
     Label user2 =  new Label("Username:");
     Label pass =  new Label("Password:");
     Label userList =  new Label("Customer List:");
     Button logOut = new Button();
     Button adder = new Button();
     Button deleter = new Button();
     Scene scene = new Scene(root, 1000, 500);
     GridPane gridpane = new GridPane();
     gridpane.setPadding(new Insets(5));
     Label title = new Label("Manager");
     Label addCustomer = new Label("Add Customer:");
     Label deleteCustomer = new Label("Delete Customer:");
     TextField createUser = new TextField();
     TextField createUserPass = new TextField();
     TextField delete = new TextField();
     TextArea createList = new TextArea();
     gridpane.setHgap(10);
     gridpane.setVgap(10);
     gridpane.getColumnConstraints().add(new ColumnConstraints(155));
     gridpane.getRowConstraints().add(new RowConstraints(35));
     //GridPane.setHalignment(userList , HPos.CENTER);
     title.setFont(new Font("Times New Roman", 38));
     addCustomer.setFont(new Font("Times New Roman", 22));
     deleteCustomer.setFont(new Font("Times New Roman", 22));
     userList.setFont(new Font("Times New Roman", 22));
     user.setFont(new Font("Times New Roman", 18));
     user2.setFont(new Font("Times New Roman", 18));
     pass.setFont(new Font("Times New Roman", 18));
     gridpane.add(title,0,0);
     createUser.setPrefWidth(200);
     createUserPass.setPrefWidth(200);
     createList.setPrefWidth(200);
     createList.setPrefHeight(500);
     delete.setPrefWidth(200);
     logOut.setPrefSize(100,20);
     adder.setPrefSize(100,20);
     deleter.setPrefSize(100,20);
     logOut.setText("Log Out"); 
     adder.setText("Add"); 
     deleter.setText("Delete"); 
     createList.setText(m.printList());
     logOut.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage); 
            }
        });
      adder.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                m.addCustomer(createUser.getText(),createUserPass.getText()); 
                createList.setText(m.printList());
            }
        });
       deleter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                m.deleteCustomer(delete.getText());
                
                createList.setText(m.printList());
            }
        });
     gridpane.add(createList,19,5);
     gridpane.add(deleteCustomer,0,10);
     gridpane.add(addCustomer,0,2);
     gridpane.add(createUser,1,4);
     gridpane.add(createUserPass,1,5);
     gridpane.add(delete,1,12,1,1);
     gridpane.add(logOut,1,18);
     gridpane.add(adder,0,6);
     gridpane.add(deleter,0,14);
     gridpane.add(userList,19,2);
     gridpane.add(user,0,4);
     gridpane.add(pass,0,5);
     gridpane.add(user2,0,12);
     root.getChildren().add(gridpane);
     primaryStage.setTitle("Banking Interface");
     primaryStage.setScene(scene);
     primaryStage.show();
 }
 
 public void  CustomerStage (Stage primaryStage,Manager m,Customer c,File temp)
 {   
     StackPane root = new StackPane();
     Button logOut = new Button();
     Button depositor = new Button();
     Button withdrawer = new Button();
     Button balancer = new Button();
     Button purchaser = new Button();
     Scene scene = new Scene(root, 1000, 500);
     GridPane gridpane = new GridPane();
     gridpane.setPadding(new Insets(5));
     Label title = new Label("Customer");
     Label deposit = new Label("Deposit ($):");
     Label withdraw = new Label("Withdraw ($):");
     Label balance = new Label("Balance($):");
     Label purchase = new Label("e-Purchase($):");
     Label accountType = new Label("Account Type: ");
     Label accountOwner = new Label("Account Owner: ");
     Label accountOwnerName = new Label(c.getUserName());
     Label type = new Label(c.getLevelString());
     TextField depositAmount = new TextField();
     TextField purchaseAmount = new TextField();
     TextField balanceAmount = new TextField();
     TextField withdrawAmount = new TextField();
     gridpane.setHgap(10);
     gridpane.setVgap(10);
     gridpane.getColumnConstraints().add(new ColumnConstraints(155));
     //GridPane.setHalignment(userList , HPos.CENTER);
     title.setFont(new Font("Times New Roman", 38));
     deposit.setFont(new Font("Times New Roman", 22));
     withdraw.setFont(new Font("Times New Roman", 22));
     balance.setFont(new Font("Times New Roman", 22));
     purchase.setFont(new Font("Times New Roman", 22));
     accountType.setFont(new Font("Times New Roman", 22));
     accountOwner.setFont(new Font("Times New Roman", 22));
     accountOwnerName.setFont(new Font("Times New Roman", 22));
     type.setFont(new Font("Gothic", 22));
     colour(type);
     gridpane.add(title,0,0);
     depositAmount.setPrefWidth(200);
     purchaseAmount.setPrefWidth(200);
     balanceAmount.setPrefWidth(200);
     withdrawAmount.setPrefWidth(200);
     logOut.setPrefSize(100,20);
     depositor.setPrefSize(100,20);
     withdrawer.setPrefSize(100,20);
     balancer.setPrefSize(100,20);
     purchaser.setPrefSize(100,20);
     logOut.setText("Log Out"); 
     depositor.setText("Deposit"); 
     withdrawer.setText("Withdraw");
     balancer.setText("Get Balance"); 
     purchaser.setText("Purchase"); 
     
     logOut.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage); 
            }
        });
      depositor.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  stemp = c.getLevelString();
                  try
                  {
                  c.getAccount().deposit(c,(double) Double.parseDouble(depositAmount.getText()));
                  }
                  catch(Exception e)
                          {
                               a.setAlertType(Alert.AlertType.ERROR); 
                               a.setContentText("Please deposit a vaild amount!"); 
                               a.show();
                          }
                  try
                  {
                  fw = new FileWriter(temp,false);
                  fw.write(Double.toString(c.getAccount().getBalance())+"\n");
                  fw.write(c.getUserName()+"\n");
                  fw.write(c.getPass()+"\n");
                  fw.close();
                  }
                  catch(Exception e)
                          {
                             System.out.println("File Error"); 
                          }
         type.setText(c.getLevelString());
         colour(type);
         accountNotification(c,stemp);
            }
        });
       withdrawer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  stemp = c.getLevelString(); 
                  try
                  {
                  c.getAccount().withdraw(c,(double) Double.parseDouble(withdrawAmount.getText()));
                  }
                  catch(Exception e)
                          {
                               a.setAlertType(Alert.AlertType.ERROR); 
                               a.setContentText("Please withdraw a vaild amount!"); 
                               a.show();
                          }
                  try
                  {
                  fw = new FileWriter(temp,false);
                  fw.write(Double.toString(c.getAccount().getBalance())+"\n");
                  fw.write(c.getUserName()+"\n");
                  fw.write(c.getPass()+"\n");
                  fw.close();
                  }
                  catch(Exception e)
                          {
                               System.out.println("File Error"); 
                          }
               
             type.setText(c.getLevelString());
             colour(type);
             accountNotification(c,stemp);
            }
        });
        balancer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               balanceAmount.setText(Double.toString(c.getAccount().getBalance()));
            }
        });
        purchaser.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                  stemp = c.getLevelString();
                  try
                  {
                  c.getLevel().onlinePurchase(c,(double) Double.parseDouble(purchaseAmount.getText()));
                  }
                  catch (Exception e)
                  {
                       a.setAlertType(Alert.AlertType.ERROR); 
                       a.setContentText("Please purchase with a vaild amount!"); 
                       a.show();
                  }
                  try
                  {
                  fw = new FileWriter(temp,false);
                  fw.write(Double.toString(c.getAccount().getBalance())+"\n");
                  fw.write(c.getUserName()+"\n");
                  fw.write(c.getPass()+"\n");
                  fw.close();
                  }
                  catch(Exception e)
                          {
                               System.out.println("File Error"); 
                          }
              
              type.setText(c.getLevelString());
              colour(type);
              accountNotification(c,stemp);
            }
        });
        
     gridpane.add(withdraw,0,8);
     gridpane.add(deposit,0,2);
     gridpane.add(depositAmount,1,2);
     gridpane.add(balance,0,14);
     gridpane.add(balanceAmount,1,14);
     gridpane.add(withdrawAmount,1,8,1,1);
     gridpane.add(logOut,1,22);
     gridpane.add(depositor,0,4);
     gridpane.add(withdrawer,0,10);
     gridpane.add(balancer,0,16);
     gridpane.add(purchase,10,2);
     gridpane.add(purchaseAmount,12,2);
     gridpane.add(accountType,10,8);
     gridpane.add(type,10,10);
     gridpane.add(accountOwner,10,13);
     gridpane.add(accountOwnerName,10,14);
     gridpane.add(purchaser,10,4);
     root.getChildren().add(gridpane);
     primaryStage.setTitle("Banking Interface");
     primaryStage.setScene(scene);
     primaryStage.show();
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
