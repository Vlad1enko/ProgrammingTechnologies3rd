package ua.kpi.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@ToString(exclude = {"authors", "library"})
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long serialNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    private String title;
    private int year;
    private String publisher;
    private double cost;
    @Enumerated(EnumType.STRING)
    private BookGenreEnum genre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

//    public Book(long serialNumber) {
//        this.serialNumber = serialNumber;
//        this.author = new Author();
//        this.author.incrementNumOfBooks();
//        this.title = "Title";
//        this.year = 1970;
//        this.publisher = "Unknown";
//        this.cost = 4.99;
//        this.genre = BookGenreEnum.CLASSICS;
//    }
//
//    public Book(long serialNumber, Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre) {
//        this.serialNumber = serialNumber;
//        this.author = authorNew;
//        this.author.incrementNumOfBooks();  //located in this library
//        this.title = titleNew;
//        this.year = yearNew;
//        this.publisher = publisherNew;
//        this.cost = costNew;
//        this.genre = genre;
//    }
//
//    public Book(Book book) {
//        this.serialNumber = book.serialNumber;
//        this.author = book.author;
//        this.author.incrementNumOfBooks();  //located in this library
//        this.title = book.title;
//        this.year = book.year;
//        this.publisher = book.publisher;
//        this.cost = book.cost;
//        this.genre = book.genre;
//    }

}
