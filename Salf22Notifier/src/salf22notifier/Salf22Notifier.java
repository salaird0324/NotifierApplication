/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salf22notifier;

import static java.lang.Double.MAX_VALUE;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Spencer Laird
 */
public class Salf22Notifier extends Application {
    
     public String title = "Document Editor";
    public int width = 420; 
    public int height = 250; 
    
    
    @Override
    public void start(Stage primaryStage) {
               VBox root = new VBox(20); 
               root.setPadding(new Insets(0, 0, 10, 0));
               root.setSpacing(10);
        
               GridPane grid = new GridPane();
               grid.setAlignment(Pos.CENTER);
               grid.setVgap(10);
               grid.setHgap(10);
               grid.setPrefWidth(350);
               
               
               TextField textField = new TextField();
               VBox textBox = new VBox(20);
               textField.setAlignment(Pos.CENTER_LEFT);
               textBox.getChildren().add(textField);
               root.getChildren().add(textBox);
             
               
               Button notify = new Button("Notify");
               VBox notifyBox = new VBox(20);
               notify.setAlignment(Pos.CENTER);
               notifyBox.getChildren().add(notify);
               root.getChildren().add(notifyBox);
               
               Button clear = new Button("Clear");
               VBox clearBox = new VBox(20);
               clear.setAlignment(Pos.CENTER);
               clearBox.getChildren().add(clear);
               root.getChildren().add(clearBox);
               
               Button print = new Button("Print");
               VBox printBox = new VBox(20);
               clear.setAlignment(Pos.CENTER);
               printBox.getChildren().add(print);
               root.getChildren().add(printBox);
               
               Button alert = new Button("Alert");
               VBox alertBox = new VBox(20);
               clear.setAlignment(Pos.CENTER);
               alertBox.getChildren().add(alert);
               root.getChildren().add(alertBox);
               
             notify.setMaxWidth(MAX_VALUE);
             clear.setMaxWidth(MAX_VALUE);
             print.setMaxWidth(MAX_VALUE);
             alert.setMaxWidth(MAX_VALUE);
             
              notify.setOnAction((ActionEvent) -> {
                invokeMe(textField);
              });
              
              clear.setOnAction((ActionEvent)-> {
                  textField.setText(" ");
              });
              
              print.setOnAction((ActionEvent)->{
                  String text = textField.getText();
                  
                  System.out.println(text);
              });
              
              alert.setOnAction((ActionEvent)-> {
                Date date2 = new Date();
                Alert hey = new Alert(AlertType.ERROR);
                hey.setTitle("Error");
                hey.setContentText("You have been notified by salf22 on  "+ date2);
                hey.showAndWait();
              });
               
             
               
               
               
            
             Scene scene = new Scene(root, width, height);
             primaryStage.setScene(scene);
        
            primaryStage.show();
       
        
       
    }
    
   public void invokeMe(TextField textField){
       Date date = new Date();
       textField.setText("You have been notified by salf22 on " + date);
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
