package ua.kpi.library.service;

import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.repository.BookRepository;

import java.util.List;

import static java.util.Optional.of;

public class BookServiceImpl implements BookService{
    BookRepository bookRepository;
    private static int serialNumberGenerator = 0;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks(){
        return bookRepository.getAllBooks();
    }

    @Override
    public Book getBookByTitle(String title){
        return of(title)
                .map(t -> this.getBooks().stream()
                        .filter(book -> book.getTitle().equals(t))
                        .findAny()
                        .orElseThrow(() -> new BookNotFoundException(title))

                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }

    @Override
    public Book createBook(Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre){
        return new Book(serialNumberGenerator++, authorNew, titleNew, yearNew, publisherNew, costNew, genre);
    }

    @Override
    public Book getBookById(long id){
        return of(id)
                .map(i -> this.getBooks().stream()
                        .filter(book -> book.getSerialNumber() == i)
                        .findAny()
                        .orElseThrow(() -> new BookNotFoundException(id))

                ).orElseThrow(() -> new RuntimeException("Exception that should never have happened"));
    }

    @Override
    public Book updateBookById(Book book){
        return new Book();
    }

}
