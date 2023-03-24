/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */


import Services.ChatClient;
import  Services.ChatListener;
import models.Message;
import Services.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientController  {
    /*@FXML
    private TextArea chatArea;
    @FXML
    private TextField messageField;

    private ChatClient chatClient;
    private String patientEmail;

    public void initialize(String patientEmail) {
        this.patientEmail = patientEmail;

        try {
            chatClient = new ChatClient("localhost", 3000, this);
            chatClient.connect(patientEmail, UserType.PATIENT);
        } catch (IOException e) {
            showErrorAlert("Connection Error", "Failed to connect to the chat server.");
        }
    }

    @FXML
    public void sendMessage() {
        String messageText = messageField.getText();
        if (!messageText.isBlank()) {
            Message message = new Message(patientEmail, "doctor@example.com", messageText);
            try {
                chatClient.sendMessage(message);
            } catch (IOException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            chatArea.appendText("Patient: " + messageText + "\n");
            messageField.clear();
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        chatArea.appendText("Doctor: " + message.getContent() + "\n");
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }*/
}

