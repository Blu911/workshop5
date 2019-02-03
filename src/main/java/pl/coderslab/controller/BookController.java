package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.JsonRespone;
import pl.coderslab.domain.dto.BookDto;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    ///----------------Testing
    @RequestMapping("/hello")
    public String hello() {
        return "{hello:Hello World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    ///----------------Book Controller
    @Autowired
    BookService service;

    @RequestMapping("")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Book addBook(@RequestBody BookDto book) {
        return service.addBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Book updateBookById(@PathVariable long id, @RequestBody BookDto book) {
        return service.updateBookById(id, book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonRespone deleteBookById(@PathVariable long id) {
        return service.deleteBookById(id);
    }
}
