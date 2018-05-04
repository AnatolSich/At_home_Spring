package app.controller;

import app.dao.BookDao;
import app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class BookController extends HttpServlet {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "books/{studId}", method = RequestMethod.GET)
    public String getBooksByStudId(@PathVariable int studId, Model model) {
        List<Book> list = bookDao.getBooksByStud(studId);
        model.addAttribute("books", list);
        model.addAttribute("studentId", studId);
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

    @RequestMapping(value = "updateBook/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable int id,
                             Model model){
        model.addAttribute("book", bookDao.getBookById(id));
        return "updateBook";
    }



    @RequestMapping(value = "updateBook/{id}/", method = RequestMethod.POST)
    public String updateBook(@PathVariable int id,
                          @RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("pages") int pages,
                             Model model) {
        Book existBook = bookDao.getBookById(id);
        existBook.setTitle(title);
        existBook.setAuthor(author);
        existBook.setPages(pages);
        int studId = existBook.getStudent().getId();
        model.addAttribute("studId", studId);
        bookDao.updateBook(existBook);
        return "redirect:books/{studId}";
    }

    @RequestMapping (value = "deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id,
                             Model model){
        int studId = bookDao.getBookById(id).getStudent().getId();
        model.addAttribute("studId", studId);
        bookDao.deleteBook(id);
        return "redirect:/books/{studId}";
    }

}
