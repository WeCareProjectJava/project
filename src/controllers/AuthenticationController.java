/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */
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
    private TextField username;
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
            result = statement.executeQuery();
            if (result.next()) {
                //JOptionPane.showMessageDialog(null,"successefully UserName/Password","macroman message",JOptionPane.INFORMATION_MESSAGE);
                SignIn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/chat_interface.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);

                stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Wrong UserName/Password", "macroman message", JOptionPane.ERROR_MESSAGE);
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

/*  @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<UserType> userTypeComboBox;

    private UserServices userService;

    public void initialize() {
        userService = new UserServices();
        userTypeComboBox.getItems().addAll(UserType.values());
        userTypeComboBox.getSelectionModel().select(UserType.PATIENT);
    }
  @FXML
    public void login() {
       // String email = emailField.getText();
       // String password = passwordField.getText();
        //UserType userType = userTypeComboBox.getValue();

        User user = userService.login(email, password, userType);
        if (user != null) {
            openMainView(user);
        } else {
            showErrorAlert("Login Failed", "Invalid email or password.");
        }
    }

    private void openMainView(User user) {
        try {
            FXMLLoader loader;
            if (user instanceof Patient) {
                loader = new FXMLLoader(getClass().getResource("/com/yourpackage/views/patient.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/yourpackage/views/doctor.fxml"));
            }
            Parent root = loader.load();
            Stage stage = (Stage) emailField.getScene().getWindow();

            if (user instanceof Patient) {
                PatientController controller = loader.getController();
                controller.initialize(user.getEmail());
            } else {
                DoctorController controller = loader.getController();
                controller.initialize(user.getEmail());
            }

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showErrorAlert("Error", "Failed to load the main view.");
        }
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
 */
