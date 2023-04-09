/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author eya_o
 */
public class InformationPatient {

    @FXML
    private TextField allergies;

    @FXML
    private TextField bloodType;

    @FXML
    private TextField healthCondition;

    @FXML
    private TextField medicalInsurrance;

    @FXML
    private TextField medications;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button save;

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
    void save(ActionEvent event) {

        connect = connectDb();
        try {

            String sql = "INSERT INTO patient(health_condition,blood_type,allergies,medications,medical_insurrance,name,phone_number) VALUES(?,?,?,?,?,?,?)";
            statement = connect.prepareStatement(sql);

            statement.setString(1, healthCondition.getText());
            statement.setString(2, bloodType.getText());
            statement.setString(3, allergies.getText());
            statement.setString(4, medications.getText());
            statement.setString(5, medicalInsurrance.getText());
            statement.setString(6, name.getText());
            statement.setString(7, phoneNumber.getText());
            int result = statement.executeUpdate();
            if (result > 0) {

                try {
                    System.out.println("okay");
                    save.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/Views/Room.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);

                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } else {

                System.out.println("no");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
