package ua.kpi.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

@Entity
@Table(name = "libraries")
@ToString(exclude = {"books"})
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final AtomicInteger capacity = new AtomicInteger(0);

    @OneToMany(mappedBy = "library", orphanRemoval = false)
    private final List<Book> books = new ArrayList<>();

    private String name;


    static class BooksEqualException extends RuntimeException {

        public BooksEqualException(String message){
            super(message);
        }

    }

    public Library(String nameNew) {
        this.name = nameNew;
    }

    public Library(String nameNew, List<Book> bookListNew) {
        this.name = nameNew;
        this.capacity.set(bookListNew.size());
        books.addAll(bookListNew);
    }

    public boolean addBook(Book bookNew) {
        if (!isEqualBooks(bookNew)) { //add exception
            this.books.add(bookNew);
            this.capacity.incrementAndGet();
            return true;
        } else {
            throw new BooksEqualException("BooksEqualException with " + bookNew.toString());
        }
    }

    public void addOneMoreBook(List<Book> bookListNew) {
        for (Book book : bookListNew) {
            this.addBook(book);
        }
    }

    public boolean deleteBook(int index) {    //add exception
        try {
            this.books.remove(index);
            this.capacity.decrementAndGet();
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isEqualBooks(Book bookNew) {
        return this.books.contains(bookNew);
    }                               

    public ArrayList<Book> getBooks() { return (ArrayList<Book>) this.books; }

    public int getCapacity() { return this.capacity.get(); }

    public Optional<Book> findBookInLibrary(String bookTitle) {
        return books.stream().filter(book -> bookTitle.equals(book.getTitle()))
                .findAny();
    }

    public double calculateTotalCost() {
        return books.stream().mapToDouble(Book::getCost).sum();
    }

    public Optional<Book> findTheMostExpensiveBook() {
        return books.stream().max(Comparator.comparing(Book::getCost));
    }

    public Double calculateAverageCostOfBooks() {
        return books.stream().mapToDouble(Book::getCost).average().orElseThrow(ArithmeticException::new);
    }

    public Map<Boolean, List<Book>> searchBookByGenre(BookGenreEnum genre) {
        return books.stream().collect(partitioningBy(book -> genre.equals(book.getGenre())));
    }

    public BookGenreEnum searchTheMostPopularGenre() {
        return books.stream().map(Book::getGenre)
                .collect(groupingBy(Function.identity(),counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

}
