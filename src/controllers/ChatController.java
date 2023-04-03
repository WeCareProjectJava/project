/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import modules.*;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author eya_o
 */
public class ChatController {

    
     @FXML
    private ImageView Exit;
  
 
    @FXML
    void Exit(MouseEvent event) {
         try {
                        Exit.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("/Views/sign-in interface.fxml"));

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();

                        stage.setScene(scene);

                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

    }
    
}
    
