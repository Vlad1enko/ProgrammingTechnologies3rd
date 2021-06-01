package ua.kpi.library.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;

    public void saveBookOfUser(Integer userId, Book book) {
        userService.getUser(userId).addBook(book);
        bookRepository.save(book);
    }

    public List<Book> getBooksOfUser(Integer userId) {
        List<Book> books = userService.getUser(userId).getBooks();
        Hibernate.initialize(books);
        return books;
    }

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public List<Book> getBooksOfAuthor(Author author) {
        return bookRepository.findBooksByAuthors(author);
    }

    @Override
    public List<Book> getBooksOfGenre(BookGenreEnum genreEnum) {
        return bookRepository.findBooksByGenre(genreEnum);
    }

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void addBookToLibrary(Integer libraryId, Integer bookId) {
        Book book = getBookById(bookId);
    }

    @Override
    public void deleteBook(Integer bookId) {
        try {
            bookRepository.deleteById(bookId);
        } catch (Exception exception) {
            throw new BookNotFoundException(bookId);
        }
    }

}
