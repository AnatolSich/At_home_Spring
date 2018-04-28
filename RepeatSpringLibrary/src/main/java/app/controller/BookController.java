package app.controller;

import app.dao.BookDao;
import app.model.Book;
import app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class BookController extends HttpServlet {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public String getBooksByStudId(@PathVariable int id, Model model) {
        List<Book> list = bookDao.getBooksByStud(id);
        model.addAttribute("books", list);
        return "listBooks";
    }

    @RequestMapping(value = "addBook/{studId}", method = RequestMethod.GET)
    public String addBook(@PathVariable int studId, Model model) {
        model.addAttribute("studentId", studId);
        return "addBook";
    }

    @RequestMapping(value = "addBook/{studId}", method = RequestMethod.POST)
    public String addBook(@PathVariable int studId,
                          @RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("pages") int pages) {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPages(pages);
        bookDao.addBook(newBook, studId);
        return "redirect:books/{studId}";
    }


}
