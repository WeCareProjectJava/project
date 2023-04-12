/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */
import Client.*;

import java.sql.*;

import javafx.scene.control.Alert;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class AuthenticationController {

    @FXML
    private Button SignIn;

    @FXML
    private PasswordField password;

    @FXML
    private Label signup;

    @FXML
    public TextField username;
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
    void Login(ActionEvent event) {
        connect = connectDb();
        try {
            String sql = "SELECT * FROM users WHERE username = ? and password = ? ";
            statement = connect.prepareStatement(sql);

            statement.setString(1, username.getText());
            statement.setString(2, password.getText());
            Controller.username=this.username.getText();
           


            result = statement.executeQuery();
            if (result.next()) {
                    String name = result.getString("first_name");
                    String email = result.getString("email");
                    String phone = (String)result.getString("phone_number");
                    String pass = result.getString("password");
                    String status = result.getString("role");

                     User x = new User(name,name ,pass,email,"male",phone,status);
                    Controller.users.add(x);

                SignIn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/Room.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);

                stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Wrong UserName/Password", "message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SignUp(MouseEvent event) {

        try {
            signup.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/signUp.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

