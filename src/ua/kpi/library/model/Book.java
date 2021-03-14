package ua.kpi.library.model;

public class Book {

    private final long serialNumber;
    private Author author;
    private String title;
    private int year;
    private String publisher;
    private double cost;
    private BookGenreEnum genre;

    public Book(long serialNumber) {
        this.serialNumber = serialNumber;
        this.author = new Author();
        this.author.incrementNumOfBooks();
        this.title = "Title";
        this.year = 1970;
        this.publisher = "Unknown";
        this.cost = 4.99;
        this.genre = BookGenreEnum.CLASSICS;
    }

    public Book(long serialNumber, Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre) {
        this.serialNumber = serialNumber;
        this.author = authorNew;
        this.author.incrementNumOfBooks();  //located in this library
        this.title = titleNew;
        this.year = yearNew;
        this.publisher = publisherNew;
        this.cost = costNew;
        this.genre = genre;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public double getCost() {
        return this.cost;
    }

    public BookGenreEnum getGenre() {
        return this.genre;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGenre(BookGenreEnum genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder(genre.toString()); //smart memory allocation
        strBuffer.append(" book: \"");
        strBuffer.append(this.title);
        strBuffer.append("\" of ");
        strBuffer.append(this.author);
        strBuffer.append(" was published in ");
        strBuffer.append(this.year);
        strBuffer.append(".");
        strBuffer.append(" sNum: ");
        strBuffer.append(this.serialNumber);
        return strBuffer.toString();
    }

}
