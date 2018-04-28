package app.dao;

import app.model.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentById(int id);
    List getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
