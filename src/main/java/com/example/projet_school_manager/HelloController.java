package com.example.projet_school_manager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private StackPane studentBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("student.fxml")));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        studentBox.getChildren().removeAll();
        studentBox.getChildren().setAll(root);

    }
}