package app.dao;

import app.model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book, int studentId);

    Book getBook(Integer id);

    List getBooksByStudId(Integer studentId);

    void removeBook(Integer id);

    void updateBook(Book book);
}
