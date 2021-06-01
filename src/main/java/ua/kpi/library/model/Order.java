package ua.kpi.library.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @Setter
    private Book book;

    @Setter
    private Integer amount;

    @Setter
    private Status status;

    public Order(User user, Book book, Integer amount, Status status) {
        this.user = user;
        this.book = book;
        this.amount = amount;
        this.status = status;
    }
}
