package ua.kpi.library.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Author extends Person {
    protected final AtomicInteger numOfBooks = new AtomicInteger(0);

    public Author() {
        super();
    }

    public Author(String name, String surname) {
        super(name, surname);
    }

    public Author(String name, String surname, String dob) {
        super(name, surname, dob);
    }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder(this.name + " " + this.surname);
        return strBuffer.toString();
    }

    public void incrementNumOfBooks() {
        this.numOfBooks.incrementAndGet();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Author guest = (Author) obj;
        return name.equals(guest.name) && surname.equals(guest.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public int getNumberOfBooks() { return this.numOfBooks.get(); }
}
