package pl.coderslab.service;

import pl.coderslab.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById();
}
