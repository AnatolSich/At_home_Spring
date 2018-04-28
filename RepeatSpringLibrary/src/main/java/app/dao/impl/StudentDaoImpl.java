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
public class StudentDaoImpl implements StudentDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class,id);
        if(student==null){
            throw new RuntimeException("No student by inserted id");
        }
        else return student;
    }

    @Override
    public List getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from student").list();
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student studentExist =  session.get(Student.class,student.getId());
        studentExist.setAge(student.getAge());
        studentExist.setName(student.getName());
        studentExist.setIsAdmin(student.getIsAdmin());
        studentExist.setRegDate(student.getRegDate());
        session.saveOrUpdate(studentExist);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class,id);
        if(student==null){
            throw new RuntimeException("No student by inserted id");
        }
        else session.delete(student);
    }
}
