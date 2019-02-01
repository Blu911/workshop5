package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.domain.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.impl.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping("hello")
    public String hello(){
        return "{hello:Hello World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @Autowired
    BookService service;

    @RequestMapping("")
    public List<Book> getAll(){
        return service.getAllBooks();
    }
}