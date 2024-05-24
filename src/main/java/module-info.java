module com.example.projet_school_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projet_school_manager to javafx.fxml;
    exports com.example.projet_school_manager;

    opens com.example.projet_school_manager.controllers to javafx.fxml;
    exports com.example.projet_school_manager.controllers;

    opens com.example.projet_school_manager.models to javafx.base;
    exports com.example.projet_school_manager.models;
}