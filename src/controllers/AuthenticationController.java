/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author eya_o
 */


//import com.wecare.services.AuthenticationService;
/*import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController {

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField registerUsername;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private AuthenticationService authenticationService;

    public AuthenticationController() {
        authenticationService = new AuthenticationService();
    }

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> handleLogin());
        registerButton.setOnAction(event -> handleRegister());
    }

    private void handleLogin() {
        String username = loginUsername.getText().trim();
        String password = loginPassword.getText();

        if (authenticationService.login(username, password)) {
            // Redirect to the patient or doctor dashboard based on the user role
        } else {
            showAlert(Alert.AlertType.ERROR, "Login failed", "Incorrect username or password.");
        }
    }

    private void handleRegister() {
        String username = registerUsername.getText().trim();
        String password = registerPassword.getText();

        if (authenticationService.register(username, password)) {
            // Redirect to the patient or doctor registration form
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration failed", "Username already exists.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
*/
