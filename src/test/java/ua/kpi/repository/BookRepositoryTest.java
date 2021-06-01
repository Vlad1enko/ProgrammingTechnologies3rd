package ua.kpi.repository;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void should_save_book_in_db() {
        Book book = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();

        bookRepository.save(book);
        Book shouldBeFound = bookRepository.findById(book.getId()).orElse(null);

        assertEquals(book, shouldBeFound);
    }

    @Test
    void should_return_false_when_find_by_wrong_id() {
        assertFalse(bookRepository.findById(-1).isPresent());
    }

    @Test
    void should_update_content_of_model_in_db() {
        Book book = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        bookRepository.save(book);
        book.setTitle("Tested title");
        book.setCost(18.99);

        Book shouldBeFound = bookRepository.save(book);

        assertEquals(book, shouldBeFound);
    }

    @Test
    void should_find_all_books_after_addition() {
        Book book1 = Book.builder().title("The miracle").genre(BookGenreEnum.ADVENTURE).cost(9.99).publisher("123").build();
        Book book2 = Book.builder().title("The miracle2").genre(BookGenreEnum.BUSINESS).cost(19.99).publisher("123").build();

        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> shouldBeFound = bookRepository.findAll();

        MatcherAssert.assertThat(shouldBeFound, hasItems(book1, book2));
        MatcherAssert.assertThat(shouldBeFound, not(IsEmptyCollection.empty()));
    }
}