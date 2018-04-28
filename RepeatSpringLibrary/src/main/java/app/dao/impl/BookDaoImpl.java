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
    SessionFactory sessionFactory;

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if (book == null) {
            throw new RuntimeException("No book by inserted id");
        } else return book;
    }

    @Override
    public List getBooksByStud(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book b WHERE b.student.id=:studentId")
                .setParameter("studentId", studentId).list();
    }

    @Override
    public void addBook(Book book, int studentId) {
        Session session = sessionFactory.getCurrentSession();
        book.setStudent(session.get(Student.class, studentId));
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book bookExist = session.get(Book.class, book.getId());
        if (bookExist == null) {
            throw new RuntimeException("No book by inserted id");
        } else {
            bookExist.setTitle(book.getTitle());
            bookExist.setAuthor(book.getAuthor());
            bookExist.setPages(book.getPages());

            session.saveOrUpdate(bookExist);
        }
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book bookExist = session.get(Book.class, id);
        if (bookExist == null) {
            throw new RuntimeException("No book by inserted id");
        } else {
            session.delete(bookExist);
        }
    }
}
