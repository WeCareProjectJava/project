/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */
import Client.Controller;
import static Client.Controller.username;
import Client.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DoctorController {
    
    @FXML
    private CheckBox checkBox;

    @FXML
    private ComboBox comb;

    @FXML
    private TextField description;

    @FXML
    private TextField experience;

    @FXML
    private TextField institution;

    @FXML
    private TextField languages;

    @FXML
    private TextField qualifications;
    @FXML
    private TextField adress;
    @FXML
    private Button save;

    @FXML
    private Button choose;
    
 
    
    
    
    @FXML

    Connection connect;
    PreparedStatement statement;
    ResultSet result;

    public Connection connectDb() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/wecare_db", "root", "27Dec02!*12!!");
            return connect;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    
    
       @FXML
    void checked(ActionEvent event) {
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                save.setDisable(false);
            } else {
                save.setDisable(true);
            }
        });
    }
 @FXML
    void save(ActionEvent event) {
        
     connect = connectDb();
       try {
            String selectValue=(String)comb.getSelectionModel().getSelectedItem();
            String sql = "INSERT INTO doctor(medical_field,institution,professional_qualifications,languages_spoken,experience,description,adress) VALUES(?,?,?,?,?,?,?)";
             statement= connect.prepareStatement(sql);
             statement.setString(1,selectValue);
             statement.setString(2,institution.getText());
             statement.setString(3,qualifications.getText());
              statement.setString(4,languages.getText());
               statement.setString(5,experience.getText());
               statement.setString(6,description.getText());
                statement.setString(7,adress.getText());
                int  result = statement.executeUpdate();
                 
            User x = new User(Controller.username,Controller.password);
            Controller.users.add(x);
                if(result>0){
                    System.out.println("okay");
                    try {
                    System.out.println("okay");
                    save.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/Views/Room.fxml"));
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle(Controller.username + "");


                    stage.setScene(scene);

                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                }
                else{
                    System.out.println("no");
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
    }
  
     @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("dermatho", "generaliste", "cardio");
        comb.setItems(list);
        save.setDisable(true);
        
    }

}

