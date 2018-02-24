package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {

    void addStudent(Student student);

    void removeStudent(Integer id);

    void updateStudent(Student student);

    List getAllStud();

    Student getStudent(Integer id);
}
