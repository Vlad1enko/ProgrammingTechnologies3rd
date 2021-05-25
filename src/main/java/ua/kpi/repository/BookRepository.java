package ua.kpi.repository;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.library.exception.BookNotFoundException;
import ua.kpi.library.model.Author;
import ua.kpi.library.model.Book;
import ua.kpi.library.model.BookGenreEnum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.of;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);
}
