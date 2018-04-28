package app.dao.impl;

import app.dao.StudentDao;
import app.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public Student getStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();
    }

    @Override
    public void removeStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existingStudent = session.get(Student.class, student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setCreatedDate(student.getCreatedDate());
        session.saveOrUpdate(student);
    }

}
