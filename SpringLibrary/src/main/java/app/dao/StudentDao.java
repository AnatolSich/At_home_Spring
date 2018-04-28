package app.dao;

import app.model.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    Student getStudent(Integer id);

    List getStudents();

    void removeStudent(Integer id);

    void updateStudent(Student student);
}
