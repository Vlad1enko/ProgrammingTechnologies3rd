package ua.kpi.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private final List<User> users = new LinkedList<>();

    public void addUser(User user) {
        user.addRole(this);
    }

    public void removeUser(User user) {
        user.removeRole(this);
    }
}
