package ua.kpi.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Setter
    private String name;

    @Column(nullable = false)
    @Setter
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private final List<Book> books = new LinkedList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<Order> orders = new LinkedList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final List<Role> roles = new LinkedList<>();

    public User(String name, Integer age, List<Book> books, List<Role> roles) {
        this.name = name;
        this.age = age;
        setBooks(books);
        setRoles(roles);
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setUser(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setUser(null);
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

    public void setBooks(List<Book> books) {
        if (books != null)
            books.forEach(this::addBook);
    }

    public void setRoles(List<Role> roles) {
        if (roles != null)
            roles.forEach(this::addRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                ", orders=" + orders +
                ", roles=" + roles +
                '}';
    }
}
