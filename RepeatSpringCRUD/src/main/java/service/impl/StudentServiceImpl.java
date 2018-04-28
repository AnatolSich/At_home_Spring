package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student getStudent(int id) {
        if (id != 0)
            return studentRepository.getStudent(id);
        else throw new RuntimeException("ID is not valid");
    }

    @Override
    public void addStudent(Student student) {
        if (student != null) {
            studentRepository.addStudent(student);
        } else throw new RuntimeException("Student is null");
    }

    @Override
    public void updateStudent(Student student) {
        if (student != null) {
            studentRepository.updateStudent(student);
        } else throw new RuntimeException("Student is null");
    }

    @Override
    public void deleteStudent(int id) {
        if (id != 0) {
            studentRepository.deleteStudent(id);
        } else throw new RuntimeException("ID is not valid");
    }
}
