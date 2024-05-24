package com.example.projet_school_manager.controllers;

import com.example.projet_school_manager.database.IDBConfig;
import com.example.projet_school_manager.models.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private ComboBox<String> classroomBox;

    @FXML
    private DatePicker birthdayField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField placeOfBirthFieldText;

    @FXML
    private ComboBox<String> stateBox;

    private Connection connection;

    @FXML
    private Label nameSet;
    @FXML
    private Label firstnameSet;
    @FXML
    private Label birthdaySet;
    @FXML
    private Label placeOfBirthSet;
    @FXML
    private Label classroomSet;
    @FXML
    private Label stateSet;
    @FXML
    private VBox detailsBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        detailsBox.setVisible(false);

        try {
            connection = IDBConfig.getConnection();

            if (this.connection != null) {
                String req = "SELECT * FROM Classroom";
                PreparedStatement preparestatement = this.connection.prepareStatement(req);
                ResultSet resultSet = preparestatement.executeQuery();
                while (resultSet.next()) {
                    classroomBox.getItems().add(resultSet.getString("id"));
                }
                preparestatement.close();
                this.connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        stateBox.getItems().add("0");
        stateBox.getItems().add("1");
        stateBox.getItems().add("2");
        stateBox.getItems().add("3");

    }

    public void onregisterClick() {
        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        Date dateOfBirth = Date.valueOf(birthdayField.getValue());
        String placeOfBirth = placeOfBirthFieldText.getText();
        int classroomId = Integer.parseInt(classroomBox.getValue());
        int state = Integer.parseInt(stateBox.getValue());

        if (!firstname.isEmpty() && !lastname.isEmpty()) {
            Student student = new Student();
            student.setFirstname(firstname);
            student.setLastname(lastname);
            student.setDateOfBirth(dateOfBirth);
            student.setPlaceOfBirth(placeOfBirth);
            student.setClassroomId(classroomId);
            student.setState(state);
            student.create(student);

            detailsBox.setVisible(true);
            this.firstnameSet.setText(lastname);
            nameSet.setText(firstname);
            birthdaySet.setText(String.valueOf(dateOfBirth));
            placeOfBirthSet.setText(placeOfBirth);
            classroomSet.setText(String.valueOf(classroomId));
            stateSet.setText(String.valueOf(state));

        }
    }
}
