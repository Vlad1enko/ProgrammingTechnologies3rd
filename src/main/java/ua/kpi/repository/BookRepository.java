package ua.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByTitle(String title);

    List<Book> findBooksByAuthors(Author author);

    List<Book> findBooksByGenre(BookGenreEnum genreEnum);
}
