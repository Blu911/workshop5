package pl.coderslab.service;

import pl.coderslab.domain.Book;
import pl.coderslab.domain.JsonRespone;
import pl.coderslab.domain.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(long book_id);
    Book addBook(BookDto book);
    Book updateBookById(long book_id, BookDto book);
    JsonRespone deleteBookById(long book_id);
}
