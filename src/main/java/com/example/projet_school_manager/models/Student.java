package com.example.projet_school_manager.models;

import com.example.projet_school_manager.database.IDBConfig;
import com.example.projet_school_manager.interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student implements StudentInterface {

    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String placeOfBirth;
    private int classroomId;
    private int state;
    private Connection connection;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public void create(Student student) {

    try {
        connection = IDBConfig.getConnection();

        if (this.connection != null) {

            String request = "INSERT INTO Student (firstname, lastname, dateOfBirth, placeOfBirth, classroomId, state) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = this.connection.prepareStatement(request);
            prepareStatement.setString(1, student.getFirstname());
            prepareStatement.setString(2, student.getLastname());
            prepareStatement.setDate(3, student.getDateOfBirth());
            prepareStatement.setString(4, student.getPlaceOfBirth());
            prepareStatement.setInt(5, student.getClassroomId());
            prepareStatement.setInt(6, student.getState());

            prepareStatement.executeUpdate();

            prepareStatement.close();
            this.connection.close();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }

    @Override
    public void read(int id) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
