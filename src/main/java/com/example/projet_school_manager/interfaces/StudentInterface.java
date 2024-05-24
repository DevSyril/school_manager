package com.example.projet_school_manager.interfaces;

import com.example.projet_school_manager.models.Student;

public interface StudentInterface {
    void create(Student student);
    void read(int id);
    void update(Student student);
    void delete(int id);

}
