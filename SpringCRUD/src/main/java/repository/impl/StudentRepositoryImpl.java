package repository.impl;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }
    @Override
    public void removeStudent(Integer id) {
        if (id != null) {
            Session session = sessionFactory.getCurrentSession();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
        } else throw new RuntimeException("Id is null");
    }
    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existingStudent = session.get(Student.class, student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setExtramural(student.getExtramural());
        session.update(existingStudent);
    }
    @Override
    public List<Student> getAllStud() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Student>) session.createQuery("from Student").list();
    }
    @Override
    public Student getStudent(Integer id) {
        if (id != null) {
            Session session = sessionFactory.getCurrentSession();
            return session.get(Student.class, id);
        } else throw new RuntimeException("Id is null");
    }
}
