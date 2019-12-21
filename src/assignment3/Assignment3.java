/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import com.device.gui.Devices;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;



/**
 *
 * @author farhi
 */
public class Assignment3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {       
        
        BorderPane root = new BorderPane();       
        
        root.setCenter(new Devices());
        
//        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth() - 100,
				Screen.getPrimary().getBounds().getHeight() - 100);
        
        primaryStage.setTitle("Electronic Devices");
        primaryStage.setFullScreen(false);
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
