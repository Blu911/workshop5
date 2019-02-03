package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.JsonRespone;
import pl.coderslab.domain.dto.BookDto;
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
    public List<Book> getAllBooks() {
        return books;
    }

    @Override

    public Book getBookById(long book_id) {
        return getAllBooks().stream().filter(item -> item.getId().equals(book_id)).findAny().get();

    }

    @Override
    public Book addBook(BookDto book) {
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) throw new RuntimeException("No author");
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) throw new RuntimeException("No ISBN");
        if (book.getPublisher() == null || book.getPublisher().isEmpty()) throw new RuntimeException("No publisher");
        if (book.getTitle() == null || book.getTitle().isEmpty()) throw new RuntimeException("No title");
        if (book.getType() == null || book.getType().isEmpty()) throw new RuntimeException("No type");
        Book lastBook = getAllBooks().stream().min((b1, b2) -> b2.getId().compareTo(b1.getId())).get();
        Book addedBook = new Book(lastBook.getId() + 1, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getType());
        getAllBooks().add(addedBook);
        return addedBook;
    }

    @Override
    public Book updateBookById(long book_id, BookDto book) {
        Book bookToUpdate = getBookById(book_id);
        if (bookToUpdate != null) {
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setPublisher(book.getPublisher());
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setType(book.getType());
        }
        return bookToUpdate;
    }

    @Override
    public JsonRespone deleteBookById(long book_id) {
        if (books.removeIf(item -> book_id == item.getId())) {
            return new JsonRespone("success", "Book with ID: " + book_id + " deleted");
        }
        return new JsonRespone("error", "Book not found");
    }

}
