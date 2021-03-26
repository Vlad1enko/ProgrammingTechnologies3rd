package ua.kpi.library.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Library implements LibraryInterface {

    private final AtomicInteger capacity = new AtomicInteger(0);
    private final List<Book> bookList = new ArrayList<>();
    private final String name;


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
        if ( this.capacity.get() > 0) {
            bookList.addAll(bookListNew);
        }
    }

    public boolean addBook(Book bookNew) {
        if (!isEqualBooks(bookNew)) { //add exception
            this.bookList.add(bookNew);
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
            this.bookList.remove(index);
            this.capacity.decrementAndGet();
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isEqualBooks(Book bookNew) {
        return this.bookList.contains(bookNew);
    }                               

    public ArrayList<Book> getBookList() { return (ArrayList<Book>) this.bookList; }

    public int getCapacity() { return this.capacity.get(); }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder("Library: \"");
        strBuffer.append(this.name).append("\"\n");
        for (int i = 0; i < this.capacity.get(); i++) {
            strBuffer.append(this.bookList.get(i).toString()).append('\n');
        }
        return strBuffer.toString();
    }

    public Optional<Book> findBookInLibrary(String bookTitle) {
        return bookList.stream().filter(book -> bookTitle.equals(book.getTitle()))
                .findAny();
    }

    public double calculateTotalCost() {
        return bookList.stream().mapToDouble(Book::getCost).sum();
    }

    public Optional<Book> findTheMostExpensiveBook() {
        return bookList.stream().max(Comparator.comparing(Book::getCost));
    }

    public Double calculateAverageCostOfBooks() {
        return bookList.stream().mapToDouble(Book::getCost).average().orElseThrow(ArithmeticException::new);
    }

    public Map<Boolean, List<Book>> searchBookByGenre(BookGenreEnum genre) {
        return bookList.stream().collect(partitioningBy(book -> genre.equals(book.getGenre())));
    }

    public BookGenreEnum searchTheMostPopularGenre() {
        return bookList.stream().map(Book::getGenre)
                .collect(groupingBy(Function.identity(),counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

}
