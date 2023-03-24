/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DoctorController {

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

    void save(ActionEvent event) {
        try {
            String sql = "INSERT INTO doctor  WHERE username = ? and password = ? and role= 'patient' ";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("dermatho", "generaliste", "cardio");
        comb.setItems(list);
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
