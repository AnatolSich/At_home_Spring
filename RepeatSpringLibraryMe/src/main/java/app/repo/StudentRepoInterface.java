package app.repo;

import app.model.Student;

import java.util.List;

public interface StudentRepoInterface {
    Student getStudent(int id);
    List<Student> getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);

}
