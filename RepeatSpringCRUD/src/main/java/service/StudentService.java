package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudent(int id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}

