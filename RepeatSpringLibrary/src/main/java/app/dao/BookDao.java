package app.dao;

import app.model.Book;

import java.util.List;

public interface BookDao {

    Book getBookById(int id);
    List getBooksByStud(int studentId);
    void addBook(Book book, int studentId);
    void updateBook(Book book);
    void deleteBook(int id);

}
