package ua.kpi.library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "authors")
@ToString(exclude = {"books"})
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    protected String name;
    protected String surname;
    private Character sex;
    protected LocalDate dob;

    protected final AtomicInteger numOfBooks = new AtomicInteger(0);

//    public Author() {
//        super();
//    }
//
//    public Author(String name, String surname) {
//        super(name, surname);
//    }
//
//    public Author(String name, String surname, String dob) {
//        super(name, surname, dob);
//    }

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

    public String getDobString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return this.dob.format(formatter);
    }

}
