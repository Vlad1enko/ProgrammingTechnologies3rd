package ua.kpi.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;
import ua.kpi.repository.BookRepository;

import java.util.List;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    private static int serialNumberGenerator = 0;

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

//    @Override
//    public Book updateBookById(Book book){
//        return new Book(book);
//    }

}
