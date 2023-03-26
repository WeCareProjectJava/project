/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author eya_o
 */
public class PatientController {

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private Button open;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField username;

    @FXML
    private ComboBox combo;

    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("doctor", "patient");
        combo.setItems(list);
    }

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
    void Open(ActionEvent event) {

        String selectValue = (String) combo.getSelectionModel().getSelectedItem();

        connect = connectDb();
        try {

            String sql = "INSERT INTO users(first_name,last_name,email,password,username,phone_number,role) VALUES(?,?,?,?,?,?,?)";
            statement = connect.prepareStatement(sql);

            statement.setString(1, firstName.getText());
            statement.setString(2, lastName.getText());
            statement.setString(3, email.getText());
            statement.setString(4, password.getText());
            statement.setString(5, username.getText());
            statement.setString(6, phoneNumber.getText());
            statement.setString(7, selectValue);
            int result = statement.executeUpdate();
            if (result > 0) {
                if (selectValue == "patient") {
                    try {

                        open.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("/Views/PatientSignUp.fxml"));

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();

                        stage.setScene(scene);

                        stage.show();
     
                        

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else if (selectValue == "doctor") {
                    try {
                        open.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("/Views/hello-view.fxml"));

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();

                        stage.setScene(scene);

                        stage.show();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                System.out.println("okay");
            } else {
                System.out.println("no");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
