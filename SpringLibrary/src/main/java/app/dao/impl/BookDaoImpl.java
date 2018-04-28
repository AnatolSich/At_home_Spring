package app.dao.impl;

import app.dao.BookDao;
import app.model.Book;
import app.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book, int studentId) {
        Session session = sessionFactory.getCurrentSession();
        book.setStudent(session.get(Student.class, studentId));
        session.persist(book);
    }

    @Override
    public Book getBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public List getBooksByStudId(Integer studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book b WHERE b.student.id=:studentId").setParameter("studentId", studentId).list();
    }

    @Override
    public void removeBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if(book != null){
            session.delete(book);
        }
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book existingBook = session.get(Book.class, book.getId());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPages(book.getPages());
        session.saveOrUpdate(session);
    }
}
