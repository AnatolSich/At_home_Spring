package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudent();
    Student getStudent(int id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
