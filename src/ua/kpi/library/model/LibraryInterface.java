package ua.kpi.library.model;


import java.util.ArrayList;
import java.util.List;

public interface LibraryInterface {

    boolean addBook(Book bookNew);

    public void addOneMoreBook(List<Book> bookListNew);

    boolean deleteBook(int index);

    boolean isEqualBooks(Book bookNew);

    ArrayList<Book> getBookList();

    int getCapacity();

    String toString();

}
