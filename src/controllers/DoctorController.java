/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */
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
                if(result>0){
                    System.out.println("okay");
                    try {
                    System.out.println("okay");
                    save.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/Views/chat_interface.fxml"));
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

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

/* @FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;

    private ChatClient chatClient;
    private String doctorEmail;

    public void initialize(String doctorEmail) {
        this.doctorEmail = doctorEmail;

        try {
            chatClient = new ChatClient("localhost", 3000, this);
            chatClient.connect(doctorEmail, UserType.DOCTOR);
        } catch (IOException e) {
            showErrorAlert("Connection Error", "Failed to connect to the chat server.");
        }
    }

    @FXML
    public void sendMessage() {
        String messageText = messageField.getText();
        if (!messageText.isBlank()) {
            Message message = new Message(doctorEmail, "patient@example.com", messageText);
            try {
                chatClient.sendMessage(message);
            } catch (IOException ex) {
                Logger.getLogger(DoctorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            chatArea.appendText("Doctor: " + messageText + "\n");
            messageField.clear();
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        chatArea.appendText("Patient: " + message.getContent() + "\n");
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }*/
