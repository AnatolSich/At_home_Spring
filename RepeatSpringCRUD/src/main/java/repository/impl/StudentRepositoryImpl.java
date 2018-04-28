package repository.impl;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class, id));
    }
}
