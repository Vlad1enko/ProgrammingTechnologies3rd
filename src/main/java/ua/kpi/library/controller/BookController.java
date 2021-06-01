package ua.kpi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.library.model.Book;
import ua.kpi.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void createBook(@RequestParam Integer userId, @RequestBody Book book) {
        bookService.saveBookOfUser(userId, book);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/user/{userId}")
    public List<Book> getBookOfUser(@PathVariable Integer userId) {
        return bookService.getBooksOfUser(userId);
    }

    @PostMapping("/add_to_set")
    public void addBookToLibrary(@RequestParam Integer libraryId, @RequestParam Integer bookId) {
        bookService.addBookToLibrary(libraryId, bookId);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}
