package app.repo;

import app.model.Book;

import java.util.List;

public interface BookRepoInterface {
    Book getBook(int id);

    List<Book> getAllBooks();

    List<Book> getBooksByStudent(int studentId);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int id);

}
