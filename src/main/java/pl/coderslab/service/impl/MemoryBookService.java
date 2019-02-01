package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.domain.Book;
import pl.coderslab.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {

    private List<Book> books;
    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    @Override
    public List<Book> getAllBooks() {return books;}

    @Override
    public Book getBookById() {
        return null;
    }

}
