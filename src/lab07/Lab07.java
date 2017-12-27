/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JT MENDOZA
 */
public class Lab07 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
        StackPane root = new StackPane();
        
        Button btn = new Button();
        btn.setText("Run");
        
        SortingPane s = new SortingPane();
        root.getChildren().add(s);
        
        
        btn.setOnAction((ActionEvent event) -> {            
            
            if(s.times == 0) {
                root.getChildren().remove(btn);
                root.getChildren().remove(s);
                s.run();
                root.getChildren().add(s);
                root.getChildren().add(btn);
            }
            else {
                root.getChildren().remove(btn);
                root.getChildren().remove(s);
                s.runAgain();
                root.getChildren().add(s);
                root.getChildren().add(btn);
            }
        });
        
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 700);
        
        primaryStage.setTitle("Hello World!");
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
